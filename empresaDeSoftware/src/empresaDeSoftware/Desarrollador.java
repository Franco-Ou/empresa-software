package empresaDeSoftware;

import java.util.ArrayList;

public class Desarrollador extends Empleado {

	private boolean tieneCincoProyectosFinalizadosOMas = false;
	private Integer proyectosFinalizados = 0;
	private ArrayList<Proyecto> proyectosAsignados = new ArrayList<Proyecto>();
	private Double bono = 2000.00;

	public Desarrollador(Integer dni, Integer idEmpleado, String nombre, Double sueldo, Integer anioDeIngreso) {
		super(dni, idEmpleado, nombre, sueldo, anioDeIngreso);
		toleranciaDeAusencias = 3;
		plus = 3000;
	}

	public void asignarProyecto(Proyecto proyecto) {
		proyectosAsignados.add(proyecto);
	}

	public ArrayList<Proyecto> getProyectosAsignados() {
		return proyectosAsignados;
	}

	public Boolean buscarProyecto(Proyecto proyectoBuscado) {
		for (Proyecto proyectoEncontrado : this.proyectosAsignados) {
			if (proyectoEncontrado.equals(proyectoBuscado)) {
				return true;
			}
		}
		return false;
	}

	public boolean realizoCincoProyectosOMas() {
		calcularProyectosFinalizados();
		if (proyectosFinalizados >= 5) {
			tieneCincoProyectosFinalizadosOMas = true;
			return tieneCincoProyectosFinalizadosOMas;
		} else {
			return tieneCincoProyectosFinalizadosOMas;
		}
	}

	public Integer calcularProyectosFinalizados() {
		Integer cantidadDeProyectosTerminados = 0;
		for (Proyecto proyecto : proyectosAsignados) {
			if (proyecto.getEstado().equals('T')) {
				cantidadDeProyectosTerminados++;
			}
		}
		proyectosFinalizados = cantidadDeProyectosTerminados;
		return proyectosFinalizados;
	}

	public Double getBono() {
		return bono;
	}

	
	public int getDiasDeVacaciones() {
		Integer adicional = 5;
		return super.getDiasDeVacaciones() + adicional;
	}

}