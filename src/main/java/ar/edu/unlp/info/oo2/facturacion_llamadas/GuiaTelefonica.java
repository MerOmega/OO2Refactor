package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;

public class GuiaTelefonica {
	private SortedSet<String> guia; 
	
	public GuiaTelefonica() {
		guia = new TreeSet<String>();
	}
	
	public boolean addTelefono(String telefono) {
		return guia.add(telefono);
	}
	
	public String getUltimoTelefono() {
		String ultimoTelefono = guia.last();
		guia.remove(ultimoTelefono);
		return ultimoTelefono;
	}
}
