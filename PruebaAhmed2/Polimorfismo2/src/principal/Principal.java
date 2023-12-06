import java.util.Scanner;

import personajes.Koi;
import personajes.Mecca;
import personajes.Nimmo;
import personajes.Personaje;
import utiles.CaraSeca;
import utiles.Utiles;

public class Principal {
	static Personaje personaje; 
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Biemvenido al juego de Mascotas Virtuales");
		System.out.println("\nEmpezá por seleccionar tu mascota deseada");
		System.out.println("\n 1. Nimmo - Tipo fuego");
		System.out.println("\n 2. Mecca - Tipo aire");
		System.out.println("\n 3. Koi - Tipo agua");
		System.out.println("\nRespuesta:");
		int opc = Utiles.validarEntero(1, 3);
		crearMascota(opc);
		mostrarEstadisticas();
		mostrarMenu();
	}
	
	private static void crearMascota(int opc) {
		 switch(opc) {
		 case 1: 
			 personaje = new Personaje(new Nimmo());
			 break;
		 case 2: 
			 personaje = new Personaje(new Mecca());
			 break;
		 case 3: 
			 personaje = new Personaje(new Koi());
			 break;
		 }
		 
		 System.out.println("¡" + personaje.getMascota().getNombre() + " ya puede comenzar!");
	}

	private static void mostrarEstadisticas() {
		System.out.println("----------------");
		System.out.println("Estadísticas:");
		System.out.println("\n\n-Suciedad: " + personaje.getMascota().getSuciedad() + "/100");
		System.out.println("\n\n-Hambre: " + personaje.getMascota().getHambre() + "/100");
		System.out.println("\n\n-Sueño: " + personaje.getMascota().getSueño() + "/100");
		System.out.println("\n\n-Felicidad: " + personaje.getMascota().getFelicidad() + "/100");
		System.out.println("\n\n-Monedas: " + personaje.getMonedas());
	}

	private static void mostrarMenu() {
		int opc;
		do {
			System.out.println("\n------------ MENU DE JUEGO ------------");
			System.out.println("¿Cómo querés seguir?");
			System.out.println("\n 1. Bañar");
			System.out.println("\n 2. Alimentar");
			System.out.println("\n 3. Dormir");
			System.out.println("\n 4. Jugar");
			System.out.println("\n 5. Comprar");
			System.out.println("\n 6. Salir");
			System.out.println("\nRespuesta:");
			opc = Utiles.validarEntero(1, 6);
			actividades(opc);
			if (opc!=6) {
				mostrarEstadisticas();
			}
			else {
				System.out.println("¡Que tengas buen día!");
			}
		}while(opc!=6);
		
	}

	private static void actividades(int opc) {
		switch(opc) {
		case 1: 
			personaje.getMascota().bañarMascota(personaje.getMascota());
			break;
		case 2: 
			personaje.getMascota().comer(personaje);
			break;
		case 3: 
			personaje.getMascota().dormir(personaje);
			break;
		case 4:
			jugar(personaje);
			break;
		case 5: 
			comprar(personaje);
			break;
		}
		
	}
	
	private static void jugar (Personaje personaje2) {
		boolean fin = false;
		
		do {
			System.out.println("¡Jueguemos a Cara o Seca!");
			System.out.println("\n¡Elige!");
			System.out.println("(\n 1. Cara");
			System.out.println("\n 2. Seca");
			System.out.println("\n\nRespuesta: ");
			
			int opc = Utiles.validarEntero(1, 2);
			CaraSeca moneda = CaraSeca.tirarMoneda();
			
			if(moneda == CaraSeca.CARA && opc == 1) {
				System.out.println("¡Felicitaciones, salió Cara!");
				personaje.aumentarMonedas(3);
			} else if(moneda == CaraSeca.SECA && opc == 2) {
				System.out.println("¡Felicitaciones, salió Seca");
				personaje.aumentarMonedas(3);
			} else {
				System.out.println("¡Has perdido! Salió " + moneda + " ¡Suerte para la proxima!");
			}
			
			System.out.println("¿Jugar de nuevo?");
			System.out.println("\n 1. Si");
			System.out.println("\n 2. No");
			System.out.println("\nRespuesta: ");
			int res = Utiles.validarEntero(1, 2);
			if(res == 2) {
				fin = true;
			} else fin = false;
			
			personaje.getMascota().aumentarFelicidad(15);
			personaje.getMascota().aumentarSuciedad(5);
			personaje.getMascota().aumentarSueño(5);
			personaje.getMascota().aumentarHambre(7);
			
		}while(!fin);
	}

	private static void comprar(Personaje personaje) {
		boolean fin = false;
		
		do {
			if(personaje.getMonedas() > 0) {
				System.out.println("------------ TIENDA ------------");
				System.out.println("\n1. Manzana - 1 moneda");
				System.out.println("\n2. Fideos - 5 monedas");
				System.out.println("\n3. Sushi - 10 monedas");
				System.out.println("\nRespuesta: ");
				int opc = Utiles.validarEntero(1, 3);
				
				if(opc == 1) {
					personaje.reducirMonedas(1);
					personaje.getComidas()[0].aumentarCantidad();
				} else if(opc == 2) {
					personaje.reducirMonedas(5);
					personaje.getComidas()[1].aumentarCantidad();
				} else if(opc == 3) {
					personaje.reducirMonedas(10);
					personaje.getComidas()[2].aumentarCantidad();
				}
				
				System.out.println("Se ha realizado la compra con exito");
				fin = true;
			} else {
				System.out.println("No tienes suficiente dinero, pero puedes ganar monedas jugando");
				fin = true;
			}
			
		}while(!fin);
	}

}
