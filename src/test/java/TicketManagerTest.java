import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.netology.*;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TicketManagerTest {

    TicketRepository repo = Mockito.mock(TicketRepository.class);
    TicketManager manager = new TicketManager(repo);

    Ticket item1 = new Ticket(1, 1299, "SVO", "KZN", 250);
    Ticket item2 = new Ticket(2, 1877, "SVO", "KZN", 95);
    Ticket item3 = new Ticket(3, 4150, "VKO", "KZN", 410);
    Ticket item4 = new Ticket(4, 2190, "VKO", "KZN", 105);
    Ticket item5 = new Ticket(4, 3100, "DME", "KZN", 105);

    @Test
    public void shouldFind2ReversedOrder() {
        Ticket[] items = {item1, item2, item3, item4, item5};
        doReturn(items).when(repo).findAll();

        Ticket[] expected = {item4, item3};
        Ticket[] actual = manager.findAll("VKO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind2StrictOrder() {
        Ticket[] items = {item1, item2, item3, item4, item5};
        doReturn(items).when(repo).findAll();

        Ticket[] expected = {item1, item2};
        Ticket[] actual = manager.findAll("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFind1() {
        Ticket[] items = {item1, item2, item3, item4, item5};
        doReturn(items).when(repo).findAll();

        Ticket[] expected = {item5};
        Ticket[] actual = manager.findAll("DME", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind0() {
        Ticket[] items = {item1, item2, item3, item4, item5};
        doReturn(items).when(repo).findAll();

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("KZN", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }
}
