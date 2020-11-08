package empresaDeSoftware;

public class Contador extends Empleado {

	public Contador(Integer dni, Integer idEmpleado, String nombre, Double sueldo, Integer anioDeIngreso) {
		super(dni, idEmpleado, nombre, sueldo, anioDeIngreso);
		toleranciaDeAusencias=5;
	}

}
