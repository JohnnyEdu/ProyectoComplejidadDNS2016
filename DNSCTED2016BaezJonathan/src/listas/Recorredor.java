package listas;
/**
 * @author Jonathan Baez
 * */
public class Recorredor {
	private Lista lista = null;
	private int actual;
	
	private Recorredor(){
	}
	/**
	 * Para que halla un único recorredor en memoria.
	Agrego syncronized para que dos objetos no puedan querer instanciar al mismo tiempo y les de null a los dos
	 * @author Johnny B.
	 * @see Singleton
	 * @return Recorredor
	 * 
	 * */
	public static Recorredor getInstance(Lista lista){
		Recorredor recorredor = new Recorredor();
		recorredor.lista = lista;
		return recorredor;
	}
	
	public void comenzar(){
		this.actual = 0;
	}
	public Object elemento(){
		Object elemento = null;
		if (this.actual < this.lista.getTamaño()){
			elemento = lista.elemento(this.actual);
		}
		return elemento;
	}
	
	public void proximo(){
		this.actual +=1;
	}
	
	public Boolean fin(){
		return actual == lista.getTamaño();
	}
	 
	public void agregar(Object elem){
		this.lista.agregar(elem,lista.getTamaño()-1);
	}
	
	public void eliminar(){
		this.lista.eliminar(this.elemento());
	}
}
