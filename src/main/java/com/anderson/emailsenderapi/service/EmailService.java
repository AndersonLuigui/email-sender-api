package com.anderson.emailsenderapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${aws.ses.sender-email}")
    private String senderEmail;
}
