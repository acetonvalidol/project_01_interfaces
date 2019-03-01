import Exceptions.WrongIlluminanceException;
import Exceptions.WrongSpaceException;

import Classes.Building;
import Classes.Bulb;
import Classes.Room;
import Classes.Table;
import Classes.Сhair;

public class Main {

    public static void main(String[] args) {
        Building building=new Building("Здание 1");
        try {
            building.addRoom("Комната 1",100,3);
            building.getRoom("Комната 1").add(new Bulb("Люстра", 200));
            building.getRoom("Комната 1").add(new Bulb("Люстра", 200));
            building.getRoom("Комната 1").add(new Table("Стол кухонный",30));
            building.getRoom("Комната 1").add(new Сhair("Табуретка",5));
            building.describe();

            building.addRoom("Комната 2",100,3);
            building.getRoom("Комната 2").add(new Bulb("Светильник", 200));
            building.getRoom("Комната 2").add(new Bulb("Люстра", 200));
            building.getRoom("Комната 2").add(new Table("Стол письменный",30));
            building.getRoom("Комната 2").add(new Сhair("Стул",5));
            building.describe();
        }
        catch(WrongSpaceException ex){
            System.out.println(ex.getMessage());
        }
        catch(WrongIlluminanceException ex){
            System.out.println(ex.getMessage());
        }
    }
}
