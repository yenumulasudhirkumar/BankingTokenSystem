package com.pramati.banking.converter;

import com.pramati.banking.dto.CounterDto;
import com.pramati.banking.entity.Counter;
import org.springframework.stereotype.Component;

@Component
public class CounterConverter {

  public CounterDto buildDtoFromEntity(Counter counter) {
    return CounterDto.builder().counterId(counter.getId())
    .queueSize(counter.getQueueSize()).counterServiceType(counter.getCounterServiceType()).build();
  }
}
