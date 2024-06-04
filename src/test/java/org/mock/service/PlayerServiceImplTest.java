package org.mock.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {
    @InjectMocks
    private PlayerServiceImpl playerServiceImpl;

    @Mock
    private PlayerRepositoryImpl playerRepositoryImpl;

    @Test
    public void testFindAll() {
        when(playerRepositoryImpl.findAll()).thenReturn(DataProvider.playersListMock());
        List<Player> players = playerServiceImpl.findAll();

        assertNotNull(playerRepositoryImpl);
        assertNotNull(players);
        assertFalse(players.isEmpty());
        assertEquals("Lionel Messi", players.get(0).getName());
        assertEquals("Inter Miami", players.get(0).getTeam());
        assertEquals("Delantero", players.get(0).getPosition());
        verify(this.playerRepositoryImpl).findAll();
    }

    @Test
    public void testFindById() {
        when(playerRepositoryImpl.findById(anyLong())).thenReturn(DataProvider.playerMock());
        Player player = playerServiceImpl.findById(1L);

        assertNotNull(player);
        assertEquals("Lionel Messi", player.getName());
        assertEquals("Inter Miami", player.getTeam());
        assertEquals("Delantero", player.getPosition());
        verify(this.playerRepositoryImpl, times(1)).findById(anyLong());
    }

    @Test
    public void testSave() {
        this.playerServiceImpl.save(DataProvider.newPlayerMock());
        
        ArgumentCaptor<Player> argumentCaptor= ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepositoryImpl).save(any(Player.class));
        verify(this.playerRepositoryImpl).save(argumentCaptor.capture());

        assertEquals(10L, argumentCaptor.getValue().getId());
        assertEquals("Luiz Diaz", argumentCaptor.getValue().getName());

    }

    @Test
    public void testDeleteById() {
        this.playerServiceImpl.deleteById(1L);

        ArgumentCaptor<Long> longArgumentCaptor= ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepositoryImpl).deleteById(anyLong());
        verify(this.playerRepositoryImpl).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue().longValue());
    }
}
