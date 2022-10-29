package org.example.editgames.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.editgames.domain.model.GameStatus;

import java.math.BigDecimal;

@Builder
public record GameMessage(@JsonProperty("id") long id,
                          @JsonProperty("name") String name,
                          @JsonProperty("genre") String genre,
                          @JsonProperty("price") BigDecimal price,
                          @JsonProperty("status") GameStatus status) {

}
