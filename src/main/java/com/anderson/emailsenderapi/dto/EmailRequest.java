package com.anderson.emailsenderapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequest(
        @NotBlank(message = "O destinatário é obrigatório") @Email(message = "Formato de e-mail inválido")
        String to,
        @NotBlank(message = "O assunto é obrigatório")
        String subject,
        @NotBlank(message = "O conteúdo é obrigatório")
        String body

) {
}