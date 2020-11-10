package empresaDeSoftware;

import java.util.ArrayList;

public class Desarrollador extends Empleado {
	private ArrayList<String> proyectosAsignados = new ArrayList<String>();

	public Desarrollador(Integer dni, Integer idEmpleado, String nombre, Double sueldo, Integer anioDeIngreso) {
		super(dni, idEmpleado, nombre, sueldo, anioDeIngreso);
		toleranciaDeAusencias = 3;
		plus = 3000;
	}

	public void asignarProyecto(String proyecto) {
		proyectosAsignados.add(proyecto);
		;
	}

	public ArrayList<String> getProyectosAsignados() {
		return proyectosAsignados;
	}

	@Override
	public int getDiasDeVacaciones() {
		Integer adicional = 5;
		return getDiasDeVacaciones() + adicional;
	}

}
