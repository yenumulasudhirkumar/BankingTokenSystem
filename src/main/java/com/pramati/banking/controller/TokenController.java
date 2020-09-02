package com.pramati.banking.controller;

import com.pramati.banking.constants.SwaggerConstants;
import com.pramati.banking.dto.ResponseDto;
import com.pramati.banking.dto.TokenDto;
import com.pramati.banking.entity.TokenStatus;
import com.pramati.banking.service.TokenService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController extends ApiController {

  private final TokenService tokenService;

  @ApiResponses(value = {
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_200, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_200),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_401, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_401),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_403, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_403),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_404, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_404) })
  @ApiOperation("Api method to Generate Token for a Service Request")
  @PostMapping("/tokens")
  public ResponseEntity<ResponseDto<TokenDto>> generateToken(@RequestBody TokenDto tokenDto) {

    return response("Token generated successfully", HttpStatus.OK,tokenService.generateToken(tokenDto));
  }



  @ApiResponses(value = {
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_200, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_200),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_401, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_401),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_403, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_403),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_404, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_404) })
  @ApiOperation("Api method to update Token for a Service Request")
  @PostMapping("/tokens/{tokenId}")
  public ResponseEntity<ResponseDto<TokenDto>> updateToken(@RequestBody TokenDto tokenDto,
                                                           @PathVariable("tokenId") Integer tokenId) {

    return response("Token generated successfully", HttpStatus.OK,tokenService.updateToken(tokenDto));
  }

  @ApiResponses(value = {
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_200, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_200),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_401, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_401),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_403, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_403),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_404, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_404) })
  @ApiOperation("Api method to update Token status for a Service Request")
  @PostMapping("/tokens/{tokenId}/status")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<ResponseDto<String>> updateTokenStatus(@RequestParam TokenStatus tokenStatus,
                                                               @PathVariable("tokenId") Integer tokenId) {

    tokenService.updateTokenStatus(tokenId, tokenStatus);
    return response("Token generated successfully", HttpStatus.OK,"");
  }




}
