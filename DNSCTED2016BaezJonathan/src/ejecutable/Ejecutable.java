package ejecutable;

import java.util.Scanner;
import Modulos.PantallaOpcionesAdmin;
import Modulos.PantallaOpcionesConsulta;
import arboles.ArbolGeneralDNS;
import arboles.NodoGeneral;

/***
 @author Jonathan Baez
 */
public class Ejecutable {
	private static Scanner sc = new Scanner(System.in);
	private static ArbolGeneralDNS arbolNuevo = new ArbolGeneralDNS(new NodoGeneral("Servidor DNS"));
	private static PantallaOpcionesConsulta pantallaConsultas = new PantallaOpcionesConsulta(arbolNuevo);
	private static PantallaOpcionesAdmin pantallaAdmin = new PantallaOpcionesAdmin(arbolNuevo);
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println('\b');
		}
		Scanner sc = new Scanner(System.in);
		pantallaInicial();
		System.out.println("Su opcion es: ");
		String opcion = sc.nextLine();
		
		while(!opcion.equals("3")){
			if(opcion.equals("1")){
				pantallaAdmin.pantallaOpcionesAdmin();
			}
			else if(opcion.equals("2")){
				pantallaConsultas.pantallaOpcionesConsulta();
			}
			else{
				opcion = sc.nextLine();
			}
		}
		System.err.println("Saliendo de la aplicación...");
		System.exit(0);
		
	}
	
	private static void pantallaInicial(){
		System.out.println("Bienvenido a la aplicación de gestión de Servidores DNS");
		System.out.println("Por favor elija una de las siguientes opiciones:");
		System.out.println("1-Iniciar módulo de administracion");
		System.out.println("2-Iniciar módulo de consultas");
		System.out.println("3-Salir de la aplicación");

	}
}
