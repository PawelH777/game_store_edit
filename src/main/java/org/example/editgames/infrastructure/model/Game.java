package org.example.editgames.infrastructure.model;

import lombok.*;
import org.example.editgames.domain.model.GameStatus;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String genre;

    @Enumerated(EnumType.STRING)
    @Column
    private GameStatus gameStatus;

}
