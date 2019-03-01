package Classes;

import Interfaces.Furniture;
import Interfaces.Things;

public class Сhair implements Things,Furniture {
    private String name;
    private int maxSize;
    private int minSize;

    //конструктор, принимающий название объекта Chair и занимаемую им площадь
    public Сhair(String name,int square){
        this.name=name;
        this.maxSize=square;
        this.minSize=square;
    }

    //геттер, возвращающий разложенное состояние
    public int getMaxSize(){
        return maxSize;
    }

    //геттер, возвращающий сложенное состояние
    public int getMinSize() {
        return minSize;
    }

    //геттер, возвращающий название
    public String getName(){
        return name;
    }

    //метод, предаставляющий информацию о объекте класса Chair
    public void describe(){
        System.out.print("     " + getName());
        System.out.println(" (площадь от " + getMinSize() + " м^2 до " + getMaxSize() + " м^2)");
    }
}
