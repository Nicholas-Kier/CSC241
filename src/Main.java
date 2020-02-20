import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numbers = Integer.parseInt(args[0]);
        int [] integerArray = new int[numbers];
        int [] sortedArray = new int[integerArray.length];
        int min = Integer.parseInt(args[2]);
        int max = Integer.parseInt(args[3]);

        File file = new File(args[1]);
            try{
                Scanner kbs = new Scanner(file);
                for(int i = 0; i < integerArray; i++){
                    integerArray[i] = kbs.nextInt();
                }
                    kbs.close();
            }catch(FileNotFoundException a){
                a.printStackTrace();
            }
            Main sort = new Main()

    }
}
