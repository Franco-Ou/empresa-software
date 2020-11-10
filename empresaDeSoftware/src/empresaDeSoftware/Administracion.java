package empresaDeSoftware;

import java.util.Calendar;

public class Administracion {

	public Administracion(String nombre) {

	}

	protected void calcularDiasDeVacaciones(Empleado empleado) {
		Integer antiguedad;
		Integer anioActual = Calendar.getInstance().get(Calendar.YEAR);
		antiguedad = anioActual - empleado.getAnioDeIngreso();
		if (antiguedad <= 5) {
			empleado.setDiasDeVacaciones(14);
		} else if (antiguedad <= 10) {
			empleado.setDiasDeVacaciones(21);
			;
		} else if (antiguedad <= 20) {
			empleado.setDiasDeVacaciones(28);
			;
		} else {
			empleado.setDiasDeVacaciones(35);
			;
		}
	}
	
	public void reportarLlegadaTarde(Empleado empleado) {
		empleado.setLlegadasTarde(empleado.getLlegadasTarde() + 1);
	}
	
	public void reportarAusencia(Empleado empleado) {
		empleado.setAusencias(empleado.getAusencias() + 1);
	}
}
