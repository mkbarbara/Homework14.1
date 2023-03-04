package ru.netology;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[items.length + 1];
        for(int i = 0; i < items.length; i += 1) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[items.length - 1];
        int copyToIndex = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex += 1;
            }
        }
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }
}
