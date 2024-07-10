package gestion.finanzas.personales.gfp.exception;

import gestion.finanzas.personales.gfp.enums.ErrorCodes;

public class PresupuestoNoEncontrado extends CustomException{

    public PresupuestoNoEncontrado() {
        super("El presupuesto no existe ", ErrorCodes.PRESUPUESTO_NO_ENCONTRADO);
    }

    public PresupuestoNoEncontrado(String message) {
        super(message,ErrorCodes.PRESUPUESTO_NO_ENCONTRADO);
    }
}
