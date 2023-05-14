package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.Persona;

public class PersonaFactory {
    public Persona crearPersona(String t,String data) {
        if (t.equals("fisica")) {
            return new PersonaFisica(data);
        } else if (t.equals("juridica")) {
            return new PersonaJuridica(data);
        } else {
            throw new IllegalArgumentException("Tipo de persona inválido: " + t);
        }
    }
}
