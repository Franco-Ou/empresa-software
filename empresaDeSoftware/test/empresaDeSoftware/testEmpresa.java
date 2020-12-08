package empresaDeSoftware;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class testEmpresa {

	@Test
	public void queSePuedaAgregarEmpleado() {
		Empleado empleado1 = new Empleado(13456789, 001, "John Connor", 50000.0, 2000);

		Empresa microsoft = new Empresa("Microsoft");

		microsoft.contratarEmpleado(empleado1);

		assertTrue(microsoft.getEmpleados().contains(empleado1));
	}

	@Test
	public void queNoSePuedaAgregarUnEmpleado() {
		Empleado empleado1 = new Empleado(13456789, 001, "John Connor", 50000.0, 2000);
		Empleado empleado2 = new Empleado(13456789, 001, "Don Draper", 100000.0, 2000);

		Empresa microsoft = new Empresa("Microsoft");

		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);

		int cantEmpleados = 1;
		assertEquals(cantEmpleados, microsoft.getEmpleados().size());

	}

	@Test
	public void queSePuedaDarDeBajaEmpleados() {
		Empleado empleado1 = new Empleado(10456789, 001, "John Connor", 50000.0, 2000);
		Empleado empleado2 = new Gerente(13456711, 002, "Don Draper", 100000.0, 2000);
		Empleado empleado3 = new Empleado(12456730, 003, "Diana Prince", 80000.0, 2000);
		Empleado empleado4 = new Empleado(13456789, 004, "Peggy Olson", 73000.0, 2000);

		Empresa microsoft = new Empresa("Microsoft");

		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);
		microsoft.contratarEmpleado(empleado3);
		microsoft.contratarEmpleado(empleado4);

		microsoft.darDeBajaAEmpleado(13456789);
		microsoft.darDeBajaAEmpleado(13456711);

		int empleadosRestantes = 2;
		Assert.assertEquals(empleadosRestantes, microsoft.getEmpleados().size());
	}

	@Test
	public void calculoVacaciones() {
		Empleado empleadoDePrueba1 = new Empleado(13456789, 001, "Juan Perez", 50000.0, 2005);
		Empleado empleadoDePrueba2 = new Empleado(10890567, 002, "Estela Maris", 75000.0, 1980);
		Empleado empleadoDePrueba3 = new Empleado(44567889, 003, "Amancio Jackson", 35000.0, 2019);
		Empleado empleadoDePrueba4 = new Empleado(45990876, 004, "Juana Gomez", 35000.0, 2014);

		empleadoDePrueba1.calcularDiasDeVacaciones();
		empleadoDePrueba2.calcularDiasDeVacaciones();
		empleadoDePrueba3.calcularDiasDeVacaciones();
		empleadoDePrueba4.calcularDiasDeVacaciones();

		assertEquals(28, empleadoDePrueba1.getDiasDeVacaciones());
		assertEquals(35, empleadoDePrueba2.getDiasDeVacaciones());
		assertEquals(14, empleadoDePrueba3.getDiasDeVacaciones());
		assertEquals(21, empleadoDePrueba4.getDiasDeVacaciones());
	}

	@Test
	public void calcularGananciaProyecto() {
		Proyecto desarrolloSistemaBanco = new Proyecto("BankSystem", 15000.00, 100000.00);
		Proyecto webECommerce = new Proyecto("TiendaOnline", 8000.00, 50000.00);

		assertEquals(85000.00, desarrolloSistemaBanco.ganancia(), 0);
		assertEquals(42000.00, webECommerce.ganancia(), 0);

	}

	@Test
	public void calcularSueldoDesarrollador() {

		// El desarrollador 1 tendr� 6 proyectos asignados, pero solo 4 terminados.
		// El desarrollador 2 tendr� 6 proyectos asignados, y todos terminados

		Proyecto proyecto1 = new Proyecto("Proyecto 1", 15000.00, 100000.00);
		Proyecto proyecto2 = new Proyecto("Proyecto 2", 8000.00, 50000.00);
		Proyecto proyecto3 = new Proyecto("Proyecto 3", 9000.00, 20000.00);
		Proyecto proyecto4 = new Proyecto("Proyecto 4", 22000.00, 40000.00);
		Proyecto proyecto5 = new Proyecto("Proyecto 5", 2000.00, 5000.00);
		Proyecto proyecto6 = new Proyecto("Proyecto 6", 5000.00, 10000.00);
		Proyecto proyecto7 = new Proyecto("Proyecto 7", 10000.00, 35000.00);
		Proyecto proyecto8 = new Proyecto("Proyecto 8", 50000.00, 120000.00);
		Empresa samsung = new Empresa("Samsung");

		Gerente gerente = new Gerente(22909887, 88, "Armando Paredes", 112000.00, 1995);
		samsung.contratarEmpleado(gerente);

		// Si bien no es necesario para el proposito de este test comenzarProyecto(), se
		// incluye para mostrar como seria el flujo
		gerente.comenzarProyecto(proyecto1);
		gerente.terminarProyecto(proyecto1);
		gerente.comenzarProyecto(proyecto2);
		gerente.terminarProyecto(proyecto2);
		gerente.comenzarProyecto(proyecto3);
		gerente.terminarProyecto(proyecto3);
		gerente.comenzarProyecto(proyecto4);
		gerente.terminarProyecto(proyecto4);
		gerente.comenzarProyecto(proyecto5);
		gerente.terminarProyecto(proyecto5);
		gerente.comenzarProyecto(proyecto6);
		gerente.terminarProyecto(proyecto6);
		// El proyecto 7 es cancelado
		gerente.comenzarProyecto(proyecto7);
		gerente.cancelarProyecto(proyecto7);
		// El poryecto 8 no esta temrinado aun
		gerente.comenzarProyecto(proyecto8);

		Desarrollador desarrollador1 = new Desarrollador(30778909, 155, "Juan Perez", 60000.00, 2015);
		Desarrollador desarrollador2 = new Desarrollador(36445009, 209, "Mariana Arias", 57000.00, 2019);
		samsung.contratarEmpleado(desarrollador1);
		samsung.contratarEmpleado(desarrollador2);

		desarrollador1.asignarProyecto(proyecto1);
		desarrollador1.asignarProyecto(proyecto2);
		desarrollador1.asignarProyecto(proyecto3);
		desarrollador1.asignarProyecto(proyecto4);
		desarrollador1.asignarProyecto(proyecto7);
		desarrollador1.asignarProyecto(proyecto8);

		desarrollador2.asignarProyecto(proyecto1);
		desarrollador2.asignarProyecto(proyecto2);
		desarrollador2.asignarProyecto(proyecto3);
		desarrollador2.asignarProyecto(proyecto4);
		desarrollador2.asignarProyecto(proyecto5);
		desarrollador2.asignarProyecto(proyecto6);

		// empleado 1 debiera cobrar $71000 (Sueldo base + $3000 de plus por no tener
		// faltas + $8000 de los 4 proyectos finalizados)
		// empleado 2 debiera cobrar $72000 (Sueldo base + $3000 de plus por no tener
		// faltas + $12000 de los 6 proyectos finalizados)
		assertEquals(71000.00, samsung.getContaduria().calcularSueldoFinalDeEmpleado(desarrollador1), 0);
		assertEquals(72000.00, samsung.getContaduria().calcularSueldoFinalDeEmpleado(desarrollador2), 0);

	}

	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeDesarrolladoresConMasDeCincoProyectosOrdenadaPorDNI() {
		Empresa microsoft = new Empresa("Microsoft");
		Desarrollador empleadoDePrueba1 = new Desarrollador(13456789, 001, "Juan Perez", 50000.0, 2005);
		Desarrollador empleadoDePrueba2 = new Desarrollador(10890567, 002, "Estela Maris", 75000.0, 1980);
		Desarrollador empleadoDePrueba3 = new Desarrollador(44567889, 003, "Amancio Jackson", 35000.0, 2019);
		Desarrollador empleadoDePrueba4 = new Desarrollador(45990876, 004, "Juana Gomez", 35000.0, 2014);
		Gerente gerente = new Gerente(22909887, 88, "Armando Paredes", 112000.00, 1995);

		microsoft.contratarEmpleado(empleadoDePrueba1);
		microsoft.contratarEmpleado(empleadoDePrueba2);
		microsoft.contratarEmpleado(empleadoDePrueba3);
		microsoft.contratarEmpleado(empleadoDePrueba4);

		Proyecto proyecto1 = new Proyecto("Proyecto 1", 15000.00, 100000.00);
		Proyecto proyecto2 = new Proyecto("Proyecto 2", 8000.00, 50000.00);
		Proyecto proyecto3 = new Proyecto("Proyecto 3", 9000.00, 20000.00);
		Proyecto proyecto4 = new Proyecto("Proyecto 4", 22000.00, 40000.00);
		Proyecto proyecto5 = new Proyecto("Proyecto 5", 2000.00, 5000.00);

		empleadoDePrueba1.asignarProyecto(proyecto1);
		empleadoDePrueba1.asignarProyecto(proyecto2);
		empleadoDePrueba1.asignarProyecto(proyecto3);
		empleadoDePrueba1.asignarProyecto(proyecto4);
		empleadoDePrueba1.asignarProyecto(proyecto5);

		empleadoDePrueba2.asignarProyecto(proyecto1);
		empleadoDePrueba2.asignarProyecto(proyecto2);
		empleadoDePrueba2.asignarProyecto(proyecto3);
		empleadoDePrueba2.asignarProyecto(proyecto4);
		empleadoDePrueba2.asignarProyecto(proyecto5);

		empleadoDePrueba3.asignarProyecto(proyecto1);
		empleadoDePrueba3.asignarProyecto(proyecto2);
		empleadoDePrueba3.asignarProyecto(proyecto3);
		empleadoDePrueba3.asignarProyecto(proyecto4);
		empleadoDePrueba3.asignarProyecto(proyecto5);

		empleadoDePrueba4.asignarProyecto(proyecto1);
		empleadoDePrueba4.asignarProyecto(proyecto2);
		empleadoDePrueba4.asignarProyecto(proyecto3);
		empleadoDePrueba4.asignarProyecto(proyecto4);
		empleadoDePrueba4.asignarProyecto(proyecto5);

		gerente.terminarProyecto(proyecto1);
		gerente.terminarProyecto(proyecto2);
		gerente.terminarProyecto(proyecto3);
		gerente.terminarProyecto(proyecto4);
		gerente.terminarProyecto(proyecto5);

		assertEquals(microsoft.obtenerDesarrolladoresConMasDeCincoProyectosFinalizadosOrdenadosPorDNI().first(),
				empleadoDePrueba2);
		assertEquals(microsoft.obtenerDesarrolladoresConMasDeCincoProyectosFinalizadosOrdenadosPorDNI().last(),
				empleadoDePrueba4);

	}

	@Test(expected = EmpleadoNotFoundException.class)
	public void queAlBuscarEmpleadoDadoDeBajaNoSeEncuentreYLanceUnaExcepcion() throws EmpleadoNotFoundException {
		Desarrollador empleado = new Desarrollador(34829387, 132, "Juan", 38439.00, 2019);
		Empresa google = new Empresa("Google");

		google.contratarEmpleado(empleado);
		google.darDeBajaAEmpleado(empleado.getDni());
		google.buscarEmpleado(empleado.getDni());

	}

	@Test
	public void queCalculeElSueldoPromedioTotalDeLaEmpresaCorrectamente() {
		Empresa apple = new Empresa("Apple");
		Gerente gerente = new Gerente(32983409, 12353, "Martin Rodriguez", 75000.00, 2018);
		Desarrollador desarrollador1 = new Desarrollador(35034839, 25543, "Carlos Caceres", 50000.00, 2020);
		Desarrollador desarrollador2 = new Desarrollador(38033449, 35543, "Alejandro C�rdoba", 44000.00, 2020);
		Double promedio = (gerente.getSueldo() + desarrollador1.getSueldo() + desarrollador2.getSueldo()) / 3;

		apple.contratarEmpleado(gerente);
		apple.contratarEmpleado(desarrollador1);
		apple.contratarEmpleado(desarrollador2);

		assertEquals(apple.getContaduria().calcularSueldoPromedioTotal(apple), promedio);

	}

	@Test
	public void queSeMuestreCorrectamenteLosEmpleadosQueLLegaronTarde() {
		Empleado empleado1 = new Empleado(10456789, 001, "Joan Holloway", 50000.0, 2000);
		Empleado empleado2 = new Gerente(13456711, 002, "Don Draper", 100000.0, 2000);
		Empleado empleado3 = new Desarrollador(12456730, 003, "Pete Campbell", 80000.0, 2000);
		Empleado empleado4 = new Empleado(13456789, 004, "Peggy Olson", 73000.0, 2000);

		Empresa microsoft = new Empresa("Sterling Cooper");

		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);
		microsoft.contratarEmpleado(empleado3);
		microsoft.contratarEmpleado(empleado4);

		microsoft.getAdministracion().reportarLlegadaTarde(empleado1);
		microsoft.getAdministracion().reportarLlegadaTarde(empleado2);

		HashSet<Empleado> reporteLlegadasTardeEsperado = new HashSet<Empleado>();
		reporteLlegadasTardeEsperado.add(empleado1);
		reporteLlegadasTardeEsperado.add(empleado2);

		assertEquals(reporteLlegadasTardeEsperado,
				microsoft.getAdministracion().getReporteDeEmpleadosQueLlegaronTarde());

	}

	@Test
	public void queSeMuestreCorrectamenteLosEmpleadosQueSeAusentaron() {
		Empleado empleado1 = new Empleado(10456789, 001, "Joan Holloway", 50000.0, 2000);
		Empleado empleado2 = new Gerente(13456711, 002, "Don Draper", 100000.0, 2000);
		Empleado empleado3 = new Desarrollador(12456730, 003, "Pete Campbell", 80000.0, 2000);
		Empleado empleado4 = new Empleado(13456789, 004, "Peggy Olson", 73000.0, 2000);

		Empresa microsoft = new Empresa("Sterling Cooper");

		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);
		microsoft.contratarEmpleado(empleado3);
		microsoft.contratarEmpleado(empleado4);

		microsoft.getAdministracion().reportarAusencia(empleado1);
		microsoft.getAdministracion().reportarAusencia(empleado3);

		HashSet<Empleado> reporteDeAusenciasesperado = new HashSet<Empleado>();
		reporteDeAusenciasesperado.add(empleado1);
		reporteDeAusenciasesperado.add(empleado3);

		assertEquals(reporteDeAusenciasesperado, microsoft.getAdministracion().getReporteDeEmpleadosQueSeAusentaron());

	}

	@Test
	public void queCalculeElCostoTotalDeProyectosTerminadosDeLaEmpresa() {
		Contaduria contaduria1 = new Contaduria();
		Gerente gerente = new Gerente(22909887, 88, "Armando Paredes", 112000.00, 1995);

		Proyecto desarrolloSistemaBanco = new Proyecto("BankSystem", 15000.00, 100000.00);
		Proyecto webECommerce = new Proyecto("TiendaOnline", 8000.00, 50000.00);
		Proyecto proyecto1 = new Proyecto("Proyecto 1", 15000.00, 100000.00);
		Proyecto proyecto2 = new Proyecto("Proyecto 2", 8000.00, 50000.00);
		Proyecto proyecto3 = new Proyecto("Proyecto 3", 9000.00, 20000.00);
		Proyecto proyecto4 = new Proyecto("Proyecto 4", 22000.00, 40000.00);
		Proyecto proyecto5 = new Proyecto("Proyecto 5", 2000.00, 5000.00);

		contaduria1.agregarProyecto(desarrolloSistemaBanco);
		contaduria1.agregarProyecto(webECommerce);
		contaduria1.agregarProyecto(proyecto1);
		contaduria1.agregarProyecto(proyecto2);
		contaduria1.agregarProyecto(proyecto3);
		contaduria1.agregarProyecto(proyecto4);
		contaduria1.agregarProyecto(proyecto5);

		gerente.comenzarProyecto(desarrolloSistemaBanco);
		gerente.terminarProyecto(desarrolloSistemaBanco);
		gerente.comenzarProyecto(webECommerce);
		gerente.terminarProyecto(webECommerce);
		gerente.comenzarProyecto(proyecto1);
		gerente.terminarProyecto(proyecto1);
		gerente.comenzarProyecto(proyecto2);
		gerente.terminarProyecto(proyecto2);
		gerente.comenzarProyecto(proyecto3);
		gerente.terminarProyecto(proyecto3);
		gerente.comenzarProyecto(proyecto4);
		gerente.terminarProyecto(proyecto4);
		gerente.comenzarProyecto(proyecto5);
		gerente.terminarProyecto(proyecto5);

		double costoEsperado = 79000.00;

		assertEquals(costoEsperado, contaduria1.costoTotalDeProyectosTerminadosDelaEmpresa(), 0.01);
	}

	@Test
	public void queCalculeGananciaTotalDeProyectosTerminadosDeLaEmpresa() {
		Contaduria contaduria1 = new Contaduria();
		Gerente gerente = new Gerente(22909887, 88, "Armando Paredes", 112000.00, 1995);

		Proyecto desarrolloSistemaBanco = new Proyecto("BankSystem", 15000.00, 100000.00);
		Proyecto webECommerce = new Proyecto("TiendaOnline", 8000.00, 50000.00);
		Proyecto proyecto1 = new Proyecto("Proyecto 1", 15000.00, 100000.00);
		Proyecto proyecto2 = new Proyecto("Proyecto 2", 8000.00, 50000.00);

		contaduria1.agregarProyecto(desarrolloSistemaBanco);
		contaduria1.agregarProyecto(webECommerce);
		contaduria1.agregarProyecto(proyecto1);
		contaduria1.agregarProyecto(proyecto2);

		gerente.comenzarProyecto(desarrolloSistemaBanco);
		gerente.terminarProyecto(desarrolloSistemaBanco);
		gerente.comenzarProyecto(webECommerce);
		gerente.terminarProyecto(webECommerce);
		gerente.comenzarProyecto(proyecto1);
		gerente.terminarProyecto(proyecto1);
		gerente.comenzarProyecto(proyecto2);
		gerente.terminarProyecto(proyecto2);

		double costoEsperado = 254000.00;

		assertEquals(costoEsperado, contaduria1.gananciaTotalDeProyectosFinalizadosDelaEmpresa(), 0.01);
	}

}
