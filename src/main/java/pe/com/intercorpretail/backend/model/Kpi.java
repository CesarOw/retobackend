package pe.com.intercorpretail.backend.model;

public class Kpi {
	private String promedio;
	private String desviacionEstandar;

	public Kpi() {
		super();
	}

	public Kpi(String promedio, String desviacionEstandar) {
		super();
		this.promedio = promedio;
		this.desviacionEstandar = desviacionEstandar;
	}

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}

	public String getDesviacionEstandar() {
		return desviacionEstandar;
	}

	public void setDesviacionEstandar(String desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}

}
