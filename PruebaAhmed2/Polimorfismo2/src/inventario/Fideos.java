package Inventario;

import utiles.TipoComida;

public class Fideos extends Comida{
	public Fideos() {
		super.nombreComida = "Fideos";
		super.tipo = TipoComida.FIDEOS;
		super.cantidad = 0;
		super.precio = 5;
	}
}
