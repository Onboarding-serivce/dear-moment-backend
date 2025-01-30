package kr.kro.dearmoment.image.application.port.output

import kr.kro.dearmoment.image.domain.Image
import org.springframework.web.multipart.MultipartFile

interface UploadImagePort {
    fun upload(
        file: MultipartFile,
        userId: Long,
    ): Image
}
