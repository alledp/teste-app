package br.com.mobguide.service.impl;

import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.service.CrudService;

import java.util.List;

public class UserServiceImpl implements CrudService<UserModel> {

    @Override
    public int create(UserModel data) {
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public UserModel readById(int id) {

        UserModel user = new UserModel();
        user.setUsername("lalala-lelele");

        return user;
    }

    @Override
    public List<UserModel> read() {
        return null;
    }

    @Override
    public boolean updateById(int id, UserModel data) {
        return false;
    }
}
