package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;

public class TestModelo {
	
	private Modelo conexion;
	
	@Before
	public void setUp() 
	{
		conexion = new Modelo();
		conexion.leerGeoJson(Controller.JUEGUEMOS);
	}

	@Test
	public void testModelo() 
	{
		assertTrue(conexion.darDatos()!=null);
	}

	@Test
	public void testDarTamano() 
	{
		assertEquals(20, conexion.darTamano());
	}
	
	@Test
	public void testBuscar() 
	{
		assertTrue(conexion.buscar(29042)!=null);
		assertTrue(conexion.buscar(509329)!=null);
		assertTrue(conexion.buscar(519553)!=null);
		assertTrue(conexion.buscar(176695)!=null);
		assertTrue(conexion.buscar(395846)!=null);
		assertTrue(conexion.buscar(46500)!=null);
		assertTrue(conexion.buscar(58338)!=null);
		assertTrue(conexion.buscar(184177)!=null);
		assertTrue(conexion.buscar(395366)!=null);
		assertTrue(conexion.buscar(444949)!=null);
		assertTrue(conexion.buscar(264952)!=null);
		assertTrue(conexion.buscar(174761)!=null);
		assertTrue(conexion.buscar(56712)!=null);
		assertTrue(conexion.buscar(480983)!=null);
		assertTrue(conexion.buscar(361767)!=null);
		assertTrue(conexion.buscar(299457)!=null);
		assertTrue(conexion.buscar(467527)!=null);
		assertTrue(conexion.buscar(246062)!=null);
		assertTrue(conexion.buscar(224494)!=null);
		assertTrue(conexion.buscar(209146)!=null);
	}

}
