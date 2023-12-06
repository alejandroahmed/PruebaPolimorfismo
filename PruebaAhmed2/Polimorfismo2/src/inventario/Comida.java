package Inventario;

import utiles.TipoComida;

public abstract class Comida {
	protected String nombreComida;
	protected TipoComida tipo;
	protected int cantidad = 0;
	protected int precio;
	
	public String getNombreComida() {
		return nombreComida;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public TipoComida getTipo() {
		return tipo;
	}
	
	public void aumentarCantidad() {
		this.cantidad ++;
	}
	public void reducirCantidad() {
		this.cantidad --;
		if(this.cantidad<0) {
			this.cantidad = 0;
		}
	}

}
