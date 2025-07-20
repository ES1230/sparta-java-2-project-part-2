package com.sparta.shopping.common.exception;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ServiceException extends RuntimeException {

  String code;
  String message;

  public ServiceException(ServiceExceptionCode response)  {
    this.code = response.name();
    this.message = super.getMessage();
  }

  @Override
  public String getMessage() {
    return message;
  }

}

