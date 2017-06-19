package Models;

public class Pokemon {
	public static enum Tipo { Agua, Fuego, Planta };
	private String nombre,region;
	private String numero;
	private String tipo;
	private String nivel;
	private String comentarios;
	public Pokemon(String nombre, String region, String numero, String tipo, String nivel, String comentarios) {
		super();
		this.nombre = nombre;
		this.region = region;
		this.numero = numero;
		this.tipo = tipo;
		this.nivel = nivel;
		this.comentarios = comentarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", region=" + region + ", numero=" + numero + ", tipo=" + tipo + ", nivel="
				+ nivel + ", comentarios=" + comentarios + "]";
	}
}
