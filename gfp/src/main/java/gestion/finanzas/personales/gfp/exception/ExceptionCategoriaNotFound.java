package gestion.finanzas.personales.gfp.exception;

import gestion.finanzas.personales.gfp.enums.ErrorCodes;

public class ExceptionCategoriaNotFound extends CustomException{
    public ExceptionCategoriaNotFound() {
        super("La categoria no existe", ErrorCodes.CATEGORIA_NO_ENCONTRADA);
    }
}