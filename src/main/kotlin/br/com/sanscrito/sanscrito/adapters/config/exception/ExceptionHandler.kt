package br.com.sanscrito.sanscrito.adapters.config.exception

import br.com.sanscrito.sanscrito.adapters.config.exception.CustomException
import br.com.sanscrito.sanscrito.adapters.config.exception.ExceptionResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler  {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders,
                                              status: HttpStatus,
                                              request: WebRequest): ResponseEntity<Any> {
        val responses = ex.bindingResult.fieldErrors.map {
            ExceptionResponse(status.reasonPhrase, it.field.plus(it.defaultMessage))
        }
        return ResponseEntity(responses, status)
    }

    fun handleMissingServletRequestParameter(
        ex: MissingServletRequestParameterException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> =
        ResponseEntity(
            ExceptionResponse(status.reasonPhrase, "O parâmetro ${ex.parameterName} é obrigatório"),
            status
        )

    fun handleTypeMismatch(
        ex: TypeMismatchException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> =
        ResponseEntity(
            ExceptionResponse(
                status.reasonPhrase,
                "O parâmetro ${(ex as MethodArgumentTypeMismatchException).name} " +
                    "requer valores do tipo ${ex.requiredType}"
            ),
            status
        )

    @ExceptionHandler(Throwable::class)
    fun handleOtherExceptions(ex: Throwable): ResponseEntity<ExceptionResponse> {
        var statusCode = HttpStatus.INTERNAL_SERVER_ERROR
        var mensagem = "Ocorreu um erro interno, tente novamente mais tarde"

        when (ex) {
            is CustomException -> {
                statusCode = ex.statusCode ?: HttpStatus.INTERNAL_SERVER_ERROR
                mensagem = ex.message ?: mensagem
            }

            is WebClientResponseException ->
                logger.error("Retorno Exceção Body WebClient: ${ex.responseBodyAsString} ", ex)

            else -> logger.error("Exceção não esperada: ", ex)
        }

        ex.printStackTrace()

        return ResponseEntity.status(statusCode.value()).body(
            ExceptionResponse(statusCode.name, mensagem)
        )
    }
}
