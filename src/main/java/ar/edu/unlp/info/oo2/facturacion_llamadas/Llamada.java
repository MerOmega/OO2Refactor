package ar.edu.unlp.info.oo2.facturacion_llamadas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.Persona;

public class Llamada {
	private String tipoDeLlamada;
	private String emisor;
	private String remitente;
	private int duracion;
	
	public Llamada() {

	}

	public Llamada(String tipoDeLlamada, String personaEmisor, String personaRemitente, int duracion) {
		this.tipoDeLlamada = tipoDeLlamada;
		this.emisor= personaEmisor;
		this.remitente= personaRemitente;
		this.duracion = duracion;
	}

	public String getTipoDeLlamada() {
		return tipoDeLlamada;
	}

	public void setTipoDeLlamada(String tipoDeLlamada) {
		this.tipoDeLlamada = tipoDeLlamada;
	}
	public void setEmisor(String q) {
		emisor = q;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getEmisor() {
		return emisor;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
