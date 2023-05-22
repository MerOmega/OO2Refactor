
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class TipoLlamadasNacional extends TiposLlamadas{
	
	public double getAumento(double duracion) {
		return (duracion * 3 + (duracion * 3 * 0.21));
		
	}

}
