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
	
	private void calcularDiasDeVacaciones() {
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
	
	

}
