package empresaDeSoftware;

import java.util.ArrayList;

public class Contaduria {
	
	private ArrayList<String> listadoDeInformesContables = new ArrayList<String>();

	public Contaduria(String nombre) {

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

	public Double calcularSueldoPromedioTotal(Empresa empresa) {
		Double sumaTotal = 0.0;
		Double sueldosPromedio = 0.0;

		for (Empleado empleado : empresa.getEmpleados()) {
			sumaTotal += empleado.getSueldo();
		}
		sueldosPromedio = sumaTotal / empresa.getEmpleados().size();

		return sueldosPromedio;

	}

	public Double calcularSumaDeSueldosTotales(Empresa empresa) {
		Double sumaTotal = 0.0;

		for (Empleado empleado : empresa.getEmpleados()) {
			sumaTotal += empleado.getSueldo();
		}
		return sumaTotal;
	}
	
	public void agregarInformeContable(String informe){
		 if(this.listadoDeInformesContables.contains(informe))
		 this.listadoDeInformesContables.add(informe);
		}
	
	// Si la gerencia le solicita un informe específico:
	public Boolean buscarUnInforme(String informeABuscar){
		 for (String informeBuscado :this.listadoDeInformesContables){
		  if(informeBuscado.equals(informeABuscar)){
		   return true;
		  }
		 }
		 return false;
		}
	
	public Boolean eliminarUnInforme(String informeAEliminar) {
		for(String informeEliminado : this.listadoDeInformesContables) {
			if(informeEliminado.equals(informeAEliminar)) {
				listadoDeInformesContables.remove(informeEliminado);
				return true;
			}
		}
		return false;
	}
	
}
