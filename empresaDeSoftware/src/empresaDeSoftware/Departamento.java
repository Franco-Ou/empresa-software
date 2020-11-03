package empresaDeSoftware;

import java.util.ArrayList;

public class Departamento {
	private String nombre;
	private ArrayList<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
	
	public Departamento(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean agregarEmpleadoADepartamento(Empleado empleado) {
		listaDeEmpleados.add(empleado);
		return true;
	}

}
