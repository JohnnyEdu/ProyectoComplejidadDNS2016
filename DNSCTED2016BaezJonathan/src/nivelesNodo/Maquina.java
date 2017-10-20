package nivelesNodo;

import listas.ListaEnlazada;
/**
 * @author Jonathan Baez
 * */
public class Maquina implements NivelNodo{
	private String ip;
	private ListaEnlazada servicios;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public ListaEnlazada getServicios() {
		return servicios;
	}
	public void setServicios(ListaEnlazada servicios) {
		this.servicios = servicios;
	}
	
	public String toString(){
		String datos= "La IP es: "+ip + ", presta los siguientes servicios: " + servicios.toString();
		return datos;
	}
}
