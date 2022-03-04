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
public class PushPayload {
    private String message;

    public static PushPayload mock() {
        return PushPayload.builder()
            .message("Lorem Ipsum...")
            .build();
    }
}
