package org.example.editgames.infrastructure.model;

import lombok.*;
import org.example.editgames.domain.model.GameStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String genre;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column
    private GameStatus gameStatus;

}
