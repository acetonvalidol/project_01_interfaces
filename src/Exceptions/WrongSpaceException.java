package Exceptions;

//Исключение превышения площади предметом 70% площади комнаты
public class WrongSpaceException extends Exception {
    public WrongSpaceException(String message){ super(message); }
}
