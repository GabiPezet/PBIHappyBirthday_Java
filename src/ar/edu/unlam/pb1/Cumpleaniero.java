package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Cumpleaniero {

	private String nombreAgasajado;
	private Cumple cumpleanios [];
	
	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param nombre - Este es el nombre del cumplea�iero
	 */
	public Cumpleaniero(String nombre) {
		this.nombreAgasajado = nombre;
		this.cumpleanios = new Cumple[5];
	}
	
	/***
	 * Este m�todo agrega un nuevo cumplea�os a la lista de cumplea�os del cumplea�ero. 
	 * @param cuantosCumple Este par�metro identifica un�vocamente al cumplea�os y representa los a�os que cumple.
	 * @param tematica Este par�metro es un string de texto libre que identifica la tem�tica del cumplea�os.
	 * @return true si se  pudo agregar y false en caso contrario.
	 */
	public boolean nuevoCumple(int cuantosCumple, String tematica) {
		boolean nuevoCumpleConfirmado = false;
		for (int i = 0; i<cumpleanios.length; i++) {
			if (cumpleanios[i] == null) {
				cumpleanios[i] = new Cumple(cuantosCumple, tematica);
				nuevoCumpleConfirmado=true;
				return nuevoCumpleConfirmado;
				}			
			}
			return nuevoCumpleConfirmado;
		}
	
	/***
	 * Agrega un nuevo invitado a un cumplea�os determinado. Es importante recordar que primero se debe generar el c�digo de invitaci�n para asociarlo al nuevo invitado.
	 * @param aQueCumple - Determina a qu� cumplea�os se agrega el nuevo invitado
	 * @param nombre - Es el nombre del invitado
	 * @param esAdulto - Indica si el invitado es adulto o no
	 * @return Devuelve el c�digo de invitaci�n asociado al nuevo invitado. Si no se pudo agregar al invitado al cumplea�os se devuelve -1
	 */
	public int agregarInvitado(int aQueCumple, String nombre, boolean esAdulto) {
		int codigoInvitacion = 0;
		codigoInvitacion = calcularCodigoInvitacion();
		Invitado nuevoInvitado = new Invitado(nombre, esAdulto, codigoInvitacion);
		for (int i = 0; i<cumpleanios.length; i++) {
			if(cumpleanios[i]!=null && cumpleanios[i].cumpleActual() == aQueCumple && cumpleanios[i].buscar(nombre) == null ) {				
			cumpleanios[i].agregarInvitado(nuevoInvitado);
			return codigoInvitacion;									
				}
			}						
			return -1;
		}
	
	/***
	 * Este algoritmo debe generar un c�digo de invitaci�n aleatorio entre 1 y 1000. El c�digo se puede repetir entre un invitado y otro, pero no se puede anticipar el c�digo generado
	 * @return Devuelve el c�digo de invitaci�n generado.
	 */
	public int calcularCodigoInvitacion() {
		int codigoInvitacion = 0;
		codigoInvitacion = (int)((Math.random()*1000)+1);		
		return codigoInvitacion;
	}

	/***
	 * Este m�todo primero debe buscar al invitado en el cumplea�os al que desea confirmar su asistenica. Si lo encuentra, confirma su asistencia. 
	 * @param cumpleAlQueConfirma Cumplea�os al que un invitado confirma su asistencia.
	 * @param nombre Nombre del invitado que env�a la confirmaci�n
	 * @return Devuelve true para el caso que se haya confirmado la invitaci�n y false en caso contrario
	 */
	public boolean confirmar(int cumpleAlQueConfirma, String nombre) {
		boolean confirmarOk = false;		
		for(int i = 0; i<cumpleanios.length;i++) {
			if(cumpleanios[i]!=null && cumpleanios[i].cumpleActual() == cumpleAlQueConfirma && cumpleanios[i].buscar(nombre) != null) {
			
				cumpleanios[i].buscar(nombre).confirmar();									
				confirmarOk=cumpleanios[i].buscar(nombre).getConfirmo();
				
				return confirmarOk;
				}
			}
			return confirmarOk;
		}
	
	/****
	 * Este m�todo primero debe buscar al invitado en el cumplea�os al que desea asistir. Si lo encuentra, debe verificar que el invitado haya confirmado su asistencia y que el c�digo recibido coincida con el generado al momento de enviar la invitaci�n.
	 * @param cumpleAlQueAsiste - Cumplea�os al que el invitado est� asistiendo
	 * @param nombre - Nombre del invitado
	 * @param codigoAsistencia - C�digo de asistencia con el que el invitado desea ingresar al sal�n.
	 * @return Devuelve true si el invitado puede asistir o false para los siguientes casos:
	 * 	 * Si el invitado no existe en el cumplea�os
	 * 	 * Si el invitado no hab�a confirmado previamente su asistencia
	 *   * Si el c�digo de invitaci�n no concide con el generado inicialmente 
	 */
	public boolean asistir(int cumpleAlQueAsiste, String nombre, int codigoAsistencia) {
		boolean asiste = false;		
		for(int i = 0; i<cumpleanios.length;i++) {
			if(cumpleanios[i]!=null && cumpleanios[i].cumpleActual()== cumpleAlQueAsiste && cumpleanios[i].buscar(nombre) != null) {
				if (cumpleanios[i].buscar(nombre).asistir(codigoAsistencia) && cumpleanios[i].buscar(nombre).getConfirmo()) {
					asiste = true;
					return asiste;
					}
				}
			}
		return asiste;
	}
	
	/****
	 * Devuelve un objeto Cumple asociado al n�mero recibido por par�metro
	 * @param numero N�mero de cumplea�os que se debe retornar
	 * @return El cumplea�os recibido por par�metro
	 */
	public Cumple getCumpleanios(int numero) {
		Cumple buscado = null;
		for (int i=0; i<cumpleanios.length;i++) {
			if(cumpleanios[i]!= null) {
				buscado = cumpleanios[i];
				return buscado;
			}
		}
		return buscado;
	}

	@Override
	public String toString() {
		return "{CUMPLEANERO: " + nombreAgasajado + ", Cumple: " + Arrays.toString(cumpleanios)
				+ "}";
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el estado del objeto cumplea�ero.
	 */
	
}
