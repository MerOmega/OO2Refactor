package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class TipoLlamadasInternacional extends TiposLlamadas{
	
	public double getAumento(double duracion) {
		return ( duracion * 200 + (duracion * 200 * 0.21));	
	}

}
