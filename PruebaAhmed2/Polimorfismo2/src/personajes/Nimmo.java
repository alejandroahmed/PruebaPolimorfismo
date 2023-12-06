package personajes;

import utiles.TipoMascota;

public class Nimmo extends Mascota{
	public Nimmo() {
		super.nombre = "Nimmo";
		super.tipo = TipoMascota.FUEGO;
		super.suciedad = 0;
		super.hambre = 0;
		super.sueño = 0;
		super.felicidad = 0;
	}
}