package Exceptions;

//Исключение превышения освещённости в 4000 и недостатка в 300
public class WrongIlluminanceException extends Exception {
    public WrongIlluminanceException(String message) {
        super(message);
    }
}
