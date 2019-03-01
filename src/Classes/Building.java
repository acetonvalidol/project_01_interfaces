package Classes;

import Exceptions.WrongIlluminanceException;

import java.util.List;
import java.util.ArrayList;

//класс, описывающий здание
public class Building {
    private String name;
    private List<Room> rooms;

    public Building(String name) {
        this.name = name;
        rooms = new ArrayList<Room>();
    }

    /**
     * Метод добавления комнаы
     * @param nameRoom - имя комнаты
     * @param square - площадь комнаты
     * @param countWindow - количество окон в команате
     */
    public void addRoom(String nameRoom, int square, int countWindow) throws WrongIlluminanceException{
        if (!((countWindow*700>4000)||(countWindow*700<300))) {
            rooms.add(new Room(nameRoom, square, countWindow));
        }
        else{
            throw new WrongIlluminanceException("В "+nameRoom+" освещенность находиться вне диапозона 400..4000\n " +
            "Перепроверьте количество окон (окон сейчас:" + countWindow+ ")");
        }

    }

    /**
     * Метод изьятия объекта комнаты по названию
     * @param nameRoom - имя комнаты
     */
    public Room getRoom(String nameRoom) {
        Room rm = new Room("", 0, 0);

        for (Room curr : rooms) {
            if (curr.getName().equals(nameRoom)) {
                return curr;
            }
        }
        if (rm.getName().equals(nameRoom)) {
            return rm;
        } else {
            return null;
        }
    }

    /* метод, предоставляющий информацию про объект класса Building*/
    public void describe() {
        System.out.println("Дом: "+name);
        for(Room room:rooms) {
            System.out.println(" " + room.getName());
            room.describe();

        }
    }
}
