package org.example.editgames.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.editgames.domain.model.GameStatus;

@Getter
@Setter
@NoArgsConstructor
public class ChangeGameStatusRequest {

    private GameStatus gameStatus;
}
