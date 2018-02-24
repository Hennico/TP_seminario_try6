package OrganizadorDeMetas

public class Proceso {
	public String nombre
	public String descripcion
	public Estado estado
	
	public List<PasoProceso> pasos
	
	public void AgregarPaso(Tarea tarea) {
		PasoProceso paso = new PasoProceso(tarea, Iterables.getLast(pasos))
		pasos.add(paso)
	}
}

public class PasoProceso {
	public Tarea tarea
	public Estado estado
	public PasoProceso pasoAnterior
	
	public PasoProceso(Tarea tarea, PasoProceso pasoAnterior) {
		this.tarea = tarea
		this.pasoAnterior = pasoAnterior
	}
}