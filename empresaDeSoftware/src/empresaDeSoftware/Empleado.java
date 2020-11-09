package empresaDeSoftware;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Empleado {
	private Integer dni;
	private Integer idEmpleado;
	private String nombre;
	private Double sueldo;
	private Integer anioDeIngreso;
	private Integer diasDeVacaciones;
	private Integer ausencias=0;
	private Integer llegadasTarde=0;
	protected Integer toleranciaDeAusencias=2;
	protected Integer plus=2000;

	
	public Empleado(Integer dni, Integer idEmpleado, String nombre, Double sueldo, Integer anioDeIngreso) {
		this.dni = dni;
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.anioDeIngreso=anioDeIngreso;
		calcularDiasDeVacaciones();
	}
	
	
	public Integer getDni() {
		return dni;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public Double getSueldo() {
		return sueldo;
	}

	
	public void reportarLlegadaTarde(){
		llegadasTarde++;
	}
	
	public void reportarAusencia() {
		ausencias++;
	}
	
	protected void calcularDiasDeVacaciones() {
		Integer antiguedad;
		Integer anioActual = Calendar.getInstance().get(Calendar.YEAR);
		antiguedad = anioActual	- anioDeIngreso;
		if(antiguedad<=5) {
			diasDeVacaciones = 14;
		}else if(antiguedad <=10) {
			diasDeVacaciones = 21;
		}else if(antiguedad<=20) {
			diasDeVacaciones=28;
		}else {
			diasDeVacaciones=35;
		}
	}
	
	public int getDiasDeVacaciones(){
		return diasDeVacaciones;
	}
	
	public String toString(){
		return (dni.toString()+" "+idEmpleado.toString()+" "+nombre+" "+sueldo.toString()+" "+anioDeIngreso.toString());
	}
	
	public Double calcularSueldo() {
		Double liquidacion = sueldo;
		Integer cantidadDeAusencias = ausencias;
		/* 4 llegadas tarde se consideran una ausencia*/
		Integer ausenciasPorLlegadasTarde = llegadasTarde/4;
		cantidadDeAusencias+=ausenciasPorLlegadasTarde;
		double valorDiaDeTrabajo=sueldo/20;
		if(cantidadDeAusencias==0) {
			liquidacion+=plus;
		}else if(cantidadDeAusencias>toleranciaDeAusencias) {
			liquidacion-=valorDiaDeTrabajo*cantidadDeAusencias;
		}
		return liquidacion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((idEmpleado == null) ? 0 : idEmpleado.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (idEmpleado == null) {
			if (other.idEmpleado != null)
				return false;
		} else if (!idEmpleado.equals(other.idEmpleado))
			return false;
		return true;
	}
	
	

}
