package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Cumple {
	private int cuantosCumple;
	private String tematica;
	private Invitado invitados [];
	
	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/****
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param cuantosCumple Esto es un valor num�rico que identifica los a�os que se celebran en el presente cumplea�os
	 * @param tematica Esto es una variable de tipo String que denota la tem�tica del cumplea�os. 
	 */
	public Cumple(int cuantosCumple, String tematica) {
		this.cuantosCumple = cuantosCumple;
		this.tematica = tematica;
		this.invitados = new Invitado [5];
		
	}
	
	public int cumpleActual() {
		return this.cuantosCumple;
	}
	/***
	 * Agrega un nuevo invitado a la lista de invitados del cumplea�os
	 * @param nuevo - El invitado a agregar
	 * @return Devuelve TRUE si se pudo agregar al nuevo invitado o false en caso contrario.
	 */
	public boolean agregarInvitado(Invitado nuevo) {
		boolean agregadoOk = false;
		for (int i = 0; i<invitados.length;i++) {
			if (invitados[i]==null          ) {
				invitados[i] = nuevo;
				agregadoOk = true;
				return agregadoOk;
			}
		}
		return agregadoOk;
	}

	/***
	 * Este m�todo busca un invitado en la lista de invitados a partir de su nombre.
	 * @param nombre Nombre del invitado a buscar.
	 * @return Devuelve INVITADO si encuentra al invitado o NULL en caso contrario.
	 */
	public Invitado buscar(String nombre) {
		Invitado buscado = null;
		for (int i= 0; i<invitados.length; i++) {
			if(invitados[i]!= null && invitados[i].getNombre().equals(nombre)) {
				buscado = invitados[i];
				return buscado;
				}
			}
			return null;
		}

	@Override
	public String toString() {
		return "[Cumple " + cuantosCumple + ", Tema " + tematica + " - Invitados: "
				+ Arrays.toString(invitados) + "]";
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el estado del objeto Cumple.
	 */
	
	
	
	
}
