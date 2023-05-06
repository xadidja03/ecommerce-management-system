package com.company.springproject.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    LocalDateTime localDateTime;
    String message;

}
