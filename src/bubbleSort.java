import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class bubbleSort {
    public static void main(String[] args){ // needs to throw IOException when reading a file
        File file = new File(args[0]);
        int i = 0;
        int k = 0;
        int length = 0;
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextInt()) {
                input.nextInt();
                length++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] array = new int[length];


        try {
            Scanner input2 = new Scanner(file);
            while (input2.hasNextInt()) {
                array[i] = input2.nextInt();
                i++;

            }
            input2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//This is a comment for git.
        bubbleSort bsort = new bubbleSort();
        bsort.BubbleSort(array);
        System.out.print(array[0]);
        for(int p = 1; p < array.length; p++){
            System.out.print(" " + array[p]);
        }
    }

    public static void BubbleSort(int[] array){
        int BOUND = array.length - 1;
        int t = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j <= BOUND - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    t = j;
                }
            }
            if(t == 0){
                break;
            } else
                BOUND = t;
        }
        //  System.out.println(Arrays.toString(array));
    }


}
