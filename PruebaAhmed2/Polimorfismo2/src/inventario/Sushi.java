package Inventario;

import utiles.TipoComida;

public class Sushi extends Comida{
	public Sushi() {
		super.nombreComida = "Sushi";
		super.tipo = TipoComida.SUSHI;
		super.cantidad = 0;
		super.precio = 10;
	}
}
