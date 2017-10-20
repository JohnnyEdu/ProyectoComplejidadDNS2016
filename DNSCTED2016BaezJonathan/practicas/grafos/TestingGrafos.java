package grafos;


public class TestingGrafos {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		Vertice uno = new Vertice("1");
		Vertice dos = new Vertice("2");
		Vertice tres = new Vertice("3");
		Vertice cuatro = new Vertice("4");
		Vertice cinco = new Vertice("5");
		Vertice seis = new Vertice("6");
		Vertice siete = new Vertice("7");
		
		grafo.agregarVertice(uno);
		grafo.agregarVertice(dos);
		grafo.agregarVertice(tres);
		grafo.agregarVertice(cuatro);
		grafo.agregarVertice(cinco);
		grafo.agregarVertice(seis);
		grafo.agregarVertice(siete);
		
		//grafo 1
//		grafo.conectar(uno, dos, 23);
//		grafo.conectar(uno, cuatro, 34);
//		grafo.conectar(uno, tres, 5);
//		grafo.conectar(dos, cinco, 18);
//		grafo.conectar(tres, cuatro, 15);
//		grafo.conectar(tres, cinco, 25);
//		grafo.conectar(cuatro, cinco, 3);
		
		
		//grafo 2
		grafo.conectar(uno, dos, 23);
		grafo.conectar(uno, cuatro, 34);
		
		grafo.conectar(dos, cinco, 18);
		
		grafo.conectar(tres, cinco, 6);
		
		grafo.conectar(cuatro, dos, 53);
		grafo.conectar(cuatro, cinco, 33);
		grafo.conectar(cuatro, seis, 13);
		grafo.conectar(cuatro, tres, 23);
		
		grafo.conectar(cinco, siete, 5);
		
		grafo.conectar(seis, tres, 5);
		grafo.conectar(seis, siete, 4);
		
		grafo.display();
//		grafo.desConectar(cuarto, primero);
		grafo.display();
//		grafo.desConectar(segundo, tercero);
		grafo.display();
		
		Recorridos recorrerDFS = new Recorridos();
		recorrerDFS.DFS(grafo, uno);
		
//		
//		Recorridos recorrerBFS = new Recorridos();
//		recorrerBFS.BFS(grafo, uno);
	}

}
