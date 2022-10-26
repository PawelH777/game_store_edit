package org.example.editgames.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameDraftRequest {

    private String name;

    private String genre;
}
