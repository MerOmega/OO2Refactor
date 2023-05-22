package ar.edu.unlp.info.oo2.facturacion_llamadas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.personas.Persona;

public class Llamada {
	private TiposLlamadas tipoDeLlamada;
	private String emisor;
	private String remitente;
	private int duracion;
	
	public Llamada() {

	}

	public Llamada(TiposLlamadas tipoDeLlamada, String personaEmisor, String personaRemitente, int duracion) {
		this.tipoDeLlamada = tipoDeLlamada;
		this.emisor= personaEmisor;
		this.remitente= personaRemitente;
		this.duracion = duracion;
	}

	public TiposLlamadas getTipoDeLlamada() {
		return tipoDeLlamada;
	}

	public void setTipoDeLlamada(TiposLlamadas tipoDeLlamada) {
		this.tipoDeLlamada = tipoDeLlamada;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
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
	
	public double getAumento() {
		return this.tipoDeLlamada.getAumento(duracion);
	}
}
