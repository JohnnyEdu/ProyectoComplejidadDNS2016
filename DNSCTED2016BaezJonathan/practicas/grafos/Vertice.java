package grafos;
import java.util.ArrayList;

import listas.ListaConArreglo;
import listas.Nodo;


public class Vertice{
	int posicion;
	String dato;
	ArrayList<Arista> listaAdyacentes = new ArrayList<Arista>();
	
	public Vertice(String dato){
		this.dato = dato;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public ArrayList<Arista> getListaAdyacentes() {
		return listaAdyacentes;
	}
	
	public void mostrar(){
		if (this.getListaAdyacentes().isEmpty()){
			System.out.println(this.getDato() + " no tiene adyacentes");
		}
		else{
			String adyacentes = "";
			ArrayList<Vertice> verticesAdy = new ArrayList<Vertice>();
			for (Arista a: this.getListaAdyacentes()){
//				System.out.println(this.getDato() + " <<tiene como adyacente a:>> " + a.getVerticeDestino().getDato() + " / distancia = " +a.getPeso());
				adyacentes +=","+a.getVerticeDestino().getDato();
				verticesAdy.add(a.getVerticeDestino());
			}
			adyacentes.replace(",", "");
			System.out.println(this.getDato() + "<<tiene como adyacentes >> {" + adyacentes + "}");
			
		}
	}
	
}
