package com.example.wypozyczalnia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Pod przesłanym Id nie istnieje żaden użytkownik!")
public class UserNotExistException extends RuntimeException{
}
