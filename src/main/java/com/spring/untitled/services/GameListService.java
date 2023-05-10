package com.spring.untitled.services;

import com.spring.untitled.dto.GameListDTO;
import com.spring.untitled.entities.GameList;
import com.spring.untitled.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }
}
