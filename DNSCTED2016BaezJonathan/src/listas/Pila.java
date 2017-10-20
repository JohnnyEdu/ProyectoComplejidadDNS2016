package listas;

/**
 * @author Jonathan Baez
 * */
public class Pila{
	private Lista datos;
	
	public Pila(Lista lista){
		datos = lista;
	}
	
	public void poner(Object elem){
		if (datos.esVacia()){
			this.datos.agregar(elem,0);
		}
		else{
			this.datos.agregar(elem,this.datos.getTamaño());
		}
		
	}
	public Object sacar(){
		Object elem = this.datos.elemento(this.datos.getTamaño()-1);
		this.datos.eliminar(elem);
		return elem;
	}
	
	public Object tope(){
		return  this.datos.elemento(this.datos.getTamaño()-1);
	}
	public Boolean esVacia(){
		return this.datos.esVacia();
	}
	
	@Override
	public String toString() {
		return datos.toString();
	}
}
