package organizadordetareas

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PasoProcesoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PasoProceso.list(params), model:[pasoProcesoCount: PasoProceso.count()]
    }

    def show(PasoProceso pasoProceso) {
        respond pasoProceso
    }

    def create() {
        respond new PasoProceso(params)
    }

    @Transactional
    def save(PasoProceso pasoProceso) {
        if (pasoProceso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pasoProceso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pasoProceso.errors, view:'create'
            return
        }

        pasoProceso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pasoProceso.label', default: 'PasoProceso'), pasoProceso.id])
                redirect pasoProceso
            }
            '*' { respond pasoProceso, [status: CREATED] }
        }
    }

    def edit(PasoProceso pasoProceso) {
        respond pasoProceso
    }

    @Transactional
    def update(PasoProceso pasoProceso) {
        if (pasoProceso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pasoProceso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pasoProceso.errors, view:'edit'
            return
        }

        pasoProceso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pasoProceso.label', default: 'PasoProceso'), pasoProceso.id])
                redirect pasoProceso
            }
            '*'{ respond pasoProceso, [status: OK] }
        }
    }

    @Transactional
    def delete(PasoProceso pasoProceso) {

        if (pasoProceso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pasoProceso.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pasoProceso.label', default: 'PasoProceso'), pasoProceso.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pasoProceso.label', default: 'PasoProceso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
