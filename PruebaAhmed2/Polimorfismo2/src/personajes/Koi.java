package personajes;

import utiles.TipoMascota;

public class Koi extends Mascota{
	public Koi() {
		super.nombre = "Koi";
		super.tipo = TipoMascota.AGUA;
		super.suciedad = 0;
		super.hambre = 0;
		super.sueño = 0;
		super.felicidad = 0;
	}
}
