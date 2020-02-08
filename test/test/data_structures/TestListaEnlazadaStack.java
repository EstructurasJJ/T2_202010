package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import model.data_structures.ListaEnlazadaSimple;
import model.data_structures.ListaEnlazadaStack;
import model.logic.Comparendo;
import model.logic.Modelo;

public class TestListaEnlazadaStack 
{
	private Modelo conexion;
	private ListaEnlazadaStack<Comparendo> lista;
	
	@Before
	public void setUp()
	{
		conexion = new Modelo();
		conexion.leerGeoJson(Controller.JUEGUEMOS);
		
		lista = new ListaEnlazadaStack<>();
		
		for (int i = 0; i<100; i++)
		{
			Comparendo nuevo = new Comparendo();
			nuevo.asignarObjectid(i);
			
			lista.push(nuevo);
		}
	}
	
	@Test
	public void testListaStackCarga()
	{
		assertTrue(conexion.darDatos()!=null);
		assertEquals(20, conexion.darTamano());
	}
	
	@Test
	public void darTama�o()
	{
		Comparendo nuevo = new Comparendo();
		lista.push(nuevo);
		
		assertEquals(101, lista.darTama�o());
	}
	
	@Test
	public void testProbarNodoCargadoYNormal()
	{
		assertTrue(conexion.darDatos().devolverCabezaPila()!=null);
		assertTrue(lista.devolverCabezaPila()!=null);
	}
	
	@Test
	public void testPush()
	{
		assertEquals(100, lista.darTama�o());
		
		Comparendo nuevo = new Comparendo();
		lista.push(nuevo);
		
		assertEquals(101, lista.darTama�o());
		
		for (int i = 150; i<180; i++)
		{
			Comparendo nuevo2 = new Comparendo();
			nuevo2.asignarObjectid(i);
			
			lista.push(nuevo2);
		}
		
		assertEquals(131, lista.darTama�o());
	}
	
	@Test
	public void testPop()
	{
		assertEquals(100, lista.darTama�o());

		lista.pop();
		
		assertEquals(99, lista.darTama�o());
		
		for (int i = 0; i<50; i++)
		{
			lista.pop();
		}
		
		assertEquals(49, lista.darTama�o());
		
	}
	
	@Test
	public void testIsEmpty()
	{
		ListaEnlazadaStack lista2 = new ListaEnlazadaStack<>();
		assertTrue(lista2.isEmpty()==true);
		
		assertTrue(lista.isEmpty()==false);
	}
	
}
