package empresaDeSoftware;

import static org.junit.Assert.*;

import org.junit.Test;

public class testEmpleado {

	@Test
	public void crearEmpleado() {
		Empleado empleadoDePrueba = new Empleado(13456789,001,"Juan Perez",50000.0,2000);
		assertEquals("13456789 1 Juan Perez 50000.0 2000", empleadoDePrueba.toString());
	}
	
	@Test
	public void calculoVacaciones() {
		Empleado empleadoDePrueba1 = new Empleado(13456789,001,"Juan Perez",50000.0,2005);
		Empleado empleadoDePrueba2 = new Empleado(10890567,002,"Estela Maris",75000.0,1980);
		Empleado empleadoDePrueba3 = new Empleado(44567889,003,"Amancio Jackson",35000.0,2019);
		Empleado empleadoDePrueba4 = new Empleado(45990876,004,"Juana Gomez",35000.0,2014);
		
		
		
		assertEquals(28, empleadoDePrueba1.getDiasDeVacaciones());
		assertEquals(35, empleadoDePrueba2.getDiasDeVacaciones());
		assertEquals(14, empleadoDePrueba3.getDiasDeVacaciones());
		assertEquals(21, empleadoDePrueba4.getDiasDeVacaciones());
		
	}

}

