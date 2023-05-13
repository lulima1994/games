package com.spring.untitled.services;

import com.spring.untitled.dto.GameListDTO;
import com.spring.untitled.entities.GameList;
import com.spring.untitled.projections.GameMinProjection;
import com.spring.untitled.repositories.GameListRepository;
import com.spring.untitled.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> gamesList = gameRepository.searchByList(listId);
        GameMinProjection gameSource = gamesList.remove(sourceIndex);
        gamesList.add(destinationIndex, gameSource);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, gamesList.get(i).getId(), i);
        }
    }
}
