package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.Persona;

public class PersonaFactory {
    public Persona crearPersona(String tipoDePersona,String data,String nombreYApellido,String telefono) {
        if (tipoDePersona.equals("fisica")) {
            return new PersonaFisica(data,nombreYApellido,telefono);
        } else if (tipoDePersona.equals("juridica")) {
            return new PersonaJuridica(data,nombreYApellido,telefono);
        } else {
            throw new IllegalArgumentException("Tipo de persona inválido: " + tipoDePersona);
        }
    }
}
