package ar.edu.unlp.info.oo2.facturacion_llamadas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.Persona;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaFisica;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaJuridica;
import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.PersonaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persoonal {
    List<Persona> lista1 						= new ArrayList<Persona>();

    List<Llamada> lista2 						= new ArrayList<Llamada>();

    GuiaTelefonica guiasTelefonicas 		= new GuiaTelefonica();
    static double descuentoJur 					= 0.15;
    static double descuentoFis 					= 0;

    public boolean agregarTelefono(String str) {
        boolean encontre = guiasTelefonicas.guia.contains(str);
        if (!encontre) {
            guiasTelefonicas.guia.add(str);
            encontre = true;
            return encontre;
        } else {
            encontre = false;
            return encontre;
        }
    }

    public Persona registrarUsuario(String data, String nombre, String tipoDePersona) {
        PersonaFactory personaFactory = new PersonaFactory();
        Persona persona = personaFactory.crearPersona(tipoDePersona,data);
        persona.setNya(nombre);
        String tel = guiasTelefonicas.guia.last();
        guiasTelefonicas.guia.remove(tel);
        persona.setTel(tel);
        persona.setSis(this);

        if (persona instanceof PersonaFisica) {
            ((PersonaFisica) persona).setDoc(data);
        } else if (persona instanceof PersonaJuridica) {
            ((PersonaJuridica) persona).setCuit(data);
        }

        lista1.add(persona);
        return persona;
    }

    public boolean eliminarUsuario(Persona p) {
        List<Persona> l = p.sis.lista1.stream().filter(persona -> persona != p).collect(Collectors.toList());
        boolean borre = false;
        if (l.size() < lista1.size()) {
            this.lista1 = l;
            this.guiasTelefonicas.guia.add(p.getTel());
            borre = true;
        }
        return borre;

    }

    public Llamada registrarLlamada(Persona q, Persona q2, String t, int d) {
        Llamada x = new Llamada();
        x.tipoDeLlamada = t;
        x.setEmisor(q.tel);
        x.setRemitente(q2.getTel());
        x.dur = d;
        lista2.add(x);
        q.lista1.add(x);
        return x;

    }

    public double calcularMontoTotalLlamadas(Persona p) {
        double c = 0;
        Persona aux = null;
        for (Persona pp : lista1) {
            if (pp.tel == p.getTel()) {
                aux = pp;
                break;
            }
        }
        if (aux == null) return c;
        if (aux != null) {
            for (Llamada l : aux.lista1) {
                double auxc = 0;
                if (l.tipoDeLlamada == "nacional") {
                    auxc += l.dur * 3 + (l.dur * 3 * 0.21);
                } else if (l.tipoDeLlamada == "internacional") {
                    auxc += l.dur * 200 + (l.dur * 200 * 0.21);
                }

                if (Objects.equals(aux.getTipoDePersona(), "fisica")) {
                    auxc -= auxc * descuentoFis;
                } else if (Objects.equals(aux.getTipoDePersona(), "juridica")) {
                    auxc -= auxc * descuentoJur;
                }
                c += auxc;
            }
        }
        return c;
    }

    public int cantidadDeUsuarios() {
        return lista1.size();
    }

    public boolean existeUsuario(Persona persona) {
        return lista1.contains(persona);
    }

}
