package gestion.finanzas.personales.gfp.exception;

import gestion.finanzas.personales.gfp.enums.ErrorCodes;

public class ExceptionUserNotAuthorized extends CustomException{
    public ExceptionUserNotAuthorized() {
        super("El usuario no esta autorizado", ErrorCodes.USUARIO_NO_AUTORIZADO);
    }
}
