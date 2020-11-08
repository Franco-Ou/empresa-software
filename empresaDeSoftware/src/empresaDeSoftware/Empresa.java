package empresaDeSoftware;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	private String nombre;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	HashMap<Empleado, Double> sueldos = new HashMap<Empleado, Double>();
	
	public Empresa(String nombre){
		this.nombre = nombre;
	}

	public Boolean contratarEmpleado(Empleado empleado) {
		empleados.add(empleado);
		return true;
	}

	public Boolean darDeBajaAEmpleado(Integer dni) {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getDni()==dni) {
				empleados.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}
	
	public HashMap<Empleado, Double> liquidarSueldos(){
		for (Empleado empleado : empleados) {
			sueldos.put(empleado, empleado.calcularSueldo());
		}
		return sueldos;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
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
		Empresa other = (Empresa) obj;
		if (empleados == null) {
			if (other.empleados != null)
				return false;
		} else if (!empleados.equals(other.empleados))
			return false;
		return true;
	}

}
