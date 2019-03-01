package Classes;

import Interfaces.Light;
import Interfaces.Things;

public class Bulb implements Things,Light {
    private String name;
    private int countLight;

    //конструктор, принимающий название объекта Bulb и свте излучаемй им
    public Bulb(String name,int countLight){
        this.name=name;
        this.countLight=countLight;
    }

    //геттер, возвращающий значение света
    public int getLight(){ return countLight; }

    //геттер, возвращающий название
    public String getName(){ return name; }

    //метод, предаставляющий информацию о объекте класса Bulb
    public void describe(){
    }
}
