package empresaDeSoftware;

import java.util.ArrayList;

public class Desarrollador extends Empleado {

	private Integer proyectosFinalizados = 0;
	private ArrayList<String> proyectosAsignados = new ArrayList<String>();
	private Double bono = 2000.00;

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

	public Boolean buscarProyecto(String proyectoBuscado) {
		for (String proyectoEncontrado : this.proyectosAsignados) {
			if (proyectoEncontrado.equals(proyectoBuscado)) {
				return true;
			}
		}
		return false;
	}

	public void finalizarProyecto() {
		proyectosFinalizados++;
	}

	// Los desarrolladores tienen un bono de $ 2000 por proyecto finalizado:
	public Double calcularSueldo(Empleado empleado) {
		Contaduria micontador = new Contaduria("Equipo A");
		Double extraPorBono = (Double) (bono * proyectosFinalizados);
		return micontador.calcularSueldo(empleado) + extraPorBono;
	}

	@Override
	public int getDiasDeVacaciones() {
		Integer adicional = 5;
		return getDiasDeVacaciones() + adicional;
	}

}