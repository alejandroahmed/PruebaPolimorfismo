package personajes;

import utiles.TipoMascota;

public class Mecca extends Mascota {
	public Mecca() {
		super.nombre = "Mecca";
		super.tipo = TipoMascota.AIRE;
		super.suciedad = 0;
		super.hambre = 0;
		super.sueño = 0;
		super.felicidad = 0;
	}
}
