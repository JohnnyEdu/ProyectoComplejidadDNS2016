package listas;

/**
 * @author Jonathan Baez
 * */
public class Cola{
	Lista lista;
	
	public Cola(Lista lista){
		this.lista = lista;
	}
	/**
	 * Solo agrega
	 * */
	public void poner(Object elem){
		lista.agregar(elem,lista.getTamaño());
	}
	
	/**
	 * Elimina y devuelve el eliminado
	 * */
	public Object sacar(){
		Object elem = lista.elemento(0);
		lista.eliminar(elem);
		return elem;
	}
	/**
	 * Devuelve el ultimo sin eliminarlo
	 * */
	public Object tope(){
		return lista.elemento(0);
	}
	public Boolean esVacia(){
		return lista.esVacia();
	}
	
	public String toString(){
		return this.lista.toString();
	}
}
