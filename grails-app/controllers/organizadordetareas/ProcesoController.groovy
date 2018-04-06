package organizadordetareas

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProcesoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Proceso.list(params), model:[procesoCount: Proceso.count()]
    }

    def show(Proceso proceso) {
        respond proceso
    }

    def create() {
        respond new Proceso(params)
    }

    @Transactional
    def save(Proceso proceso) {
        if (proceso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (proceso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond proceso.errors, view:'create'
            return
        }

        proceso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'proceso.label', default: 'Proceso'), proceso.id])
                redirect proceso
            }
            '*' { respond proceso, [status: CREATED] }
        }
    }

    def edit(Proceso proceso) {
        respond proceso
    }

    @Transactional
    def update(Proceso proceso) {
        if (proceso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (proceso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond proceso.errors, view:'edit'
            return
        }

        proceso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'proceso.label', default: 'Proceso'), proceso.id])
                redirect proceso
            }
            '*'{ respond proceso, [status: OK] }
        }
    }

    @Transactional
    def delete(Proceso proceso) {

        if (proceso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        proceso.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'proceso.label', default: 'Proceso'), proceso.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'proceso.label', default: 'Proceso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
