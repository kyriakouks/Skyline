import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        String number = "";
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            number = in.readLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        Integer.parseInt(number);
        System.out.println(number);
    }
}
