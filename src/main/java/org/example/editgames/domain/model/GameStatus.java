package org.example.editgames.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum GameStatus {
    PUBLISHED("published"),
    MODIFIED("modified"),
    UNPUBLISHED("unpublished");

    private final String status;

    GameStatus(final String status) {
        this.status = status;
    }

    @JsonCreator
    public static GameStatus fromText(final String text){
        for(final GameStatus r : GameStatus.values()){
            if(r.getStatus().equals(text)){
                return r;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return status;
    }

}
