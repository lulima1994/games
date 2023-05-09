package com.spring.untitled.services;

import com.spring.untitled.dto.GameMinDTO;
import com.spring.untitled.entities.Game;
import com.spring.untitled.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
