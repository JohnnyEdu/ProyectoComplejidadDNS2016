package listas;
/**
 * @author Jonathan Baez
 * */
public abstract class Lista {
	protected int tamanio;
	
	public Object elemento(int pos){return new Object();};
	
	public void agregar(Object elem,int pos){};
	
	public void eliminar(Object elem){
		Recorredor recorredor = recorredor(this);
		recorredor.comenzar();
		while (!recorredor.fin()){
			if (recorredor.elemento().equals(elem)){
				recorredor.eliminar();
			}
			recorredor.proximo();
		}
	}
	
	public Boolean esVacia(){return new Boolean(true);}
	
	public Boolean incluye(Object elem){
		Recorredor recorredor = recorredor(this);
		recorredor.comenzar();
		Boolean incluye = false;
		while (!recorredor.fin()){
			if (recorredor.elemento() == elem){
				incluye =  true;
			}
			recorredor.proximo();
		}
		return incluye;
	}
	
	public static Recorredor recorredor(Lista lista){
		return Recorredor.getInstance(lista);
	}
	
	public int getTamaño(){
		return this.tamanio;
		}
	
}
