package controller;


import model.Map.Map;
import model.Map.MapManager;
import model.Player;
import model.User;
import utils.Pair;
import view.MapSelectMenu;
import view.enums.messages.MapSelectMessage;

import java.util.ArrayList;

public class MapSelectController {
    private User currentUser;
    private Map selectedMap;
    private ArrayList<Player> players;
    private boolean isMapModifiable;
    public MapSelectController(User currentUser){
        this.currentUser = currentUser;
    }

    public void run(){
        MapSelectMenu mapSelectMenu = new MapSelectMenu(this);
        while(true){
            switch (mapSelectMenu.run()){

            }
        }
    }

    public String getMapsList(){
        ArrayList<Pair> maps = MapManager.getMapList();
        String output = "";
        for(Pair map : maps){
            output += "Map name : " + map.x + " Number of players : " + map.y;
            output += "\n";
        }
        return output;
    }

    public MapSelectMessage selectMap(String mapId){
        if(!MapManager.isMapIDValid(mapId)) return MapSelectMessage.INVALID_MAP_ID;
        selectedMap = MapManager.load(mapId);
        return MapSelectMessage.MAP_SELECT_SUCCESS;
    }

    public String numberOfPlayers(){
        if(selectedMap == null) return MapSelectMessage.MAP_NOT_SELECTED.getMessage();
        return String.valueOf(selectedMap.getPlayerCount());
    }

    public MapSelectMessage addPlayer(){
        return MapSelectMessage.PLAYER_ADD_SUCCESS;
    }
}
