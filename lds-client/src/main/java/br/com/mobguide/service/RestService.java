package br.com.mobguide.service;

import java.util.List;

public interface RestService <T> {

    List<T> get(final String resource);

}
