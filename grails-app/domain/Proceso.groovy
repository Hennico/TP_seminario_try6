package organizadordetareas

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