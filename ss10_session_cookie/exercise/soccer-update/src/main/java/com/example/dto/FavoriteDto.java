package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class FavoriteDto {
    private Map<SoccerDto, Integer> soccerMap = new HashMap<>();

    public FavoriteDto() {
    }

    public Map<SoccerDto, Integer> getSoccerMap() {
        return soccerMap;
    }

    public void setSoccerMap(Map<SoccerDto, Integer> soccerMap) {
        this.soccerMap = soccerMap;
    }

    public void addFavoriteSoccer(SoccerDto soccerDto) {
        if (soccerMap.containsKey(soccerDto)) {
            Integer view = soccerMap.get(soccerDto);
            soccerMap.replace(soccerDto, view +1);
        } else {
            soccerMap.put(soccerDto,1);
        }
    }
}
