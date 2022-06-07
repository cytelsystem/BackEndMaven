import java.io.*;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private int DNI;

    public Persona(String nombre, String apellido, int DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }
}