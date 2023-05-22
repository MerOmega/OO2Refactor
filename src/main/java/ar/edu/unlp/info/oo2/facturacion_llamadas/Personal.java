package ar.edu.unlp.info.oo2.facturacion_llamadas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.Persona;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaFisica;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaJuridica;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Personal {
    private List<Persona> listaDePersonas = new ArrayList<Persona>();

    private GuiaTelefonica guiaTelefonica = new GuiaTelefonica();

    public boolean agregarTelefono(String telefono) {
        return guiaTelefonica.addTelefono(telefono);
    }

    public Persona registrarUsuario(String data, String nombreYApellido, String tipoDePersona) {
        PersonaFactory personaFactory = new PersonaFactory();
        String telefono = guiaTelefonica.getUltimoTelefono();
        Persona persona = personaFactory.crearPersona(tipoDePersona,data,nombreYApellido,telefono);
        listaDePersonas.add(persona);
        return persona;
    }

    public boolean eliminarUsuario(Persona persona) {
        if (listaDePersonas.remove(persona)) {
            guiaTelefonica.addTelefono(persona.getTelefono());
            return true;
        }
        return false;
    }

    public Llamada registrarLlamada(Persona personaEmisor , Persona personaRemitente, TiposLlamadas tipoDeLlamada, int duracion) {
        Llamada llamada = new Llamada(tipoDeLlamada,personaEmisor.getTelefono(),personaRemitente.getTelefono(),duracion);
        personaEmisor.addLlamadaALista(llamada);
        return llamada;
    }

    public double calcularMontoTotalLlamadas(Persona persona) {
        return persona.calcularMontoTotalLlamadas();
    }

    public int cantidadDeUsuarios() {
        return listaDePersonas.size();
    }

    public boolean existeUsuario(Persona persona) {
        return listaDePersonas.contains(persona);
    }
}
