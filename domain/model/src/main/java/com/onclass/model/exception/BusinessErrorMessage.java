package com.onclass.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BusinessErrorMessage {
    BOOTCAMP_NOT_FOUND("Bootcamp no existe", 404),
    BOOTCAMP_ALREADY_EXISTS("Bootcamp ya existe", 400),
    UNEXPECTED_EXCEPTION("Sucedió un error inesperado", 500),
    NAME_CHARACTERS_EXCEED("El nombre no debe exceder los 50 carácteres", 404),
    BOOTCAMP_NAME_DUPLICATE ("Nombre del Bootcamp duplicado.",404),
    MANDATORY_NAME("El nombre es obligatorio",404),
    MANDATORY_DESCRIPTION("La descripción es obligatoria",404),
    DESCRIPTION_CHARACTERS_EXCEED("La descripción no debe superar los 90 carácteres",404),
    INVALID_PAGE_NUMBER("La página debe ser mayor o igual a 0", 404),
    INVALID_PAGE_SIZE("La cantidad de datos debe ser mayor 0", 404),
    INVALID_SORT_ORDER("Debe elegir si quiere ordenar de forma ascedente o descendente", 404),
    INVALID_BOOTCAMP_COUNT("Debe tener mínimo 4 capacidades asociadas hasta 20 máximo",404 );
    private final String message;
    private final int httpStatusCode;
}
