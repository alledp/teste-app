package br.com.mobguide.service.impl;

import br.com.mobguide.model.entities.Game;
import br.com.mobguide.service.CrudService;

import java.util.List;

public class GameServiceImpl implements CrudService<Game> {

    @Override
    public int create(Game data) {
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public Game readById(int id) {
        return null;
    }

    @Override
    public List<Game> read() {
        return null;
    }

    @Override
    public boolean updateById(int id, Game data) {
        return false;
    }
}
