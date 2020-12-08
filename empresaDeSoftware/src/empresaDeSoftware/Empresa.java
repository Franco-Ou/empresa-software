package empresaDeSoftware;

import java.util.HashSet;
import java.util.TreeSet;

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

	public Empleado buscarEmpleado(Integer dni) throws EmpleadoNotFoundException {
		boolean fueEncontrado = false;
		for (Empleado empleado : empleados) {
			if (empleado.getDni().equals(dni)) {
				fueEncontrado = true;
				return empleado;
			}
		}

		if (fueEncontrado == false) {
			throw new EmpleadoNotFoundException("El empleado no fue encontrado");
		}
		return null;
	}

	public String mostrarEmpleadosQueLlegaronTarde() {
		String lista = "";
		for (Empleado empleado : administracion.getReporteDeEmpleadosQueLlegaronTarde()) {
			lista += empleado.getNombre() + "\n";
		}

		return lista;
	}

	public String mostrarEmpleadosQueSeAusentaron() {
		String lista = "";
		for (Empleado empleado : administracion.getReporteDeEmpleadosQueSeAusentaron()) {
			lista += empleado.getNombre() + "\n";
		}

		return lista;
	}

	public HashSet<Empleado> getEmpleados() {
		return empleados;
	}

	public String mostrarSueldosDeEmpleados() {
		String listaDeNombres = "";
		for (Empleado empleado : empleados) {
			listaDeNombres += empleado.getNombre() + " - " + contaduria.calcularLiquidacion(empleado) + "\n";
		}

		return listaDeNombres;

	}

	public TreeSet<Desarrollador> obtenerDesarrolladoresConMasDeCincoProyectosFinalizadosOrdenadosPorDNI() {
		TreeSet<Desarrollador> desarrolladoresConMasDeCincoProyectosFinalizados = new TreeSet<Desarrollador>();
		for (Empleado empleado : empleados) {
			if (empleado instanceof Desarrollador && ((Desarrollador) empleado).realizoCincoProyectosOMas()) {
				desarrolladoresConMasDeCincoProyectosFinalizados.add((Desarrollador) empleado);
			}
		}

		return desarrolladoresConMasDeCincoProyectosFinalizados;
	}

	public Administracion getAdministracion() {
		return administracion;
	}

	public Contaduria getContaduria() {
		return contaduria;
	}
	

}
