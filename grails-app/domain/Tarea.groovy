package organizadordetareas

public class Tarea {
	String nombre
	String descripcion
	Estado estado
	
	private List<CambioEstadoListener> listeners;
	
	public Tarea() {
		listeners = []
		estado = Estado.NoIniciada
	}
	
	public void CambiarEstado(Estado nuevoEstado) {
		listeners.each { it.ValidarCambio(this, nuevoEstado) }
		
		estado = nuevoEstado;
	}
	
    static constraints = {
    }
}