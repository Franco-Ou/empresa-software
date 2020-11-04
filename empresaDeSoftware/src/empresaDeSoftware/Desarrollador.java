package empresaDeSoftware;

import java.util.ArrayList;

public class Desarrollador extends Empleado{
	private ArrayList<String> proyectosAsignados = new ArrayList<String>();
	public Desarrollador(Integer dni, Integer idEmpleado, String nombre) {
		super(dni,idEmpleado,nombre);
	}
}
