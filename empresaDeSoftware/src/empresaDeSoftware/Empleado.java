package empresaDeSoftware;

public class Empleado {
	private Integer dni;
	private Integer idEmpleado;
	private String nombre;
	
	public Empleado(Integer dni, Integer idEmpleado, String nombre) {
		this.dni = dni;
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
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
	
	

}
