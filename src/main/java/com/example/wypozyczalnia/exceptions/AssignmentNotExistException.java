package com.example.wypozyczalnia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak wypożyczenia o wskazanym id")
public class AssignmentNotExistException extends RuntimeException{
}
