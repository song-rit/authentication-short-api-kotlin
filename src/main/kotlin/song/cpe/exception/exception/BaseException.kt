package song.cpe.exception.exception

import org.springframework.http.HttpStatus

open class BaseException(
    open val httpStatus: HttpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
    open val code: String,
    override val message: String
) : RuntimeException(message)