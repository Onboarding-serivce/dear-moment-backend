package kr.kro.dearmoment.inquiry.adapter.input.web.service

import kr.kro.dearmoment.inquiry.adapter.input.web.dto.CreateInquiryResponse
import kr.kro.dearmoment.inquiry.adapter.input.web.service.dto.CreateServiceInquiryRequest
import kr.kro.dearmoment.inquiry.application.command.CreateServiceInquiryCommand
import kr.kro.dearmoment.inquiry.application.port.input.CreateInquiryUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/inquiries/services")
class ServiceInquiryRestAdapter(
    private val createInquiryUseCase: CreateInquiryUseCase,
) {
    @PostMapping
    fun writeServiceInquiry(
        @RequestBody request: CreateServiceInquiryRequest,
    ): CreateInquiryResponse {
        val command =
            CreateServiceInquiryCommand(
                userId = request.userId,
                type = request.type,
                content = request.content,
            )

        return createInquiryUseCase.createServiceInquiry(command)
    }
}
