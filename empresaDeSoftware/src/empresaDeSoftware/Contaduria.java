package empresaDeSoftware;

public class Contaduria {
	private Double liquidacionTotalDeSueldosDeLaEmpresa = 0.0;

	public Contaduria() {

	}

	public Double calcularLiquidacion(Empleado empleado) {
		Double liquidacion = empleado.getSueldo();
		Integer cantidadDeAusencias = empleado.getAusencias();
		/* 4 llegadas tarde se consideran una ausencia */
		Integer ausenciasPorLlegadasTarde = empleado.getAusencias() / 4;
		cantidadDeAusencias += ausenciasPorLlegadasTarde;
		double valorDiaDeTrabajo = empleado.getAusencias() / 20;
		if (cantidadDeAusencias.equals(0)) {
			liquidacion += empleado.getPlus();
		} else if (cantidadDeAusencias > empleado.getToleranciaDeAusencias()) {
			liquidacion -= valorDiaDeTrabajo * cantidadDeAusencias;
		}

		return liquidacion;
	}

	// Los desarrolladores tienen un bono de $ 2000 por proyecto finalizado:
	public Double calcularSueldoFinalDeEmpleado(Empleado empleado) {
		Contaduria micontador = new Contaduria();

		if (empleado instanceof Desarrollador) {
			((Desarrollador) empleado).calcularProyectosFinalizados();
			Double extraPorBono = (Double) (((Desarrollador) empleado).getBono()
					* ((Desarrollador) empleado).calcularProyectosFinalizados());
			return micontador.calcularLiquidacion(empleado) + extraPorBono;
		} else {
			return micontador.calcularLiquidacion(empleado);
		}
	}

	public Double getLiquidacionTotalDeSueldosDeLaEmpresa(Empresa empresa) {
		Double sumaTotal = 0.0;

		for (Empleado empleado : empresa.getEmpleados()) {
			sumaTotal += empleado.getSueldo();
		}
		liquidacionTotalDeSueldosDeLaEmpresa = sumaTotal;
		return liquidacionTotalDeSueldosDeLaEmpresa;
	}

	public Double calcularSueldoPromedioTotal(Empresa empresa) {
		Double sumaTotal = 0.0;
		Double sueldosPromedio = 0.0;

		for (Empleado empleado : empresa.getEmpleados()) {
			sumaTotal += empleado.getSueldo();
		}
		sueldosPromedio = sumaTotal / empresa.getEmpleados().size();

		return sueldosPromedio;

	}

}
