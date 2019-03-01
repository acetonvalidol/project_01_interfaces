package Classes;

import Interfaces.Furniture;
import Interfaces.Things;

public class Table implements Things,Furniture {
    private String name;
    private int maxSize;
    private int minSize;

    //конструктор, принимающий название объекта Table и занимаемую им площадь
    public Table(String name,int square){
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

    //метод, предаставляющий информацию о объекте класса Table
    public void describe(){
        System.out.print("     " + getName());
        System.out.println(" (площадь " + getMinSize() + " м^2)");
    }
}
