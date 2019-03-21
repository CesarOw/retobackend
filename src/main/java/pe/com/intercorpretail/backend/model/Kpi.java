package pe.com.intercorpretail.backend.model;

import java.math.BigDecimal;

public class Kpi {
	private BigDecimal promedio;
	private BigDecimal desviacionEstandar;
	
	
	
	public Kpi() {
		super();
	}
	public Kpi(BigDecimal promedio, BigDecimal desviacionEstandar) {
		super();
		this.promedio = promedio;
		this.desviacionEstandar = desviacionEstandar;
	}
	public BigDecimal getPromedio() {
		return promedio;
	}
	public void setPromedio(BigDecimal promedio) {
		this.promedio = promedio;
	}
	public BigDecimal getDesviacionEstandar() {
		return desviacionEstandar;
	}
	public void setDesviacionEstandar(BigDecimal desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}

	

}
