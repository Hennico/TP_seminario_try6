package organizadordetareas

public class PasoProceso {
	Tarea tarea
	Estado estado
	PasoProceso pasoAnterior

	public PasoProceso(Tarea tarea, PasoProceso pasoAnterior) {
		this.tarea = tarea
		this.pasoAnterior = pasoAnterior
	}

  static constraints = {
  }
}
