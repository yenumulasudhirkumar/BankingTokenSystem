package com.pramati.banking.controller;

import com.pramati.banking.dto.CounterDto;
import com.pramati.banking.dto.ResponseDto;
import com.pramati.banking.service.impl.CounterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CounterController extends ApiController {

  private final CounterServiceImpl counterService;

  @GetMapping("/counters/{counterId}/token")
  public ResponseEntity<ResponseDto<String>> processNextToken(@PathVariable("counterId") Integer counterId) {
    counterService.processNextCustomer(counterId);
    return response("Token processed successfully", HttpStatus.OK,"");
  }

  @GetMapping("/counters")
  public ResponseEntity<ResponseDto<List<CounterDto>>> getAllCounters() {
    return response("Token processed successfully", HttpStatus.OK,
        counterService.getAllCounters());
  }

}
