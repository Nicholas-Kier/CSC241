import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class countingSort {
    public static void main(String[] args) {

        int nums = Integer.parseInt(args[0]);// args always begin as Strings > parse from string to type
        int [] array = new int[nums];
        int [] sorted = new int [array.length];
        int minValue = Integer.parseInt(args[2]);
        int maxValue = Integer.parseInt(args[3]);

        File file = new File(args[1]);
        try{
            Scanner input = new Scanner(file);
            for(int i = 0; i < array.length; i++){
                array[i] = input.nextInt();
            }
            input.close();
        } catch (FileNotFoundException a){
            a.printStackTrace();
        }

        countingSort mysort = new countingSort();

        sorted = mysort.sort(array, maxValue);

        for(int c = 0; c < sorted.length; c++){
            System.out.println(sorted[c]);
        }
    }

    public int[] sort(int[] array, int maxValue){
        int[] counted = new int[maxValue + 1];
        int sorted[] = new int[array.length];
        int sum = 0;
        for(int j = 0; j < counted.length; j++){
            counted[j] = 0;
        }

        for(int i = 0; i < array.length; i++){
            int freq = array[i];
            counted[freq]++;
        }

        for(int a = 0; a < counted.length; a++){
            sum += counted[a];
            counted[a] = sum;
        }

        for(int k = sorted.length - 1; k >= 0; k--){
            int value = array[k];
            int placeHolder = counted[value];
            sorted[placeHolder - 1] = array[k];
            counted[value] --;
        }
        return sorted;
    }
}
