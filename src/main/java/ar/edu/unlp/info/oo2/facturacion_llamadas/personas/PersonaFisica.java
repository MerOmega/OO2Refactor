package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.Llamada;

public class PersonaFisica extends Persona{

    private String documento;

    public PersonaFisica(String documento,String nombreYApellido,String telefono) {
        this.documento = documento;
        super.setNombreYApelldo(nombreYApellido);
        super.setTelefono(telefono);
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
