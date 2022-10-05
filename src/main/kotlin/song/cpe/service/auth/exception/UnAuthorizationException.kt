package song.cpe.service.auth.exception

import org.springframework.http.HttpStatus
import song.cpe.exception.exception.BaseException

class UnAuthorizationException(
    httpStatus: HttpStatus = HttpStatus.UNAUTHORIZED,
    code: String = "aut-002",
    message: String = "Unauthorization"
) : BaseException(httpStatus, code, message) {
}