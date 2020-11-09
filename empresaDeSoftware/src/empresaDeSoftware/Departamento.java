package empresaDeSoftware;

import java.util.ArrayList;
import java.util.HashSet;

public class Departamento {
	private String nombre;
	private HashSet<Empleado> listaDeEmpleados = new HashSet<Empleado>();
	
	public Departamento(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean agregarEmpleadoADepartamento(Empleado empleado) {
		listaDeEmpleados.add(empleado);
		return true;
	}

}
