package nivelesNodo;

import listas.ListaEnlazada;
/**
 * @author Jonathan Baez
 * */
public class Subdominio implements NivelNodo{
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
	@Override
	public String toString() {
		return "Subdominio";
	}
	
}
