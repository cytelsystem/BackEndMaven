import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Paseo {

    public static void main(String[] args) {

    Perro p1 = new Perro("firulais", "doberman", 3, "av quito");
    Perro p2 = new Perro("coco", "motas", 5, "av boyaca");
    Perro p3 = new Perro("fido", "ovejero", 8, "av 68");
    Perro p4 = new Perro("smith", "maltes", 4, "av nqs");

    ArrayList<Perro> lunes = new ArrayList<>();
    ArrayList<Perro> martes = new ArrayList<>();
    ArrayList<Perro> miercoles = new ArrayList<>();
    ArrayList<Perro> jueves = new ArrayList<>();
    ArrayList<Perro> viernes = new ArrayList<>();

    lunes.add(p1);
    miercoles.add(p1);
    viernes.add(p1);

    lunes.add(p2);
    martes.add(p2);
    miercoles.add(p2);
    jueves.add(p2);



    miercoles.add(p3);
    jueves.add(p3);
    viernes.add(p3);


    lunes.add(p4);
    martes.add(p4);
    miercoles.add(p4);
    jueves.add(p4);
    viernes.add(p4);

        try {
            FileOutputStream fil = new FileOutputStream("perros.dat");
            ObjectOutputStream archi = new ObjectOutputStream(fil);


            archi.writeObject(lunes);
            archi.writeObject(martes);
            archi.writeObject(miercoles);
            archi.writeObject(jueves);
            archi.writeObject(viernes);

            archi.close();

            FileInputStream filIn = new FileInputStream("perros.dat");
            ObjectInputStream archiIn = new ObjectInputStream(filIn);

            ArrayList<Perro> dia;

            for (int i =0; i< 5; i++) {



            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
