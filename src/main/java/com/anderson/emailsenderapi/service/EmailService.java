package com.anderson.emailsenderapi.service;

import com.anderson.emailsenderapi.dto.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final SesClient sesClient;

    @Value("${aws.ses.sender-email}")
    private String senderEmail;

    public void sendEmail(EmailRequest request) {

        SendEmailRequest sesRequest = SendEmailRequest.builder()
                .source(senderEmail)
                .destination(Destination.builder().toAddresses(request.to()).build())
                .message(Message.builder()
                        .subject(Content.builder().data(request.subject()).build())
                        .body(Body.builder()
                                .text(Content.builder().data(request.body()).build())
                                .build())
                        .build())
                .build();

        sesClient.sendEmail(sesRequest);
    }
}