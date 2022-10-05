package song.cpe.exception.handler

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import song.cpe.controller.auth.model.auth.AuthResponse
import song.cpe.exception.exception.BaseException
import song.cpe.exception.exception.CommonException
import song.cpe.exception.model.ErrorResponse

@ControllerAdvice
class ExceptionHandler {

    companion object {
        private val logger = LoggerFactory.getLogger(ExceptionHandler::class.java)
    }

    @ExceptionHandler(CommonException::class)
    fun handleCommonException(ex: CommonException): ResponseEntity<ErrorResponse> {

        val errorResponse = ErrorResponse(
            code = ex.code,
            message = "Something wrong with solve"
        )
        logger.info("error_msg: {}", errorResponse)

        return ResponseEntity(errorResponse, ex.httpStatus)
    }

    @ExceptionHandler(value = [BaseException::class])
    fun handleBaseException(ex: BaseException): ResponseEntity<ErrorResponse> {

        val errorResponse = ErrorResponse(
            code = ex.code,
            message = ex.message
        )

        logger.info("error_msg: {}", errorResponse)

        return ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK)
    }
}