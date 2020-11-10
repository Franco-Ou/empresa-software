package empresaDeSoftware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Empresa {
	private String nombre;
	private HashSet<Empleado> empleados = new HashSet<Empleado>();
	private Administracion administracion = new Administracion();
	private Contaduria contaduria = new Contaduria();

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

	public String mostrarEmpleadosQueLlegaronTarde() {
		String lista = "";
		for (Empleado empleado : administracion.getReporteDeEmpleadosQueLlegaronTarde()) {
			lista += empleado.getNombre() + "/n";
		}

		return lista;
	}

	public String mostrarEmpleadosQueSeAusentaron() {
		String lista = "";
		for (Empleado empleado : administracion.getReporteDeEmpleadosQueSeAusentaron()) {
			lista += empleado.getNombre() + "/n";
		}

		return lista;
	}

	public HashSet<Empleado> getEmpleados() {
		return empleados;
	}

	public String mostrarSueldosDeEmpleados() {
		String listaDeNombres = "";
		for (Empleado empleado : empleados) {
			listaDeNombres += empleado.getNombre() + " - " + contaduria.calcularSueldo(empleado) + "/n";
		}

		return listaDeNombres;

	}

	public Double calcularSueldoPromedioTotal() {
		Double sumaTotal = 0.0;
		Double sueldosPromedio = 0.0;

		for (Empleado empleado : empleados) {
			sumaTotal += empleado.getSueldo();
		}
		sueldosPromedio = sumaTotal / empleados.size();

		return sueldosPromedio;

	}

}
