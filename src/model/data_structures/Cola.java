package model.data_structures;

import java.util.Queue;

public class Cola<T> {

	private Node<T> primero;
	private Node<T> ultimo;
	private int size;
	
	public Cola()
	{
		primero = null;
		ultimo = null;
		size = 0;
	}
	
	public void enqueue(T item)
	{
		Node<T> nuevo = new Node<T>(item);
		
		if(size == 0)
		{
			primero = nuevo;
			ultimo = nuevo;
		}
		else{
			Node<T> viejo = ultimo;
			viejo.cambiarSiguiente(nuevo);
			ultimo = nuevo;
		}
		size++;
	}
	
	public T dequeue(T item)
	{
		 	Node<T> viejo = primero;
		 	T buscado = primero.darElemento();
		 	primero = viejo.darSiguiente();
		 	viejo.cambiarSiguiente(null);
		 	size--;
		 	return buscado;
		
	}
	
	public int darTamano()
	{
		return size;
	}
	
	
}
