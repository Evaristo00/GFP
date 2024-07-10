package gestion.finanzas.personales.gfp.exception;

import gestion.finanzas.personales.gfp.enums.ErrorCodes;
import lombok.Getter;

public abstract class CustomException extends RuntimeException {

    @Getter
    private ErrorCodes errorCode;

    CustomException(String message, ErrorCodes errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
