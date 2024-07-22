package com.example.pretice4.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
@Table(name = "board_entity")
@SequenceGenerator(
        name = "board_entity_sql",
        sequenceName = "board_entity_sql",
        initialValue = 1,
        allocationSize = 1
)
public class BoardEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_entity_sql")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subject", nullable = false, length = 50)
    private String subject;

    @Column(name = "content", length = 100)
    private String content;
}
