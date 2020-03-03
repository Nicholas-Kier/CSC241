import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        int n = 0;
        int[] dataArray;
        StringBuilder raw = new StringBuilder();
        Scanner kbs = new Scanner(file);

        while (kbs.hasNextInt()) {
            raw.append(kbs.nextInt()).append(" ");
            n++;
        }
        kbs.close();

        dataArray = new int[n];
        String[] splitter = raw.toString().split(" ");

        for (int i = 0; i < n; i++) {
            dataArray[i] = Integer.parseInt(splitter[i]);
        }
        selectionSort(dataArray);
        for (n = 0; n < dataArray.length; n++) System.out.printf("%d\n", dataArray[n]);
    }

    /* private static int[] sort(int[] array) {
       int index;
       int temporary;

       for (int i = 0; i < array.length - 1; i++) {
         index = i;
         for (int j = i; j < array.length; j++) {
           if (array[j] < array[index]) index = j;
         }
         temporary = array[index];
         array[index] = array[i];
         array[i] = temporary;
       }
       return array;
     }*/
    private static int[] selectionSort(int[] array) {
        int index = array.length;
        for (int i = 0; i < index - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < index; j++) {
                if (array[j] < array[minimum])
                    minimum = j;
            }
            int temporary = array[minimum];
            array[minimum] = array[i];
            array[i] = temporary;
        }
        return array;
    }
}
