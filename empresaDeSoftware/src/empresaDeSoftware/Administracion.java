package empresaDeSoftware;

import java.util.Calendar;
import java.util.HashSet;

public class Administracion {

	HashSet<Empleado> reporteDeEmpleadosQueLlegaronTarde = new HashSet<Empleado>();
	HashSet<Empleado> reporteDeEmpleadosQueSeAusentaron = new HashSet<Empleado>();

	public Administracion() {

	}

	public void reportarLlegadaTarde(Empleado empleado) {
		empleado.setLlegadasTarde(empleado.getLlegadasTarde() + 1);
		reporteDeEmpleadosQueLlegaronTarde.add(empleado);
	}

	public void reportarAusencia(Empleado empleado) {
		empleado.setAusencias(empleado.getAusencias() + 1);
		reporteDeEmpleadosQueSeAusentaron.add(empleado);
	}

	public HashSet<Empleado> getReporteDeEmpleadosQueSeAusentaron() {
		return reporteDeEmpleadosQueSeAusentaron;
	}

	public HashSet<Empleado> getReporteDeEmpleadosQueLlegaronTarde() {
		return reporteDeEmpleadosQueLlegaronTarde;
	}

}
