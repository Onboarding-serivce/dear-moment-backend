package kr.kro.dearmoment.like.adapter.output.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import kr.kro.dearmoment.common.persistence.Auditable
import kr.kro.dearmoment.like.domain.CreateStudioLike
import kr.kro.dearmoment.like.domain.Like
import kr.kro.dearmoment.like.domain.StudioLike
import kr.kro.dearmoment.studio.adapter.output.persistence.StudioEntity

@Entity
@Table(name = "studio_likes")
class StudioLikeEntity(
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column(nullable = false)
    val userId: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id")
    val studio: StudioEntity? = null,
) : Auditable() {
    fun toCreateDomain(): Like {
        check(studio != null) { "스튜디오는 널이 될 수 없습니다." }

        return CreateStudioLike(
            id = id,
            userId = userId,
            studioId = studio.id,
        )
    }

    fun toDomain(): StudioLike {
        val notNullStudio = requireNotNull(studio)
        return StudioLike(
            id = id,
            userId = userId,
            studio = notNullStudio.toDomain(),
        )
    }

    companion object {
        fun from(
            like: Like,
            studio: StudioEntity,
        ) = StudioLikeEntity(
            userId = like.userId,
            studio = studio,
        )
    }
}
