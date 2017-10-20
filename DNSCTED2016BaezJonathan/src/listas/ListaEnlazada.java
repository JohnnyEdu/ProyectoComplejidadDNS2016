package listas;

/**
 * @author Jonathan Baez
 * */
public class ListaEnlazada extends Lista{
	private Nodo inicial;
	
	public Object elemento(int pos){
		Nodo actual = this.inicial;
		int contador =0;
		if (pos > 0){
			while (actual.getSiguiente()!=null){
				contador +=1;
				if (contador == pos){
					actual =  actual.getSiguiente();
					break;
				}
				actual = actual.getSiguiente();
			}
		}
		return actual;
	}
	public void agregar(Nodo elem){
		this.tamanio += 1;
		if (this.inicial == null){
			this.inicial = elem;
		}
		else if (this.inicial.getSiguiente()==null){
			this.inicial.setSiguiente(elem);
		}
		else{
			Nodo aux = inicial;
			while (aux.getSiguiente()!=null){
				aux = aux.getSiguiente();
				}
			aux.setSiguiente(elem);
		}
		
	}
	public void eliminar(Nodo elem){
		
		if (this.inicial.equals(elem)){
			this.inicial = this.inicial.getSiguiente();
			this.tamanio -= 1;
		}
		else{
			Nodo aux = inicial;
			while (!aux.getSiguiente().equals(elem)){
				aux = aux.getSiguiente();
				}
			aux.setSiguiente(aux.getSiguiente().getSiguiente());
			this.tamanio -= 1;
		}
	}
	
	public Boolean esVacia(){
		if (this.inicial == null){
			return true;
		}
		else{
			return false;
		}
	}

	public String toString(){
		//invoca al toString del tipo de objeto que tenga el nodo
		Nodo actual = inicial;
		String datos = "";
		if(actual!=null){
			while(actual.getSiguiente()!=null){
				datos+=actual.toString();
				actual = actual.getSiguiente();
				datos+=" ";
			}
		}
		return datos;
	}

}
