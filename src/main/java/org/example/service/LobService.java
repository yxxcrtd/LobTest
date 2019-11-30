package org.example.service;

import org.example.domain.Lob;

import java.util.List;

public interface LobService {

    Lob findById(Long id);

    void save(Lob lob);

    List<Lob> findAll();

}
