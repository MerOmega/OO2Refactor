package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

public class PersonaJuridica extends Persona{

    public String cuit;

    public PersonaJuridica(String cuit,String nombreYApellido,String telefono) {
        this.cuit = cuit;
        super.setNombreYApelldo(nombreYApellido);
        super.setTelefono(telefono);
    }
    
    @Override
    public String getTipoDePersona() {
        return "juridica";
    }

    public String getCuit() {
        return cuit;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public double calcularDescuento() {
        return 0.15;
    }
    
    @Override
    public double calcularMontoTotalLlamadas() {
		double suma = super.getListaDeLlamadas().stream().mapToDouble(llamada -> llamada.getAumento() - this.calcularDescuento()).sum();
		return 0;
	}
}
