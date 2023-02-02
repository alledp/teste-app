package br.com.mobguide.service;

import java.util.List;

public interface CrudService {

    int create(String data);

    boolean deleteById(int id);

    String readById(int id);

    List<String> read();

    boolean updateById(int id, String data);

}
