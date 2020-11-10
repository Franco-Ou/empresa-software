package empresaDeSoftware;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

public class Empresa {
	private String nombre;
	private Integer antiguedad;
	
	private HashSet<Empleado> empleados = new HashSet<Empleado>();
	HashMap<Empleado, Double> sueldos = new HashMap<Empleado, Double>();

	public Empresa(String nombre) {
		this.nombre = nombre;
	}

	public void contratarEmpleado(Empleado empleado) {
		empleados.add(empleado);

	}

	public Boolean darDeBajaAEmpleado(Integer dni) {
		for (Empleado empleado : this.empleados) {
			if (empleado.getDni().equals(dni)) {
				empleados.remove(empleado);
				return true;
			}
		}
		return false;
	}
	
	public Double calcularIndemnizacion(Integer idEmpleado) {
		Double indemnizacion = null;
		for (Empleado empleadoAIndemnizar : this.empleados) {
			if(empleadoAIndemnizar.getIdEmpleado().equals(idEmpleado)) {
				Integer anioActual = Calendar.getInstance().get(Calendar.YEAR);
				antiguedad = anioActual - empleadoAIndemnizar.getAnioDeIngreso();
				indemnizacion = (Double) (empleadoAIndemnizar.getSueldo() * antiguedad);
			}
		}
		return indemnizacion;
	}

	public HashSet<Empleado> getEmpleados() {
		return empleados;
	}

	public HashMap<Empleado, Double> liquidarSueldos() {
		Contaduria contaduria = new Contaduria("Contaduria");
		for (Empleado empleado : empleados) {
			sueldos.put(empleado, contaduria.calcularSueldo(empleado));
		}
		return sueldos;
	}

}
