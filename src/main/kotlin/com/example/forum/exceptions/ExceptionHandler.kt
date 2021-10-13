package com.example.forum.exceptions

import com.example.forum.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MinhaNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exception: MinhaNotFoundException, request: HttpServletRequest): ErrorDto {
        return ErrorDto(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )

        @ExceptionHandler(Exception::class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        fun genericException(exception: Exception, request: HttpServletRequest): ErrorDto {
            return ErrorDto(
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                error = HttpStatus.INTERNAL_SERVER_ERROR.name,
                message = exception.message,
                path = request.servletPath
            )
        }

        @ExceptionHandler(MethodArgumentNotValidException::class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        fun handlerValidationError(exception: MethodArgumentNotValidException, request: HttpServletRequest): ErrorDto {
            val erroMessage  = HashMap<String,String?>()
            exception.bindingResult.fieldErrors.forEach {
                e -> erroMessage.put(e.field,e.defaultMessage)
            }
            return ErrorDto(
                status = HttpStatus.BAD_REQUEST.value(),
                error = HttpStatus.BAD_REQUEST.name,
                message = erroMessage.toString(),
                path = request.servletPath
            )
        }
    }
}