package com.pramati.banking.service.impl;

import com.pramati.banking.converter.CounterConverter;
import com.pramati.banking.dto.CounterDto;
import com.pramati.banking.entity.BankService;
import com.pramati.banking.entity.Counter;
import com.pramati.banking.entity.Token;
import com.pramati.banking.entity.TokenStatus;
import com.pramati.banking.exception.CounterException;
import com.pramati.banking.repository.CounterRepository;
import com.pramati.banking.repository.CounterServiceRepository;
import com.pramati.banking.repository.TokenServiceRepository;
import com.pramati.banking.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {

  private final CounterRepository counterRepository;

  private final CounterServiceRepository counterServiceRepository;
  private final BankServiceImpl bankService;
  private final CounterConverter counterConverter;
  private final TokenServiceRepository tokenServiceRepository;


  @Autowired
  private  TokenServiceImpl tokenService;


  /**
   * Service method to get Counter based on the services and queue size.
   * @param bankServices bankServices
   * @return counter Id.
   */
  @Override
  public Integer getCounterForTokenServices(Set<BankService> bankServices) {

    List<com.pramati.banking.entity.Service> services = bankService.getAllBankServices();
    Set<Integer> serviceIds = services.stream().filter(service -> bankServices.contains(service.getServiceName()))
        .map(com.pramati.banking.entity.Service::getId).collect(Collectors.toSet());


    List<Integer> countersList = counterServiceRepository.findCounterByServiceIds(serviceIds);
    if (countersList.size() == 0) {
      return 1;
    } else {
      return countersList.stream().map(this::getCounterById).min(Comparator.comparing(Counter::getQueueSize)).map(Counter::getId)
          .orElseThrow(() -> new CounterException(""));
    }
  }

  public Counter getCounterById(Integer counterId) {
    return counterRepository.findById(counterId).orElseThrow(() -> new CounterException("asds"));
  }

  /**
   * Process next customer.
   * @param counterId counterId.
   */
  public void processNextCustomer(Integer counterId) {

    Token token = tokenService.getNextTokenForProcessing(counterId);
    token.getTokenServiceMappings().forEach(tsm -> {

      // If the service invloves mutiple counters to traverse.
      if (tsm.getService().isMultiCounterService()) {

        Set<Integer> serviceIds = new HashSet<>();
        serviceIds.add(tsm.getService().getMappingStatusId());
        List<Integer> countersList = counterServiceRepository.findCounterByServiceIds(serviceIds);
        processNextCustomer(countersList.size() > 0 ? countersList.get(0) : 1);

      } else {
        tsm.setTokenServiceStatus("COMPLETED");
        tsm.setCounter(Counter.builder().id(counterId).build());
      }
    });


    token.setComments("Service completed");
    token.setTokenStatus(TokenStatus.COMPLETED);
    tokenService.saveToken(token);
    Counter c = getCounterById(counterId);
    c.setQueueSize(c.getQueueSize() - 1);
    counterRepository.save(c);
  }

  /**
   * Service method to get all counter details.
   * @return List Counters
   */
  public List<CounterDto> getAllCounters() {
    List<CounterDto> counterDtos = new ArrayList<>();
    counterRepository.findAll().forEach(counter -> {

      CounterDto counterDto = counterConverter.buildDtoFromEntity(counter);
      counterDto.setTokenIdsList(tokenServiceRepository.findDistinctByCounter(counter.getId()));
      counterDtos.add(counterDto);
    });
    return counterDtos;
  }

}
