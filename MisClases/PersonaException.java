package MisClases;
import java.time.Year;
import java.util.Scanner;

public class PersonaException extends Exception{

    private String mensaje;

    public PersonaException(){

        this.mensaje = "Error";
    }

    public PersonaException(String introduceMen){

        this.mensaje = introduceMen;


    }
    public String getMessage(){
        return mensaje;


    }
}