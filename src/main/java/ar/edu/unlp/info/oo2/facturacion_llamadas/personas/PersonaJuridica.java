package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

public class PersonaJuridica extends Persona{

    public String cuit;

    public PersonaJuridica(String cuit) {
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public double calcularDescuento() {
        return 0;
    }
}
