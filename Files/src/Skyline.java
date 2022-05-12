import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Skyline {


    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> A1 = new ArrayList<>();
        ArrayList<String> A2 = new ArrayList<>();


        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String next;
            int arrayLength = Integer.parseInt(in.readLine());
            while ((next = in.readLine()) != null){
                A.add(next);
            }

            if (arrayLength == 0 || arrayLength == 1){
                System.out.println(A);
                return;
            }
            int i;
            int j;
            for (i=0; i<arrayLength/2-1; i++){
                A1.add(A.get(i));
            }
            for (i=arrayLength/2-1; i<arrayLength; i++){
                A2.add(A.get(i));
            }

            String[] splitted1;
            String[] splitted2;
            for (i=0; i<A1.size(); i++){
                for (j=0; j<A1.size(); j++){
                    if (i == j){continue;}
                    splitted1 = A1.get(i).split(" ");
                    splitted2 = A1.get(j).split(" ");
                    if (Integer.parseInt(splitted2[0]) > Integer.parseInt(splitted1[0])){
                        Collections.swap(A1,i,j);
                    }else if (Integer.parseInt(splitted2[0]) == Integer.parseInt(splitted1[0])){
                        if (Integer.parseInt(splitted2[1]) > Integer.parseInt(splitted1[1])){
                            Collections.swap(A1,i,j);
                        }
                    }
                }
            }
            for (i=0; i<A2.size(); i++){
                for (j=0; j<A2.size(); j++){
                    if (i == j){continue;}
                    splitted1 = A2.get(i).split(" ");
                    splitted2 = A2.get(j).split(" ");
                    if (Integer.parseInt(splitted2[0]) > Integer.parseInt(splitted1[0])){
                        Collections.swap(A2,i,j);
                    }else if (Integer.parseInt(splitted2[0]) == Integer.parseInt(splitted1[0])){
                        if (Integer.parseInt(splitted2[1]) > Integer.parseInt(splitted1[1])){
                            Collections.swap(A2,i,j);
                        }
                    }
                }
            }
            A.removeAll(A);
            i=0;
            j=0;
            int count=-1;
            boolean flag;
            do {
                flag=false;
                splitted1 = A1.get(i).split(" ");
                splitted2 = A2.get(j).split(" ");
                if (Integer.parseInt(splitted1[0]) < Integer.parseInt(splitted2[0])) {
                    flag=true;
                    i++;
                }else if (Integer.parseInt(splitted1[0]) == Integer.parseInt(splitted2[0])){
                    if (Integer.parseInt(splitted1[1]) < Integer.parseInt(splitted2[1])){
                        flag=true;
                        i++;
                        j++;
                    }else if (Integer.parseInt(splitted1[1]) == Integer.parseInt(splitted2[1])){
                        flag=true;
                        i++;
                        j++;
                    }else {
                        j++;
                        i++;
                    }
                }else {
                    j++;
                }

                if (count == -1){
                    if (flag) {
                        A.add(A1.get(0));
                    }
                    else {
                        A.add(A2.get(0));
                    }
                    count++;
                    continue;
                }

                if (flag){
                    splitted2 = A.get(count).split(" ");
                    if (Integer.parseInt(splitted1[1]) < Integer.parseInt(splitted2[1])){ // x cannot be bigger and y must be smaller
                        A.add(A1.get(i-1));
                        count++;
                    }
                }else {
                    splitted1 = A.get(count).split(" ");
                    if (Integer.parseInt(splitted1[1]) > Integer.parseInt(splitted2[1])){
                        A.add(A2.get(j-1));
                        count++;
                    }
                }

                if (i == A1.size()){
                    while (j != A2.size()){
                        splitted1 = A.get(count).split(" ");
                        splitted2 = A2.get(j).split(" ");
                        if (Integer.parseInt(splitted1[1]) > Integer.parseInt(splitted2[1])){
                            A.add(A2.get(j-1));
                            count++;
                        }
                        j++;
                    }
                }else if (j == A2.size()){
                    while (i != A1.size()){
                        splitted1 = A1.get(i).split(" ");
                        splitted2 = A.get(count).split(" ");
                        if (Integer.parseInt(splitted1[1]) < Integer.parseInt(splitted2[1])){ // x cannot be bigger and y must be smaller
                            A.add(A1.get(i-1));
                            count++;
                        }
                        i++;
                    }
                }

                if ((i == A1.size()) && (j == A2.size())){
                    break;
                }

            }while (true);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        for (String i : A){
            System.out.println(i);
        }
    }
    

}
