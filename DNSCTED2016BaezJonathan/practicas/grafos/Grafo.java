package grafos;
import java.util.ArrayList;

import listas.Lista;
import listas.ListaConArreglo;
import listas.ListaEnlazada;
import listas.Recorredor;


public class Grafo {
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	public void agregarVertice(Vertice v){
		vertices.add(v);
	}
	public void eliminarVertice(Vertice v){
		vertices.remove(v);
	}
	public void conectar(Vertice origen, Vertice destino, int peso){
		Arista arista = new Arista();
//		Arista aristaInversa = new Arista();
		arista.peso = peso;
//		aristaInversa.peso = peso;
		
		arista.verticeDestino = destino;
		//Cada vertice tiene al otro como adyacente
		origen.getListaAdyacentes().add(arista);
		
//		aristaInversa.verticeDestino = origen;
//		destino.getListaAdyacentes().add(aristaInversa);
	}
	//comento porque es dirigido ahora
	public void desConectar(Vertice origen, Vertice destino){
		//Recorrido adyacentes origen
		if (!vertices.isEmpty()){
			for (Vertice v: vertices){
				if (v.equals(origen)){
						try{
							for (Arista a: v.getListaAdyacentes()){
								if (a.getVerticeDestino().equals(destino)){
									v.getListaAdyacentes().remove(a);
									}
								}
						}catch(Exception e){
							break;
						}
				}
			}
		//Recorrido adyacentes destino
//			for (Vertice v: vertices){
//				if (v.equals(destino)){
//						try{
//							for (Arista a: v.getListaAdyacentes()){
//								if (a.getVerticeDestino().equals(origen)){
//									v.getListaAdyacentes().remove(a);
//								}
//							}
//						}catch(Exception e){
//							break;
//						}
//				}
//			}
		}
	}
	
	public ArrayList<Vertice> getListaDeVertices() {
		return vertices;
	}
	public Vertice vertice(int pos){
		return vertices.get(pos);
	}
	
	public void display(){
		for (Vertice v: vertices){
			v.mostrar();
		}
	}
}
