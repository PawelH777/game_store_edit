package org.example.editgames.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GameDO {

    private long id;

    private String name;

    private String genre;

    private GameStatus gameStatus;
}
