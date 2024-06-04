package org.mock.persistence.entity.repository;

import java.util.ArrayList;
import java.util.List;

import org.mock.persistence.entity.Player;

public class PlayerRepositoryImpl implements IPlayerRepository{
    private List<Player> playerDataBase = new ArrayList<>(List.of(
        new Player(1L, "Lionel Messi", "Inter Miami", "Delantero"),
        new Player(2L, "Cristiano ronaldo", "All Nassr", "Delantero"),
        new Player(3L, "Neymar", "Paris Saint Germain", "Delantero"),
        new Player(4L, "Kylian Mbappe", "Paris Saint Germain", "Delantero"),
        new Player(5L, "Manuel neuer", "Bayern Munich", "Delantero"),
        new Player(6L, "Virgil Van Dijk", "Liverpool", "Defensa")      
    ));

    @Override
    public List<Player> findAll() {
        System.out.println("-> Metodo findAll real!");
        return this.playerDataBase;
    }

    @Override
    public Player findById(Long id) {
        System.out.println("-> Metodo findById real!");
        return this.playerDataBase.stream()
        .filter(player -> player.getId() == id)
        .findFirst()
        .orElseThrow();
    }

    @Override
    public void save(Player player) {
       System.out.println("-> Metodo save real!");
       this.playerDataBase.add(player);
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("-> Metodo deleteById real!");
        this.playerDataBase = this.playerDataBase.stream()
        .filter(player -> player.getId() != id)
        .toList();
    }
    
}
