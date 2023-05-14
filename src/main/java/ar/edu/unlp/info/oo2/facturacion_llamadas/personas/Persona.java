package ar.edu.unlp.info.oo2.facturacion_llamadas.personas;

import ar.edu.unlp.info.oo2.facturacion_llamadas.Llamada;
import ar.edu.unlp.info.oo2.facturacion_llamadas.Persoonal;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
	public List<Llamada> lista1 = new ArrayList<Llamada>();
	public String nya;
	public String tel;
	public Persoonal sis;

	public abstract double calcularDescuento();
	public abstract String getTipoDePersona();

	public List<Llamada> getLista1() {
		return lista1;
	}
	public void setLista1(List<Llamada> lista1) {
		this.lista1 = lista1;
	}

	public String getNya() {
		return nya;
	}
	public void setNya(String nya) {
		this.nya = nya;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setSis(Persoonal persoonal) {
		this.sis = persoonal;
	}
}
