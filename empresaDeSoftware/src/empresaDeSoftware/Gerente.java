package empresaDeSoftware;

import java.util.ArrayList;

public class Gerente extends Empleado{
	private ArrayList<Empleado> empleadosACargo = new ArrayList<Empleado>();
	
	public Gerente(Integer dni, Integer idEmpleado, String nombre,Double sueldo, Integer anioDeIngreso) {
		super(dni,idEmpleado,nombre,sueldo,anioDeIngreso);
		toleranciaDeAusencias=5;
	}

	public ArrayList<Empleado> getEmpleadosACargo() {
		return empleadosACargo;
	}

	public void agregarEmpleadoACargo(Empleado empleado) {
		empleadosACargo.add(empleado);
	}
	
	
	
	
}
