package br.com.mobguide.db.dao.impl;

import br.com.mobguide.db.dao.CrudDao;
import br.com.mobguide.model.entities.Game;
import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.model.enums.GameType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameFakeDaoImpl implements CrudDao<Game> {

    private List<Game> games = new ArrayList<>();

    public GameFakeDaoImpl(){

        Game fisrtGame = new Game();
        fisrtGame.setId(1);
        fisrtGame.setName("CS1.6");
        fisrtGame.setPrice(10);
        fisrtGame.setType(GameType.SHOOTER);

        Game secondGame = new Game();
        secondGame.setId(2);
        secondGame.setName("GTA");
        secondGame.setPrice(50);
        secondGame.setType(GameType.ACTION);

        Game thirdGame = new Game();
        thirdGame.setId(3);
        thirdGame.setName("Red Dead Redemption");
        thirdGame.setPrice(100);
        thirdGame.setType(GameType.GACHA);

        games.add(fisrtGame);
        games.add(secondGame);
        games.add(secondGame);
        games.add(secondGame);
        games.add(thirdGame);
        games.add(thirdGame);
        games.add(thirdGame);

    }

    @Override
    public int create(Game data) {
        games.add (data);
        return data.getId();
    }

    @Override
    public boolean deleteById(int id) {

        Game gameToBeRemoved = null;

        for (Game game_var : games){
            if(game_var.getId() == id){
                gameToBeRemoved = game_var;
                break;
            }
        }

        if
        (gameToBeRemoved != null){
            games.remove(gameToBeRemoved);
            return true;
        }

        return false;
    }

    @Override
    public Game readById(int id) {

//        Game game_var = null;

        if(games.isEmpty())
            return null;

        for (Game auxGame : games){
            if(auxGame.getId() == id)
                return auxGame;
        }

        return null;
    }

    @Override
    public List<Game> read() { return games; }

    @Override
    public boolean updateById(int id, Game data) {

        Game gameToBeUpdated = null;

        for (Game auxGame : games){
            if(auxGame.getId() == id) {
                gameToBeUpdated = auxGame;
                break;
            }
        }

        if(gameToBeUpdated != null){
            gameToBeUpdated.setPrice(data.getPrice());
            return true;
        }

        return false;
    }
}
