package Modulos;


import arboles.ArbolGeneralDNS;
import listas.Cola;
import listas.Lista;
import listas.ListaConArreglo;
import listas.Nodo;
import listas.Pila;
import listas.Recorredor;
import utils.Utilidades;
/**
 * @author Jonathan Baez
 * Modulo utilizado para abstraer de ArbolGeneralDNS las operaciones de consulta
 * */
public class ModCons {
	ArbolGeneralDNS arbolTarget;
	static Boolean quedanSinImprimir;
	public ModCons(ArbolGeneralDNS arbol){
		arbolTarget = arbol;
	}
	
	
	public void imprimirNivelSuperior(){
		System.out.println(arbolTarget.getRaiz().getDato());
		if (!arbolTarget.getHijos().esVacia()){
				Recorredor recorrerHijos = Lista.recorredor(arbolTarget.getHijos());
				recorrerHijos.comenzar();
				System.out.println("Dominos de nivel superior: {");
				while (!recorrerHijos.fin()){
					Nodo actual = (Nodo)recorrerHijos.elemento();
					ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
					System.out.println(arbol.getRaiz().getDato());
					recorrerHijos.proximo();
				}
				System.out.println("}");
			}
	}
	public void imprimirNivelMedio(){
		if (!arbolTarget.getHijos().esVacia()){
			Recorredor recorrerHijos = Lista.recorredor(arbolTarget.getHijos());
			recorrerHijos.comenzar();
			System.out.println("Dominos de nivel medio: {");
			while (!recorrerHijos.fin()){
				Nodo actual = (Nodo)recorrerHijos.elemento();
				ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
				arbol.imprimirHijos();
				recorrerHijos.proximo();
			}
			System.out.println("}");
		}else{
			System.out.println("No tiene dominio medio");
		}
	}
	public void imprimirHijos(){
		Recorredor recorrerHijos = Lista.recorredor(arbolTarget.getHijos());
		recorrerHijos.comenzar();
		while (!recorrerHijos.fin()){
			Nodo actual = (Nodo) recorrerHijos.elemento();
			ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
			System.out.println("Mi nombre es:" + arbol.getRaiz() + " y soy hijo de -->" + arbolTarget.getRaiz());
			recorrerHijos.proximo();
		}
	}

	
	/**
	 * Dado un nodo(subdominio) imprime los nodos hijos
	 * */
//	public void imprimmirSubdominios(String dominio,Cola cola){
//			Recorredor recorrerNodos = Lista.recorredor(arbolTarget.getHijos());
//			recorrerNodos.comenzar();
//			while(!recorrerNodos.fin()){
//				Nodo actual = (Nodo)recorrerNodos.elemento();
//				ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
//				//primera ocurrencia paso a imprimir
//				if (arbol.getRaiz().getDato().equalsIgnoreCase(dominio)){
//					System.out.println("Subdominio "+dominio+" ,como hijo de --->"+arbolTarget.getRaiz().getDato() );
//					Recorredor recorrerNodosTarget = Lista.recorredor(arbol.getHijos());
//					recorrerNodosTarget.comenzar();
//					System.out.println("Del mismo dependen:");
//					while(!recorrerNodosTarget.fin()){
//						Nodo actualHijo = (Nodo)recorrerNodosTarget.elemento();
//						ArbolGeneralDNS arbolHijo = (ArbolGeneralDNS)actualHijo.getDato();
//						System.out.println(arbolHijo.getRaiz().getDato());
//						recorrerNodosTarget.proximo();
//					}
//				}
//				cola.poner(arbol);
//				recorrerNodos.proximo();
//			}//busco en los que fui dejando atras si tiene a dominio
//			if(!cola.esVacia()){
//				((ArbolGeneralDNS)cola.sacar()).imprimmirSubdominios(dominio, cola);
//			}
//	}
//	
	public Pila imprimirRamasHijas(Pila pila,ArbolGeneralDNS subdominioLimite){
		Recorredor recorrerHijos = Lista.recorredor(arbolTarget.getHijos());
		recorrerHijos.comenzar();
		//hago otro while debido al error de que no sabe cuando termina debido a que evaluo el ultimo y el ultimo puede no ser el nodo cual empece
		//ya que voy anidandome a las hojas y van quedando nodos padres.
		if(!arbolTarget.getHijos().esVacia()){
			while(!recorrerHijos.fin()){
				Nodo actualHijo = (Nodo)recorrerHijos.elemento();
				ArbolGeneralDNS arbolHijo = (ArbolGeneralDNS)actualHijo.getDato();
				pila.poner(arbolHijo);
				arbolHijo.imprimirRamasHijas(pila,subdominioLimite);
				recorrerHijos.proximo();
			}
		}else{
			//uso un contador que vaya diciedome si quedan maquinas para imprimir(nodos sin hijos)
			quedanSinImprimir=true;
		}
		//quedanSinImprimir me dice si terminan las impresiones
		if(!pila.tope().equals(subdominioLimite) && quedanSinImprimir){
			//imprime solo si no quedo vacia la lista de hijos
			quedanSinImprimir =false;
			System.out.println("Equipo dependiente al subdominio -->"+ pila);
		}
		pila.sacar();
		return pila;
	}

