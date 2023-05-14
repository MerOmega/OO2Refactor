package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

public class PersonaFisica extends Persona{

    public String doc;

    public PersonaFisica(String doc) {
        this.doc = doc;
    }

    @Override
    public double calcularDescuento() {
        return 0.15;
    }

    @Override
    public String getTipoDePersona() {
        return "fisica";
    }

    public String getDoc() {
        return doc;
    }
    public void setDoc(String doc) {
        this.doc = doc;
    }
}
