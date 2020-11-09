package empresaDeSoftware;

public class Contador extends Empleado {

	public Contador(Integer dni, Integer idEmpleado, String nombre, Double sueldo, Integer anioDeIngreso) {
		super(dni, idEmpleado, nombre, sueldo, anioDeIngreso);
		toleranciaDeAusencias=5;
		plus=3000;
	}
	
	@Override
	public int getDiasDeVacaciones(){
		Integer adicional=2;
		return getDiasDeVacaciones()+adicional;
		}

}
