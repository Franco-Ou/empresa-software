package empresaDeSoftware;

public class Contaduria extends Empresa {

	public Contaduria(String nombre) {
		super(nombre);

	}

	public Double calcularSueldo(Empleado empleado) {
		Double liquidacion = empleado.getSueldo();
		Integer cantidadDeAusencias = empleado.getAusencias();
		/* 4 llegadas tarde se consideran una ausencia */
		Integer ausenciasPorLlegadasTarde = empleado.getAusencias() / 4;
		cantidadDeAusencias += ausenciasPorLlegadasTarde;
		double valorDiaDeTrabajo = empleado.getAusencias() / 20;
		if (cantidadDeAusencias == 0) {
			liquidacion += empleado.getPlus();
		} else if (cantidadDeAusencias > empleado.getToleranciaDeAusencias()) {
			liquidacion -= valorDiaDeTrabajo * cantidadDeAusencias;
		}
		return liquidacion;
	}
}
