package com.example.wypozyczalnia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Wypożyczenie z takim numerem ID nie istnieje")
public class AssetNotExistException extends  RuntimeException{
}
