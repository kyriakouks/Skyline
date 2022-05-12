import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();

        try {
            File file = new File("src\\Input"); //remember to change to args[0]
            BufferedReader in = new BufferedReader(new FileReader(file));
            String next;
            int arrayLength = Integer.parseInt(in.readLine());
            while ((next = in.readLine()) != null){
                //String[] splited = next.split(" ");
                X.add(next);
                //Y.add(Integer.parseInt(splited[1]));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        Collections.sort(X);
        for (String i : X){
            System.out.println(i);
        }

    }
    

}
