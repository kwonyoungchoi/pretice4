package com.example.pretice4.dto;


import com.example.pretice4.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BoardDTO {

    private Integer id;
    private String subject;
    private String content;
    private LocalDateTime moddate;
}
