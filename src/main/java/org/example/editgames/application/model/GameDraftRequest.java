package org.example.editgames.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class GameDraftRequest {

    private String name;

    private String genre;

    private BigDecimal price;
}
