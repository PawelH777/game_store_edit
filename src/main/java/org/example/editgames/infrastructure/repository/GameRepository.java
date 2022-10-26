package org.example.editgames.infrastructure.repository;

import org.example.editgames.infrastructure.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
