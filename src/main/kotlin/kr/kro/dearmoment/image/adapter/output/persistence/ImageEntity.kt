package kr.kro.dearmoment.image.adapter.output.persistence

import Auditable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import kr.kro.dearmoment.image.domain.Image

@Entity
@Table(name = "images")
class ImageEntity(
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column
    val userId: Long,
    @Column
    val fileName: String,
) : Auditable() {
    companion object {
        fun from(domain: Image) =
            ImageEntity(
                userId = domain.userId,
                fileName = domain.fileName,
            )

        fun toDomain(entity: ImageEntity): Image {
            return Image(
                imageId = entity.id,
                userId = entity.userId,
                fileName = entity.fileName,
            )
        }
    }
}
