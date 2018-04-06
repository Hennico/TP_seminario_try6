package organizadordetareas

public class PasoProceso {
	public Tarea tarea
	public Estado estado
	public PasoProceso pasoAnterior
	
	public PasoProceso(Tarea tarea, PasoProceso pasoAnterior) {
		this.tarea = tarea
		this.pasoAnterior = pasoAnterior
	}
}