	public void imprimirSubdominios(String subdominio,Pila pila){
		Recorredor recorrerHijos = Lista.recorredor(arbolTarget.getHijos());
		recorrerHijos.comenzar();
		if (arbolTarget.getHijos().esVacia()){
			pila.sacar();
		}
		else{
			while(!recorrerHijos.fin()){
				Nodo actualHijo = (Nodo)recorrerHijos.elemento();
				ArbolGeneralDNS arbolHijo = (ArbolGeneralDNS)actualHijo.getDato();
				String datoHijo = arbolHijo.getRaiz().getDato();
				//encolo el hijo de la raiz
				pila.poner(arbolHijo);
				if (datoHijo.equalsIgnoreCase(subdominio)){
					Recorredor recorrerHijosDependientes = Lista.recorredor(arbolHijo.getHijos());
					recorrerHijosDependientes.comenzar();
					Pila invertida = Utilidades.invertirPila(pila);
					while(!recorrerHijosDependientes.fin()){
						actualHijo = (Nodo)recorrerHijosDependientes.elemento();
						arbolHijo = (ArbolGeneralDNS)actualHijo.getDato();
						if (arbolHijo.getHijos().esVacia()){
							System.out.println("Equipo dependiente al subdominio: " +arbolHijo.toString()+"."+ invertida.toString());
 	//						pila = colaAleatoria;
						}
						else{
							invertida = Utilidades.invertirPila(invertida);
							invertida.poner(arbolHijo);
							arbolHijo.imprimirRamasHijas(invertida,(ArbolGeneralDNS)invertida.tope());
							
						}
						recorrerHijosDependientes.proximo();
					}
					pila = invertida;
				}
				arbolHijo.imprimirSubdominios(subdominio,pila);
				recorrerHijos.proximo();
			}
			//saco en el backtracking
			pila.sacar();
		}
	}

	public void imprimirDescripcionDominio(Pila url){
		Recorredor recorrerHijos = Lista.recorredor(arbolTarget.getHijos());
		recorrerHijos.comenzar();
		String nodoAInsertar = (String)url.sacar();
		Boolean existe=false;
		while(!recorrerHijos.fin()){
			Nodo actualHijo = (Nodo)recorrerHijos.elemento();
			ArbolGeneralDNS arbolHijo = (ArbolGeneralDNS)actualHijo.getDato();
			if(arbolHijo.getRaiz().getDato().equalsIgnoreCase(nodoAInsertar)){
				existe = true;
				if(!url.esVacia()){
					arbolHijo.imprimirDescripcionDominio(url);
				}
				else{
					System.out.println("La máquina es: "+ arbolHijo.toString()+",sus caracteristicas son:" + arbolHijo.getNivelNodo().toString());
					break;
				}
			}
			else{
				existe =false;
			}
			recorrerHijos.proximo();
		}
		if (!existe && !url.esVacia()){
			System.out.println("El dominio indicado no existe en la base");
		}
	}
	
	public void imprimirPorProfundidad(int profundidad){
		Cola cola = new Cola(new ListaConArreglo());
		Cola cola2 = new Cola(new ListaConArreglo());
		int profundidadTarget = 0;
		ayudaImpresion(profundidad,profundidadTarget,cola,cola2);
	}
	
	public void ayudaImpresion(int profundidad,int profundidadIterativa,Cola cola, Cola cola2){
		if(profundidad == profundidadIterativa){
			if(!cola.esVacia()){
				System.out.println("Los nodos ubicados a esa profundidad son:");
				String nodos = "";
				while(!cola.esVacia()){
					nodos+=cola.sacar()+ ",";
				}
				nodos = nodos.substring(0,nodos.length()-1);
				System.out.println(nodos);
			}
			else{
				System.out.println("No hay nodos ubicados a esa altura");
			}
		}
		else{//empezando por la raiz (nodo unico)
			if(profundidadIterativa==0){
				Recorredor recorrerNodos = Lista.recorredor(arbolTarget.getHijos());
				recorrerNodos.comenzar();
				while(!recorrerNodos.fin()){
					Nodo actual = (Nodo)recorrerNodos.elemento();
					ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
					cola.poner(arbol);
					recorrerNodos.proximo();
				}
				profundidadIterativa+=1;
				ayudaImpresion(profundidad, profundidadIterativa, cola, cola2);
			}
			else{
				Cola colaNivel = new Cola(new ListaConArreglo());
				while(!cola.esVacia()){
					Recorredor recorrerNodos = Lista.recorredor(((ArbolGeneralDNS)cola.sacar()).getHijos());
					recorrerNodos.comenzar();
					while(!recorrerNodos.fin()){
						Nodo actual = (Nodo)recorrerNodos.elemento();
						ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
						colaNivel.poner(arbol);
						recorrerNodos.proximo();
					}
				}
				profundidadIterativa+=1;
				ayudaImpresion(profundidad, profundidadIterativa, colaNivel, cola2);
			}
		}
		
	}
}
