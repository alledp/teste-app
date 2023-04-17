package br.com.mobguide.service.impl;

import br.com.mobguide.model.entities.Game;
import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.model.enums.GameType;
import br.com.mobguide.model.enums.UserType;
import br.com.mobguide.service.CrudService;
import br.com.mobguide.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements CrudService<Game> {

    private static final String BASE_ENDPOINT = "http://localhost:8081/api/game";
    @Autowired
    private RestService<Game> restService;

    @Override
    public int create(Game data) {

        if(data == null){
            return -1;
        }

        if(data.getName().isEmpty()){
            return -1;
        }else if(data.getPrice() == 0.00){
            return -1;
        }else if(data.getType().equals(GameType.ACTION)
                || data.getType().equals(GameType.MMORPG)
                || data.getType().equals(GameType.GACHA)
                || data.getType().equals(GameType.SHOOTER)){

            // Aqui vai chamar o codigo paassando o data cccomo parametro para a nova entrada ser criada.

            int createId = restService.post(BASE_ENDPOINT + "/create", data);
            return createId;

        } else {
            return -1;
        }
    }

    @Override
    public boolean deleteById(int id) {

        return restService.delete(BASE_ENDPOINT + "/delete/" + id);
    }

    @Override
    public Game readById(int id) {

        Game game_var = restService.getById(BASE_ENDPOINT + "/find/" + id, Game.class);
        return game_var;
    }

    @Override
    public List<Game> read() {

            List<Game> games = restService.get(BASE_ENDPOINT + "/find");

            return games;
    }

    @Override
    public boolean updateById(int id, Game data) {

        Game game_var = readById(data.getId());
        game_var.setPrice(data.getPrice());
        game_var.setType(data.getType());

        return restService.put(BASE_ENDPOINT + "/update/" + id, game_var);
    }
}
