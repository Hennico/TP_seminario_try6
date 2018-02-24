package OrganizadorDeMetas

public class Tarea {
	public String nombre
	public Stirng descripcion
	public Estado estado
	
	private List<CambioEstadoListener> listeners;
	
	public void CambiarEstado(Estado nuevoEstado) {
		listeners.each { it.ValidarCambio(this, nuevoEstado) }
		
		estado = nuevoEstado;
	}
}

public interface CambioEstadoListener {
	void ValidarCambio(Tarea source, Estado nuevoEstado)
}