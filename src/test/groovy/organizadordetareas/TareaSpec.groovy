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
	
	void "test Tarea nueva tiene estado pendiente"() {
		when: "se crea una tarea"
			Tarea tarea = new Tarea()
		
        then:"la tarea esta en estado: NoIniciada"
			tarea.estado == Estado.NoIniciada
    }
}