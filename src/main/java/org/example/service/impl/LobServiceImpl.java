package org.example.service.impl;

import org.example.domain.Lob;
import org.example.repository.LobRepository;
import org.example.service.LobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class LobServiceImpl implements LobService {

    @Resource
    private LobRepository lobRepository;

    public Lob findById(Long id) {
        return lobRepository.getOne(id);
    }

    @Transactional
    public void save(Lob lob) {
        lobRepository.save(lob);
    }

    public List<Lob> findAll() {
        return lobRepository.findAll();
    }

}
