package empresaDeSoftware;

import static org.junit.Assert.*;

import java.util.HashMap;

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
		Assert.assertEquals(cantEmpleados, microsoft.getEmpleados().size(), 0.01);

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

		Administracion administracion = new Administracion();
		empleadoDePrueba1.calcularDiasDeVacaciones();
		empleadoDePrueba2.calcularDiasDeVacaciones();
		empleadoDePrueba3.calcularDiasDeVacaciones();
		empleadoDePrueba4.calcularDiasDeVacaciones();

		assertEquals(28, empleadoDePrueba1.getDiasDeVacaciones());
		assertEquals(35, empleadoDePrueba2.getDiasDeVacaciones());
		assertEquals(14, empleadoDePrueba3.getDiasDeVacaciones());
		assertEquals(21, empleadoDePrueba4.getDiasDeVacaciones());
	}

}
