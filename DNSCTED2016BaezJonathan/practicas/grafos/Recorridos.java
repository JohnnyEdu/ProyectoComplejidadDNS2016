package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Recorridos {
	ArrayList<Vertice> tablaNoVisitados = new ArrayList<Vertice>();
	ArrayList<Vertice> tablaVisitados = new ArrayList<Vertice>();
	ArrayList<Vertice>familia = new ArrayList<Vertice>();
//	public void DFS(Grafo grafo,Vertice origen){
//		/**
//		 * el recorrido va--> empieza por el origen
//		 * 1-marca origen como visitado
//		 * 2-elije un adyacente
//		 * 3-marca como visitado ese adyacente
//		 * 4-no tiene mas adyacentes?
//		 * 5-backTracking
//		 * */
//		tablaVisitados.add(origen);//marco como visitado
//		System.err.println("Actual DFS: -->" + origen.getDato());//imprimo su dato
//		if (!origen.getListaAdyacentes().isEmpty()){//si tiene adyacentes
//				for (Arista a: origen.getListaAdyacentes()){
//					//si no esta en la tabla se trata sino que salte a otro ady
//					if (a.getVerticeDestino()!=null &&!tablaVisitados.contains(a.getVerticeDestino())){//si contiene el que sigue
//							DFS(grafo,a.getVerticeDestino());
//						}
//				}
//		}else{//si no tiene adyacentes que vuelva. Agarrando el penultimo(el ultimo es el actual, origen)
//			System.err.println("Backtracking");
//			DFS(grafo,tablaVisitados.get(tablaVisitados.size()-2));
//		}
//	}
	
	public void DFS(Grafo grafo, Vertice origen){
		//lista de los que todavia no se visitaron
		if (tablaNoVisitados.isEmpty()){
			tablaNoVisitados.addAll(grafo.getListaDeVertices());
		}
//		saco el primero
		tablaNoVisitados.remove(origen);
		tablaVisitados.add(origen);
		System.out.println(origen.getDato());
		if (!origen.getListaAdyacentes().isEmpty()){
			for (Arista arista: origen.getListaAdyacentes()){
				Vertice adyacente = arista.getVerticeDestino();
				if (adyacente!=null && !tablaVisitados.contains(adyacente)){
					tablaVisitados.add(adyacente);
					DFS(grafo,adyacente);
				}else{
					Boolean quedanSinVisitar =false;
					for (Arista v: origen.getListaAdyacentes()){
						if (tablaNoVisitados.contains(v.getVerticeDestino())){
							quedanSinVisitar = true;
						}
					}
					if (!quedanSinVisitar){
						//Backtracking
						
						DFS(grafo,tablaVisitados.get(tablaVisitados.indexOf((origen))-1));
						}
					}
				}	
			}else{
				System.out.println("Backtracking");
			DFS(grafo,tablaVisitados.get(tablaVisitados.indexOf((origen))-1));
		}
		
	}

	
	public void BFS(Grafo grafo,Vertice origen){
		/**
		 * el recorrido va--> empieza por el origen
		 * 1-marca origen como visitado
		 * 2-conocer adyacentes
		 * 3-marca como visitado los adyacentes
		 * 4-no tiene mas adyacentes?
		 * 5-backTracking
		 * <<recursivamente>>
		 * */
		
		tablaVisitados.add(origen);//marco como visitado
		familia.remove(origen);
		System.err.println("Actual BFS: -->" + origen.getDato());//imprimo su dato
		if (!origen.getListaAdyacentes().isEmpty()){//si tiene adyacentes
			for (Arista a: origen.getListaAdyacentes()){
				//si no esta en la tabla se trata sino que salte a otro ady
				if (a.getVerticeDestino()!=null &&!(tablaVisitados.contains(a.getVerticeDestino()))){//si contiene el que sigue
					tablaVisitados.add(a.getVerticeDestino());
					familia.add(a.getVerticeDestino());
					System.out.println(a.getVerticeDestino().getDato() + " Soy un adyacente de " + origen.getDato());
					
					}
			}
				BFS(grafo,familia.get(0));
			}
			
		//si no tiene adyacentes que vuelva. Agarrando el penultimo(el ultimo es el actual, origen)
	}
}
	
//	
//	public void caminoSimpleConDFS(Grafo grafo,Vertice origen, Vertice destino){}
//	
//	public void verticesADistanciaConBFS((Grafo grafo,Vertice origen,int nroAristas){}
