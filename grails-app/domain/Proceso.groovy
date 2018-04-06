package organizadordetareas

public class Proceso {
	String nombre
	String descripcion
	Estado estado
	
	public List<PasoProceso> pasos
	
	public void AgregarPaso(Tarea tarea) {
		PasoProceso paso = new PasoProceso(tarea, Iterables.getLast(pasos))
		pasos.add(paso)
	}
	
    static constraints = {
    }
}