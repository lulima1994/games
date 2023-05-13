package com.spring.untitled.dto;

import com.spring.untitled.entities.Game;
import com.spring.untitled.projections.GameMinProjection;

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer gameYear;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game game) {
        id = game.getId();
        title = game.getTitle();
        gameYear = game.getGameYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        gameYear = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getGameYear() {
        return gameYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
