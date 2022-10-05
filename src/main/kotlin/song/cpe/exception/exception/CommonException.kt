package song.cpe.exception.exception

import org.springframework.http.HttpStatus

open class CommonException(
    override val httpStatus: HttpStatus = HttpStatus.UNPROCESSABLE_ENTITY,
    override val code: String = "auth-001",
    override val message: String = "some thing wrong with solve"
) : BaseException(httpStatus, code, message)