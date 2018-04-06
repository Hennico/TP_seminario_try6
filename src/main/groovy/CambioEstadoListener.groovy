package organizadordetareas

public interface CambioEstadoListener {
	void ValidarCambio(Tarea source, Estado nuevoEstado)
}