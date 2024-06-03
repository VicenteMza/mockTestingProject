package org.mock.service;

import java.util.List;

import org.mock.persistence.entity.Player;

public interface IPlayerService {
    List<Player> findAll();
    Player findById(Long id);
    void save(Player player);
    void deleteById(Long id);
}
