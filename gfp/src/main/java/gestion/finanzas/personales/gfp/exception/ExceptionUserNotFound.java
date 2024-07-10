package gestion.finanzas.personales.gfp.exception;

import gestion.finanzas.personales.gfp.enums.ErrorCodes;

public class ExceptionUserNotFound extends CustomException{
    public ExceptionUserNotFound() {
        super("El usuario no existe", ErrorCodes.USUARIO_NO_ENCONTRADO);
    }
}