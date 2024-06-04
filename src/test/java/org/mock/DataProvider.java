package org.mock;

import java.util.List;

import org.mock.persistence.entity.Player;

public class DataProvider {
    public static List<Player> playersListMock() {
        System.out.println("-> Obteniendo playersListMock!");
        return List.of(
            new Player(1L, "Lionel Messi", "Inter Miami", "Delantero"),
            new Player(2L, "Cristiano ronaldo", "All Nassr", "Delantero"),
            new Player(3L, "Neymar", "Paris Saint Germain", "Delantero"),
            new Player(4L, "Kylian Mbappe", "Paris Saint Germain", "Delantero"),
            new Player(5L, "Manuel neuer", "Bayern Munich", "Delantero"),
            new Player(6L, "Virgil Van Dijk", "Liverpool", "Defensa")
        );
    }

    public static Player playerMock() {
        System.out.println("-> Obteniendo playerMock!");
        return playersListMock().get(0);
    }

    public static Player newPlayerMock() {
        System.out.println("-> Obteniendo newPlayerMock!");
        return new Player(10L, "Luiz Diaz", "Liverpool", "Delantero");
    }
}
