package empresaDeSoftware;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class testEmpresa {
	
	@Test
	public void queSePuedaAgregarEmpleado() {
		Empleado empleado1 = new Empleado(13456789,001,"John Connor",50000.0,2000);
		
		Empresa microsoft = new Empresa("Microsoft");
		
		microsoft.contratarEmpleado(empleado1);
		
		assertTrue(microsoft.getEmpleados().contains(empleado1));
	}
	@Test
	public void queNoSePuedaAgregarUnEmpleado() {
		Empleado empleado1 = new Empleado(13456789,001,"John Connor",50000.0,2000);
		Empleado empleado2 = new Empleado(13456789,001,"Don Draper",100000.0,2000);
		
		Empresa microsoft = new Empresa("Microsoft");
		
		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);
		
		int cantEmpleados=1;
		Assert.assertEquals(cantEmpleados, microsoft.getEmpleados().size(),0.01);
		
	}
	
	@Test
	public void queSePuedaDarDeBajaEmpleados() {
		Empleado empleado1 = new Empleado(10456789,001,"John Connor",50000.0,2000);
		Empleado empleado2 = new Gerente(13456711,002,"Don Draper",100000.0,2000);
		Empleado empleado3 = new Empleado(12456730,003,"Diana Prince",80000.0,2000);
		Empleado empleado4 = new Empleado(13456789,004,"Peggy Olson",73000.0,2000);
		
		Empresa microsoft = new Empresa("Microsoft");
		
		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);
		microsoft.contratarEmpleado(empleado3);
		microsoft.contratarEmpleado(empleado4);
		
		microsoft.darDeBajaAEmpleado(13456789);
		microsoft.darDeBajaAEmpleado(13456711);
		
		int empleadosRestantes=2;
		Assert.assertEquals(empleadosRestantes, microsoft.getEmpleados().size(),0.01);
	}

	/* Testeo liquidacion de sueldos */
	@Test
	public void liquidarSueldos() {
		
		Empleado empleado1 = new Empleado(13456789,001,"John Connor",50000.0,2000);
		Empleado empleado2 = new Empleado(13456789,001,"Don Draper",100000.0,2000);
		Empleado empleado3 = new Empleado(13456789,001,"Diana Prince",80000.0,2000);
		Empleado empleado4 = new Empleado(13456789,001,"Peggy Olson",73000.0,2000);
		
		/*4 llegadas tarde suman una ausencia */
		
		/* Empleados de base tienen una tolerancia de 2 faltas */
		
		/* El empleado uno tiene 2 ausencias y 4 llegas tarde, lo que da un total de 3 ausencias. 
		 Se le deberá descontar de su suedo 3 dias de trabajo.  50000-7500=42500*/
		
		empleado1.reportarAusencia();
		empleado1.reportarAusencia();
		for (int i = 0; i < 4; i++) {
			empleado1.reportarLlegadaTarde();
		}
		
		/* El empleado dos tiene 2 ausencias. Está dentro de la tolerancia, no se le debe descontar. */
		//empleado2.reportarAusencia();
		//empleado2.reportarAusencia();
		
		/* El empleado 3 tiene 7 llegadas tarde. Eso contabiliza 3 ausencias. Se le debe descontar 12000 */
		for (int i = 0; i < 7; i++) {
		empleado3.reportarLlegadaTarde();;
		}
		
		/* El empleado 4 no tiene ausencias. Deberá cobrar un adicional de 2000 */
		
		
		
		
		/* En este HashMap se guardan los empelados con lo sueldos esperados */
		HashMap<Empleado, Double> sueldosEsperados = new HashMap<Empleado,Double>();
		sueldosEsperados.put(empleado1, 42500.0);
		sueldosEsperados.put(empleado2, 100000.0);
		sueldosEsperados.put(empleado3, 68000.0);
		sueldosEsperados.put(empleado4, 75000.0);
		
		Empresa microsoft = new Empresa("Microsoft");
		
		microsoft.contratarEmpleado(empleado1);
		microsoft.contratarEmpleado(empleado2);
		microsoft.contratarEmpleado(empleado3);
		microsoft.contratarEmpleado(empleado4);
		
		
		assertTrue(microsoft.liquidarSueldos().equals(sueldosEsperados));
	}

}
