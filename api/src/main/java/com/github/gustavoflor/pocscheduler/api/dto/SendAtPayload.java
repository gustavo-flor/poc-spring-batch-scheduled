package com.github.gustavoflor.pocscheduler.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class SendAtPayload {
    @NotNull
    private LocalDateTime sendAt;
}
