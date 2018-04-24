package organizadordetareas

import org.grails.testing.GrailsUnitTest
import spock.lang.Specification

class TareaSpec extends Specification implements GrailsUnitTest {

    def setup() {
    }

    def cleanup() {
    }

    void "test "() {
		when: ""
        then:""
			true == true
    }

  def "cambaiar Cancelado a NoIniciada"() {
    given: "Teniendo una tarea en estado Cancelada"
      Tarea tarea = new Tarea()
      tarea.CambiarEstado(Estado.Cancelada)
    when: "se cambia a NoIniciada"
      tarea.CambiarEstado(Estado.NoIniciada)
    then: "tira una exepsion"
    		Exception e = thrown()
    }

  def "cambaiar cualquier estado a cancelar"() {
    given: "una tarea en cualquier estado"
      Tarea tarea = new Tarea()
    when: "se cambia a cancelar"
      tarea.CambiarEstado(Estado.Cancelada)
    then: "se actualizo el Estado"
      tarea.estado == Estado.Cancelada
  }

	void "test Tarea nueva tiene estado pendiente"() {
		when: "se crea una tarea"
			Tarea tarea = new Tarea()

        then:"la tarea esta en estado: NoIniciada"
			tarea.estado == Estado.NoIniciada
    }
}
