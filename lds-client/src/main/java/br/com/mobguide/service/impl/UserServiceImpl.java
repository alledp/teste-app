package br.com.mobguide.service.impl;

import br.com.mobguide.service.CrudService;

import java.util.List;

public class UserServiceImpl implements CrudService {

    @Override
    public int create(String data) {
        System.out.println("lalala");
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public String readById(int id) {
        return null;
    }

    @Override
    public List<String> read() {
        return null;
    }

    @Override
    public boolean updateById(int id, String data) {
        return false;
    }

}
