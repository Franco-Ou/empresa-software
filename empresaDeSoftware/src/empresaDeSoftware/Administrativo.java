package empresaDeSoftware;

public class Administrativo extends Empleado{

	public Administrativo(Integer dni, Integer idEmpleado, String nombre, Double sueldo, Integer anioDeIngreso) {
		super(dni, idEmpleado, nombre, sueldo, anioDeIngreso);
		toleranciaDeAusencias=1;
	}

}
