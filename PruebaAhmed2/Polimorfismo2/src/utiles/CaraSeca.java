package utiles;

public enum CaraSeca {
	CARA,
	SECA;
	static CaraSeca moneda;
	
	public static CaraSeca tirarMoneda() {
		int res = Utiles.generarRandom(1, 2);
		if(res == 1) {
			moneda = CaraSeca.CARA;
		} else if(res == 2) {
			moneda = CaraSeca.SECA;
		}
		return moneda;
	}
}
