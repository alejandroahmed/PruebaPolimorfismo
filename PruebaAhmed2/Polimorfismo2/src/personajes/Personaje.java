package personajes;

import inventario.Comida;
import inventario.Fideos;
import inventario.Manzana;
import inventario.Sushi;

public class Personaje {
	protected Mascota mascota;
	protected int monedas = 10;
	protected Comida comidas[] = new Comida[]{new Manzana(), new Fideos(), new Sushi()};
	
	public Personaje(Mascota mascota) {
		this.mascota = mascota;
	}
	
	public Mascota getMascota() {
		return mascota;
	}
	
	public int getMonedas() {
		return monedas;
	}
	
	public Comida[] getComidas() {
		return comidas;
	}
	
	public void aumentarMonedas(int cantidad) {
		this.monedas += cantidad;
	} 
	
	public void reducirMonedas(int cantidad) {
		this.monedas -= cantidad;
		if(this.monedas < 0) {
			this.monedas = 0;
		}
	}
	
	
}
