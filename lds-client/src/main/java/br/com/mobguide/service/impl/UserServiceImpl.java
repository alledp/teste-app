package br.com.mobguide.service.impl;

import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.model.enums.UserType;
import br.com.mobguide.service.CrudService;
import br.com.mobguide.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements CrudService<UserModel> {


    @Autowired
    private RestService<UserModel> restService;

    @Override
    public int create(UserModel data) {

        if(data == null){
            return -1;
        }

        if(data.getUsername().isEmpty()
                || data.getPassword().isEmpty()
                || data.getFullName().isEmpty()
                || data.getEmail().isEmpty()) {
            return -1;
        }

        data.setType(UserType.CLIENT);
        data.setActive(true);

        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public UserModel readById(int id) {
        return null;
    }

    @Override
    public List<UserModel> read() {

        List<UserModel> users = restService.get("http://localhost:8081/api/user/find");

        return users;

    }

    @Override
    public boolean updateById(int id, UserModel data) {
        return false;
    }
}
