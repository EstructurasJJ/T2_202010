package test.logic;

import static org.junit.Assert.*;

import model.data_structures.ListaEnlazadaStack;
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
		assertEquals(20, conexion.darTamanoStack());
	}
	
	@Test
	public void testDarNinfracciones()
	{
		ListaEnlazadaStack lista = new ListaEnlazadaStack<>();
		
		lista = conexion.ultimosNporInfraccion(3, "C02");
		assertEquals(3, lista.darTamaño());
		
		lista = conexion.ultimosNporInfraccion(50, "C02");
		assertEquals(6, lista.darTamaño());
		conexion.leerGeoJson(Controller.JUEGUEMOS);
		
		lista = conexion.ultimosNporInfraccion(2, "B02");
		assertEquals(2, lista.darTamaño());
		conexion.leerGeoJson(Controller.JUEGUEMOS);
		
		lista = conexion.ultimosNporInfraccion(2, "HOLA");
		assertEquals(0, lista.darTamaño());
	}

}
