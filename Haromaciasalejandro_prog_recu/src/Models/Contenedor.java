package Models;


import Models.*;

public class Contenedor {
	private static final Contenedor contenedor = new Contenedor();
	private ListaOrdenadaNoRepetida<Pokemon> lista;
	
	/**
	 * Crea un nuevo objeto de tipo contenedor.
	 */
	private Contenedor(){};
	

	/**
	 * Devuelve la ListaOrdenada que contiene el contenedor.
	 * @return
	 */
	public ListaOrdenadaNoRepetida getLista(){
		if (lista == null)
			lista = new ListaOrdenadaNoRepetida<Pokemon>(
					(Pokemon p1, Pokemon p2) -> p2.getNumero().compareTo(p1.getNumero()));
		return lista;
	}
	
	/**
	 * Devuelve la única instancia de la clase Contenedor que puede existir.
	 * @return una referencia al objeto Contenedor.
	 */
	public static Contenedor getInstance() {
        return contenedor;
    }

}
