package empresaDeSoftware;

import java.util.ArrayList;

public class Desarrollador extends Empleado{
	private ArrayList<String> proyectosAsignados = new ArrayList<String>();
	public Desarrollador(Integer dni, Integer idEmpleado, String nombre,Double sueldo, Integer anioDeIngreso) {
		super(dni,idEmpleado,nombre,sueldo,anioDeIngreso);
	}
	
	public void asignarProyecto(String proyecto){
		proyectosAsignados.add(proyecto);
		toleranciaDeAusencias=3;
	}

	public ArrayList<String> getProyectosAsignados() {
		return proyectosAsignados;
	}

	
	
	
}
