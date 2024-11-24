package dataaccess;

import model.AuthData;
import model.GameData;

import java.util.ArrayList;
import java.util.Objects;

public class MemoryGameDAO implements GameDAO{
    private ArrayList<GameData> games = null;

    public MemoryGameDAO(){
        this.games = new ArrayList<>();
    }

    @Override
    public ArrayList<GameData> getGames(AuthData user) throws DataAccessException {
        ArrayList<GameData> myGames = new ArrayList<>();
        for(GameData game:this.games){
            if(Objects.equals(game.blackUsername(), user.username()) || Objects.equals(game.whiteUsername(), user.username())){
                myGames.add(game);
            }
        }
        return myGames;
    }

    @Override
    public void deleteGame() throws DataAccessException {
        this.games = null;
    }

    @Override
    public void createGame(GameData game) throws DataAccessException {
        games.add(game);
    }

    public int getNumGames(){
        return games.size();
    }
}
