package ar.edu.unlp.info.oo2.facturacion_llamadas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.Persona;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaFisica;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaJuridica;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persoonal {
    List<Persona> listaDePersonas = new ArrayList<Persona>();

    List<Llamada> listaDeLlamadas = new ArrayList<Llamada>();

    GuiaTelefonica guiasTelefonicas = new GuiaTelefonica();

    public boolean agregarTelefono(String str) {
        return guiasTelefonicas.guia.add(str);
    }

    public Persona registrarUsuario(String data, String nombre, String tipoDePersona) {
        PersonaFactory personaFactory = new PersonaFactory();
        Persona persona = personaFactory.crearPersona(tipoDePersona,data);
        persona.setNombreYApelldo(nombre);
        String tel = guiasTelefonicas.guia.last();
        guiasTelefonicas.guia.remove(tel);
        persona.setTelefono(tel);
        persona.setSis(this);

        if (persona instanceof PersonaFisica) {
            ((PersonaFisica) persona).setDocumento(data);
        } else if (persona instanceof PersonaJuridica) {
            ((PersonaJuridica) persona).setCuit(data);
        }

        listaDePersonas.add(persona);
        return persona;
    }

    public boolean eliminarUsuario(Persona p) {
        List<Persona> l = p.getSis().listaDePersonas.stream().filter(persona -> persona != p).collect(Collectors.toList());
        boolean borre = false;
        if (l.size() < listaDePersonas.size()) {
            this.listaDePersonas = l;
            this.guiasTelefonicas.guia.add(p.getTelefono());
            borre = true;
        }
        return borre;

    }

    public Llamada registrarLlamada(Persona q, Persona q2, String t, int d) {
        Llamada x = new Llamada();
        x.setTipoDeLlamada(t);
        x.setEmisor(q.getTelefono());
        x.setRemitente(q2.getTelefono());
        x.setDuracion(d);
        listaDeLlamadas.add(x);
        q.addLlamadaALista(x);
        return x;

    }

    public double calcularMontoTotalLlamadas(Persona persona) {
        double c = 0;
        Persona aux = null;
        for (Persona pp : listaDePersonas) {
            if (pp.getTelefono().equals(persona.getTelefono())) {
                aux = pp;
                break;
            }
        }
        if (aux == null) return c;
        if (aux != null) {
            for (Llamada l : aux.getListaDeLlamadas()) {
                double auxc = 0;
                if (l.getTipoDeLlamada().equals("nacional")) {
                    auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
                } else if (l.getTipoDeLlamada().equals("internacional")) {
                    auxc += l.getDuracion() * 200 + (l.getDuracion() * 200 * 0.21);
                }

                auxc -= auxc * aux.calcularDescuento();

                c += auxc;
            }
        }
        return c;
    }

    public int cantidadDeUsuarios() {
        return listaDePersonas.size();
    }

    public boolean existeUsuario(Persona persona) {
        return listaDePersonas.contains(persona);
    }

}
