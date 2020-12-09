package empresaDeSoftware;

import java.util.HashSet;

public class Gerente extends Empleado {
	private HashSet<Empleado> empleadosACargo = new HashSet<Empleado>();

	public Gerente(Integer dni, Integer idEmpleado, String nombre, Double sueldo, Integer anioDeIngreso) {
		super(dni, idEmpleado, nombre, sueldo, anioDeIngreso);
		toleranciaDeAusencias = 5;
		plus = 4000;
	}

	public HashSet<Empleado> getEmpleadosACargo() {
		return empleadosACargo;
	}

	public void agregarEmpleadoACargo(Empleado empleado) {
		empleadosACargo.add(empleado);
	}

	
	public void comenzarProyecto(Proyecto proyecto) {
		proyecto.comenzarProyecto();
	}
	
	public void cancelarProyecto(Proyecto proyecto) {
		proyecto.cancelarProyecto();
	}
	
	public void terminarProyecto(Proyecto proyecto) {
		proyecto.terminarProyecto();
	}
	
	

	public int getDiasDeVacaciones() {
		Integer adicional = 10;
		return super.getDiasDeVacaciones() + adicional;
	}

}
