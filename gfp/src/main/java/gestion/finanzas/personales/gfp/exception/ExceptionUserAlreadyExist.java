package gestion.finanzas.personales.gfp.exception;

import gestion.finanzas.personales.gfp.enums.ErrorCodes;

public class ExceptionUserAlreadyExist extends CustomException{
    public ExceptionUserAlreadyExist() {
        super("Este usuario ya existe", ErrorCodes.USUARIO_YA_CREADO);
    }
}
