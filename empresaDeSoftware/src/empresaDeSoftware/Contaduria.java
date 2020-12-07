package empresaDeSoftware;

import java.util.HashSet;

public class Contaduria {
	private Double liquidacionTotalDeSueldosDeLaEmpresa = 0.0;

	public Contaduria() {
		
	}

	public Double calcularSueldo(Empleado empleado) {
		Double liquidacion = empleado.getSueldo();
		Integer cantidadDeAusencias = empleado.getAusencias();
		/* 4 llegadas tarde se consideran una ausencia */
		Integer ausenciasPorLlegadasTarde = empleado.getAusencias() / 4;
		cantidadDeAusencias += ausenciasPorLlegadasTarde;
		double valorDiaDeTrabajo = empleado.getAusencias() / 20;
		if (cantidadDeAusencias == 0) {
			liquidacion += empleado.getPlus();
		} else if (cantidadDeAusencias > empleado.getToleranciaDeAusencias()) {
			liquidacion -= valorDiaDeTrabajo * cantidadDeAusencias;
		}

		return liquidacion;
	}

	public void calcularSumaDeSueldosTotales(Empresa empresa) {
		Double sumaTotal = 0.0;

		for (Empleado empleado : empresa.getEmpleados()) {
			sumaTotal += empleado.getSueldo();
		}
		liquidacionTotalDeSueldosDeLaEmpresa = sumaTotal;
	}

	public Double getLiquidacionTotalDeSueldosDeLaEmpresa() {
		return liquidacionTotalDeSueldosDeLaEmpresa;
	}

}
