package Inventario;

import utiles.TipoComida;

public class Manzana extends Comida{
	public Manzana() {
		super.nombreComida = "Manzana";
		super.tipo = TipoComida.MANZANA;
		super.cantidad = 0;
		super.precio = 1;
	}
}
