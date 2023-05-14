package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

public class PersonaFisica extends Persona{

    public String documento;

    public PersonaFisica(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String getTipoDePersona() {
        return "fisica";
    }
    @Override
    public double calcularDescuento() {
        return 0;
    }
}
