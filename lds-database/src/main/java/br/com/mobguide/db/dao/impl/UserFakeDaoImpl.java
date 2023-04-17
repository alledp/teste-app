package br.com.mobguide.db.dao.impl;

import br.com.mobguide.db.dao.CrudDao;
import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.model.enums.UserType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserFakeDaoImpl implements CrudDao<UserModel> {

    private List<UserModel> users = new ArrayList<>();


    public UserFakeDaoImpl() {

        UserModel firstUser = new UserModel();
        firstUser.setId(1);
        firstUser.setUsername("Tiburssinho");
        firstUser.setFullName("Tibursinho Tibursius");
        firstUser.setEmail("tibursinho@gmail.com");
        firstUser.setActive(true);
        firstUser.setPassword("654321");
        firstUser.setType(UserType.ADMINISTRATOR);

        UserModel secondUser = new UserModel();
        secondUser.setId(2);
        secondUser.setUsername("Aroldo");
        secondUser.setFullName("Aroldo Aroldus");
        secondUser.setEmail("aroldinho@gmail.com");
        secondUser.setActive(true);
        secondUser.setPassword("654321");
        secondUser.setType(UserType.CLIENT);

        UserModel thirdUser = new UserModel();
        thirdUser.setId(3);
        thirdUser.setUsername("Cabral");
        thirdUser.setFullName("Cabral Cabrosius");
        thirdUser.setEmail("cabralinho@gmail.com");
        thirdUser.setActive(true);
        thirdUser.setPassword("976431");
        thirdUser.setType(UserType.CLIENT);

        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);
        users.add(thirdUser);
        users.add(thirdUser);
        users.add(thirdUser);
        users.add(thirdUser);
        users.add(thirdUser);
        users.add(thirdUser);
        users.add(thirdUser);


//        users = Arrays.asList(firstUser, secondUser, thirdUser);

    }

    @Override
    public int create(UserModel data) {
        users.add(data);
        return data.getId();

    }

    @Override
    public boolean deleteById(int id) {

        UserModel userToBeRemoved = null;

        for (UserModel user : users){
            if(user.getId() == id){
                userToBeRemoved = user;
                break;
            }
        }

        if
        (userToBeRemoved != null){
            users.remove(userToBeRemoved);
            return true;
        }

        return false;
    }

    @Override
    public UserModel readById(int id) {

//        UserModel user = null;

        if(users.isEmpty())
            return null;

        for (UserModel auxUser : users){
            if(auxUser.getId() == id)
                return auxUser;
        }

        return null;
    }

    @Override
    public List<UserModel> read() {
        return users;
    }

    @Override
    public boolean updateById(int id, UserModel data) {

        UserModel userToBeUpdated = null;

        for (UserModel auxUser : users){
            if(auxUser.getId() == id) {
                userToBeUpdated = auxUser;
                break;
            }
        }

        if(userToBeUpdated != null){
            userToBeUpdated.setFullName(data.getFullName());
            userToBeUpdated.setEmail(data.getEmail());
            return true;
        }

        return false;
    }
}
