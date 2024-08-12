package ar.edu.unlam.pb1;

public class Invitado {

	private String nombre;
	private boolean esAdulto;
	private int codigoInvitacion;
	private boolean asistencia;
	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param nombre Nombre del invitado
	 * @param esAdulto Si es adulto o no
	 * @param codigoInvitacion C�digo de invitaci�n que permitir� confirmar que el invitado es leg�timo a la hora de asistir al sal�n
	 */
	public Invitado(String nombre, boolean esAdulto, int codigoInvitacion) {
		this.nombre = nombre;
		this.esAdulto = esAdulto;
		this.codigoInvitacion = codigoInvitacion;
		this.asistencia = false;
	}

	/***
	 * Devuelve el nombre del invitado
	 * @return Nombre del invitado
	 */
	public String getNombre() {
		return this.nombre;
	}

	/***
	 * Actualiza el nombre del invitado
	 * @param nombre El nuevo nombre del invitado
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEsAdulto(boolean esAdulto) {
		this.esAdulto = esAdulto;
	}
	
	public int getCodigo() {
		return this.codigoInvitacion;
	}
	
	/****
	 * Devuelve si el invitado es un adulto
	 * @return True si es adulto o false en caso contrario
	 */
	public boolean esAdulto() {
		boolean confirmacionAdulto = false;
		if (this.esAdulto == true) {
			confirmacionAdulto = true;
			return confirmacionAdulto;
			}
			return confirmacionAdulto;
		}

	/***
	 * Actualiza el estado del invitado, confirmando su asistencia.
	 */
	public void confirmar() {
		this.asistencia = true;
	}
	
	/***
	 * Devuelve el estado de confirmaci�n del invitado
	 * @return true si confirmo su asistencia y false en caso contrario
	 */
	public boolean getConfirmo() {
		boolean confirmacion = false;
		if( this.asistencia == true) {
			confirmacion = this.asistencia;
			return confirmacion;
			} 
			return confirmacion;
		}
	
	/***
	 * Actualiza el estado de asistencia de un invitado
	 * @param codigoInvitacion al evento
	 * @return true si se pudo confirmar su asistencia o false en caso contrario (cuando el c�digo de asistencia no coincide con el definido inicialmente)
	 */
	public boolean asistir(int codigoInvitacion) {
		boolean asisteOk = false;
		if(this.codigoInvitacion == codigoInvitacion) {
			asisteOk = true;
			return asisteOk;
		}
		return asisteOk;
	}

	@Override
	public String toString() {
		return "(Nom. " + nombre + " Adulto " + esAdulto + ", ID:" + codigoInvitacion
				+ ", Asiste" + asistencia + ")";
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el estado del objeto Invitado.
	 */
	
}
