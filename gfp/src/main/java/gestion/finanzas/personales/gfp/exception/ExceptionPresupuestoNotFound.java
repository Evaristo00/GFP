package gestion.finanzas.personales.gfp.exception;

import gestion.finanzas.personales.gfp.enums.ErrorCodes;

public class ExceptionPresupuestoNotFound extends CustomException{

    public ExceptionPresupuestoNotFound() {
        super("El presupuesto no existe ", ErrorCodes.PRESUPUESTO_NO_ENCONTRADO);
    }

    public ExceptionPresupuestoNotFound(String message) {
        super(message,ErrorCodes.PRESUPUESTO_NO_ENCONTRADO);
    }
}
