package empresaDeSoftware;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Empleado> departamentos = new ArrayList<Empleado>();

	public Boolean contratarEmpleado(Empleado empleado) {
		empleados.add(empleado);
		return true;
	}

	public Boolean darDeBajaAEmpleado(Integer id) {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getIdEmpleado().equals(id)) {
				empleados.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public ArrayList<Empleado> getDepartamentos() {
		return departamentos;
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
