package com.github.gustavoflor.pocscheduler.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailPayload {
    private String subject;
    private String message;
    private String receiver;

    public static MailPayload mock() {
        return MailPayload.builder()
            .message("Lorem Ipsum...")
            .subject("Lorem Ipsum...")
            .receiver("lorem.ipsum@mail.co")
            .build();
    }
}
