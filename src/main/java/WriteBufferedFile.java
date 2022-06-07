import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBufferedFile {

    public static void main(String[] args) throws FileNotFoundException {



        FileOutputStream fo = new FileOutputStream("OutputFile.txt");

        BufferedOutputStream bo = new BufferedOutputStream(fo);

        byte b = 65;

        try {
            bo.write(b);
            System.out.println("El byte fue escrito correctamente");
            bo.close();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }



}
