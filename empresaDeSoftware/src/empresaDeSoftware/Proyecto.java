package empresaDeSoftware;

public class Proyecto {
	private String nombre;
	private Double costo;
	private Double valor;
	private Character estado;//C=cancelado,T=terminado,E=En proceso,S=Sin empezar
	
	public Proyecto(String nombre, Double costo, Double valor) {
		this.nombre = nombre;
		this.costo=costo;
		this.valor = valor;
		this.estado='S'; //Cuando se crea un proyecto, por defecto se crea en estado "Sin empezar"
		}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public Double getCosto() {
		return costo;
	}
	
	public void setCosto(Double costo) {
		this.costo=costo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor=valor;
	}
	
	public double ganancia() {
		Double ganancia =0.0;
		ganancia = this.valor-this.costo;
		return ganancia;
	}
	
	public void comenzarProyecto() {
		this.estado='E';
	}
	
	public void cancelarProyecto() {
		this.estado='C';
	}
	public void terminarProyecto() {
		this.estado='T';
	}
	
	public Character getEstado() {
		return estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Proyecto other = (Proyecto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}