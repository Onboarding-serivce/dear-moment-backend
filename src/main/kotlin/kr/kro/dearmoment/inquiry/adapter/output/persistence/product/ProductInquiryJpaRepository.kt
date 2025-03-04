package kr.kro.dearmoment.inquiry.adapter.output.persistence.product

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductInquiryJpaRepository : JpaRepository<ProductInquiryEntity, Long> {
    fun findByUserId(
        userId: Long,
        pageable: Pageable,
    ): Page<ProductInquiryEntity>
}
