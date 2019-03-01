package Classes;

import Exceptions.WrongIlluminanceException;
import Exceptions.WrongSpaceException;
import Interfaces.Furniture;
import Interfaces.Light;
import Interfaces.Things;

import java.util.List;
import java.util.ArrayList;

//класс, описывающий комнату
public class Room {
    private String name;
    private int square;
    private int summMinSquare;
    private int summMaxSquare;
    private int summLight;
    private int minLight;
    private int maxLight;
    private int countWindow;
    private ArrayList<Furniture> furniture;
    private List<Light> bulbs;


    public Room(String name, int square, int countWindow) {
        this.name = name;
        this.square = square;
        summMinSquare = 0;
        summMaxSquare=0;
        this.countWindow = countWindow;
        minLight = 300;
        maxLight = 4000;
        summLight = countWindow * 700;
        furniture = new ArrayList<Furniture>();
        bulbs=new ArrayList<Light>();
    }



    //метод, добавляющий мебель и лампочки в комнату
    public void add(Things added) throws WrongSpaceException,WrongIlluminanceException {
        if(added instanceof Furniture) {
            if (((square * 0.7) >= (summMinSquare + ((Furniture)added).getMinSize())) && ((square * 0.7) >= (summMaxSquare + ((Furniture)added).getMaxSize()))) {
                furniture.add((Furniture)added);
                summMinSquare += ((Furniture)added).getMinSize();
                summMaxSquare += ((Furniture)added).getMaxSize();
            }
            else {
                throw new WrongSpaceException("Площадь " + this.name + " будет занята более чем 70%, если добавить " + added.getName()+"(square="+((Furniture) added).getMinSize()+")");
            }
        }
        else if(added instanceof Light){
            if((summLight+((Light)added).getLight()>=minLight)&&(summLight+((Light)added).getLight()<=maxLight)){
                bulbs.add(((Light)added));
                summLight+=((Light)added).getLight();
            }
            else{
                throw new WrongIlluminanceException("Освещенность "+this.name+" будет находиться вне границ 300..4000, " +
                        "если добавить лампочку со значением countLight="+((Light)added).getLight()+
                        "\n(summLight="+summLight+")");
            }
        }
    }


    //метод, предоставляющий информацию о комнате
    public void describe() {
        System.out.print("    Освещенность=" + getSummLight() + " ( " + getCountWindow() + " окна по 700лк");

        if (bulbs.size() != 0) {
            System.out.print("\n" + "      лампочки ");
        }

        for (Light added : bulbs) {
            System.out.print(added.getLight() + " ");
        }
        System.out.println(")");
        System.out.print("    Площадь=" + getSquare());
        if (getSummMaxSquare() != 0) {
            System.out.print("  м^2( занято ");
            if (getSummMaxSquare() == getSummMinSquare()) {
                System.out.print(getSummMaxSquare());
            } else {
                System.out.println(getSummMinSquare() + "-" + getSummMaxSquare() + "м^2, гарантировано свободно " +
                        (getSquare() - getSummMaxSquare()) + "м^2 или " + (100 * getSummMaxSquare() / getSquare())
                        + "% площади)");
            }
        } else {
            System.out.println(" (свободно 100%)");
        }

        if (furniture.size() != 0) {
            System.out.println("    Мебель:");
            for (Furniture added : furniture) {

            }
        }
        else {
            System.out.println("    Мебели нет");
        }
    }

    //геттер, возвращающий значение св-ва name
    public String getName() {
        return name;
    }
    private int getSquare (){
        return square;
    }
    private int getCountWindow(){
        return countWindow;
    }
    private int getSummLight(){
        return summLight;
    }
    private int getSummMaxSquare(){
        return summMaxSquare;
    }
    private int getSummMinSquare(){
        return summMinSquare;
    }
}
