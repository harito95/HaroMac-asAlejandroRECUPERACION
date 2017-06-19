package Models;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaOrdenadaNoRepetida<E> extends ArrayList<E> {

	Comparator<? super E> comparador;

	/**
	 * Crea una nueva lista con que se ordenar� con el comparador pasado por el constructor.
	 * @param el comparador utilizado para la ordenaci�n de la lista.
	 */
	public ListaOrdenadaNoRepetida(Comparator<? super E> c) {
		comparador = c;
	}

	/**
	 * Inserta un nuevo objeto en la lista. Luego ordena la lista.
	 */
	@Override
	public boolean add(E e) {
		boolean retorno = super.add(e);

		super.sort(comparador);

		return retorno;
	}

	/**
	 * Elimina un objeto de la lista. Luego ordena la lista.
	 */
	@Override
	public boolean remove(Object o) {
		boolean retorno = super.remove(o);
		super.sort(comparador);
		return retorno;
	}

	/**
	 * Elimina un objeto de la lista y lo devuelve. Luego ordena la lista.
	 */
	@Override
	public E remove(int index) {
		E elemento = super.remove(index);
		super.sort(comparador);
		return elemento;
	}
}
