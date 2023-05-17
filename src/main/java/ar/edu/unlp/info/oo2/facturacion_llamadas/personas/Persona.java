package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.Llamada;
import ar.edu.unlp.info.oo2.facturacion_llamadas.Personal;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
		private List<Llamada> listaDeLlamadas = new ArrayList<Llamada>();

		private String nombreYApelldo;
		private String telefono;

	public abstract double calcularDescuento();
	public abstract String getTipoDePersona();
	public abstract double calcularMontoTotalLlamadas();

	public List<Llamada> getListaDeLlamadas() {
		return listaDeLlamadas;
	}

	public void setListaDeLlamadas(List<Llamada> listaDeLlamadas) {
		this.listaDeLlamadas = listaDeLlamadas;
	}

	public void addLlamadaALista(Llamada llamada){
		this.listaDeLlamadas.add(llamada);
	}

	public String getNombreYApelldo() {
		return nombreYApelldo;
	}

	public void setNombreYApelldo(String nombreYApelldo) {
		this.nombreYApelldo = nombreYApelldo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
