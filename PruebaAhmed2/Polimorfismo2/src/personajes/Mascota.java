package personajes;

import utiles.TipoComida;
import utiles.TipoMascota;
import utiles.Utiles;

public abstract class Mascota {
	protected String nombre;
	protected TipoMascota tipo;
	protected int suciedad, hambre, sueño, felicidad;
	
	public String getNombre() {
		return nombre;
	}
	public TipoMascota getTipo() {
		return tipo;
	}
	public int getSuciedad() {
		return suciedad;
	}
	public int getHambre() {
		return hambre;
	}
	public int getSueño() {
		return sueño;
	}
	public int getFelicidad() {
		return felicidad;
	}
	
	
	public void reducirSuciedad(int cantidad) {
		this.suciedad -= cantidad;
		if(this.suciedad < 0) {
			this.suciedad = 0;
		}
	}
	public void reducirFelicidad(int cantidad) {
		this.felicidad -= cantidad;
		if(this.felicidad < 0) {
			this.felicidad = 0;
		}
	}
	public void reducirHambre(int cantidad) {
		this.hambre -= cantidad;
		if(this.hambre < 0) {
			this.hambre = 0;
		}
	}
	public void reducirSueño(int cantidad) {
		this.sueño -= cantidad;
		if(this.sueño < 0) {
			this.sueño = 0;
		}
	}
	

	public void aumentarSuciedad(int cantidad) {
		this.suciedad += cantidad;
		if(this.suciedad > 100) {
			this.suciedad = 100;
		}
	}
	public void aumentarSueño(int cantidad){
		this.sueño += cantidad;
		if(this.sueño > 100) {
			this.sueño = 100;
		}
	}
	public void aumentarHambre(int cantidad) {
		this.hambre += cantidad;
		if(this.hambre > 100) {
			this.hambre = 100;
		}
	}
	public void aumentarFelicidad(int cantidad) {
		this.felicidad += cantidad;
		if(this.felicidad > 100) {
			this.felicidad = 100;
		}
	}
	
	
	public void bañarMascota(Mascota mascota) {
		if(mascota.getTipo() == TipoMascota.FUEGO) {
			reducirSuciedad(50);
		} else if(mascota.getTipo() == TipoMascota.AIRE) {
			reducirSuciedad(70);
		} else if(mascota.getTipo() == TipoMascota.AGUA) {
			reducirSuciedad(90);
		}
		
		aumentarHambre(5);
		reducirFelicidad(7);
		System.out.println("¡Se ha bañado exitosamente!");
	}
	

	public void comer(Personaje personaje) {
		boolean comida = false;
		for(int i = 0; i < personaje.comidas.length; i ++) {
			if(personaje.comidas[i].getCantidad() > 0) {
				comida = true;
			}
		}
	
		if(comida == true) {
			System.out.println("¿Con qué vas a alimentarlo?");
			for(int j = 0; j < personaje.comidas.length; j++) {
				if(personaje.comidas[j].getCantidad() > 0) {
					System.out.println("\n" + (j + 1)+ ". " + personaje.comidas[j].getNombreComida());
				} 
			}
			int opc = Utiles.validarEnteroArray(1, 3);

			personaje.getComidas()[opc].reducirCantidad();
			
			if(personaje.comidas[opc].getTipo() == TipoComida.MANZANA) {
				reducirHambre(15);
			} else if(personaje.comidas[opc].getTipo() == TipoComida.FIDEOS) {
				reducirHambre(25);
			} else if(personaje.comidas[opc].getTipo() == TipoComida.SUSHI) {
				reducirHambre(40);
			}
			
			aumentarSueño(7);
			aumentarSuciedad(5);
			
			System.out.println("¡Ha comido exitosamente!");
		} else if(comida == false) {
			System.out.println("¡La cocina ya no tiene alimentos! Puedes comprarle alimentos en la tienda ;)");
		}
		
	}
	
	
	public void dormir(Personaje personaje) {
		reducirSueño(100);
		System.out.println("¡Ha dormido exitosamente!");
	}
	
	
	
}
