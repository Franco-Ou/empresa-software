package empresaDeSoftware;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class Gerente extends Empleado{
	private HashSet<Empleado> empleadosACargo = new HashSet<Empleado>();
	
	public Gerente(Integer dni, Integer idEmpleado, String nombre,Double sueldo, Integer anioDeIngreso) {
		super(dni,idEmpleado,nombre,sueldo,anioDeIngreso);
		toleranciaDeAusencias=5;
		plus=4000;
	}

	public HashSet<Empleado> getEmpleadosACargo() {
		return empleadosACargo;
	}

	public void agregarEmpleadoACargo(Empleado empleado) {
		empleadosACargo.add(empleado);
	}
	@Override
	public int getDiasDeVacaciones(){
		Integer adicional=10;
		return getDiasDeVacaciones()+adicional;
		}
	
}
