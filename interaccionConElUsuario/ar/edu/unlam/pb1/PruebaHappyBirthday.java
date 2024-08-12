package ar.edu.unlam.pb1;

import java.util.Scanner;

public class PruebaHappyBirthday {
	
	private static Scanner teclado = new Scanner(System.in);
	private static final int CREAR_NUEVO_CUMPLE = 1, INVITAR = 2, CONFIRMAR = 3, ASISTIR = 4, SALIR = 9;
	
	public static void main(String args[]) {
		Cumpleaniero actual;
		String nombre;
		
		System.out.println("Ingrese el nombre del cumpleanieeero");
		nombre = teclado.next();
		actual = new Cumpleaniero(nombre);
		
		int opcion = 0;
		do {
			System.out.println(actual);
			mostrarMenu();
			opcion = teclado.nextInt();
			switch(opcion) {
			case CREAR_NUEVO_CUMPLE:
				crearNuevoCumple(actual);
				break;
			case INVITAR:
				invitar(actual);
				break;
			case CONFIRMAR:
				confirmar(actual);
				break;
			case ASISTIR:
				asistir(actual);
				break;
			default:
				System.out.println("Opcion invalida");
			}		
		} while(opcion!=SALIR);	
	}

	private static void mostrarMenu() {
		System.out.println("Opciones");
		System.out.println(CREAR_NUEVO_CUMPLE + ". Nuevo cumpleanos");
		System.out.println(INVITAR + ". Invitar nuevo amiguito");
		System.out.println(CONFIRMAR + ". Confirmar asistencia");
		System.out.println(ASISTIR + ". Asistir");
		System.out.println(SALIR + ". Salir");
		System.out.println("Ingrese la opcion deseada");
	}
	
	private static void crearNuevoCumple(Cumpleaniero actual) {
		int cuantosCumple;
		String tematica;
		
		System.out.println("Ingrese cuantos anos cumple");
		cuantosCumple = teclado.nextInt();
		System.out.println("Ingrese la tematica a utilizar");
		tematica = teclado.next();
		
		if(actual.nuevoCumple(cuantosCumple, tematica)) {
			System.out.println("Listo. Ahora solo queda divertirse");
		}
		else {
			System.out.println("Ocurrio un error. Ese cumpleanos ya fue celebrado");
		}
	}
	
	private static void invitar(Cumpleaniero actual) {
		String nombre = "";
		char respuestaEsAdulto = 'N';
		boolean esAdulto = false;
		int aQueCumple = 0;
		
		System.out.println("Ingrese al cumpleanos que desea invitarlo");
		aQueCumple = teclado.nextInt();
		System.out.println(actual.getCumpleanios(aQueCumple));
		
		System.out.println("Ingrese el nombre del nuevo invitado");
		nombre = teclado.next();
		System.out.println("El invitado es adulto");
		respuestaEsAdulto = teclado.next().toUpperCase().charAt(0);
		if(respuestaEsAdulto=='N') {
			esAdulto = false;
		}
		else {
			esAdulto = true;
		}
		
		int codigoDeInvitacion = actual.agregarInvitado(aQueCumple, nombre, esAdulto);
		System.out.println("El codigo de invitacion es " + codigoDeInvitacion);
	}
	
	private static void confirmar(Cumpleaniero actual) {
		String nombre;
		int cumpleAlQueConfirma;
		
		System.out.println("Ingrese a que cumpleanos desea confirmar asistencia");
		cumpleAlQueConfirma = teclado.nextInt();
		System.out.println(actual.getCumpleanios(cumpleAlQueConfirma));
		
		System.out.println("Ingrese el nombre del invitado");
		nombre = teclado.next();
		
		if(actual.confirmar(cumpleAlQueConfirma, nombre)) {
			System.out.println("Confirmacion exitosa");
		}
		else {
			System.out.println("No se pudo completar la confirmacion. Esta invitado?");
		}
	}
	
	private static void asistir(Cumpleaniero actual) {
		int cumpleAlQueAsiste;
		String nombreDelAsistente;
		int codigoDeInvitacion;
		
		System.out.println("Ingrese el cumpleanos al que desea asistir");
		cumpleAlQueAsiste = teclado.nextInt();
		System.out.println(actual.getCumpleanios(cumpleAlQueAsiste));
		
		System.out.println("Ingrese el nombre del invitado");
		nombreDelAsistente = teclado.next();
		System.out.println("Ingrese el codigo de invitacion");
		codigoDeInvitacion = teclado.nextInt();
		
		if(actual.asistir(cumpleAlQueAsiste, nombreDelAsistente, codigoDeInvitacion)) {
			System.out.println("Bienvenido. Puede pasar");
		}
		else {
			System.out.println("No puede ingresar. O bien no fue invitado o el codigo de invitacion es invalido");
		}
	}
}
