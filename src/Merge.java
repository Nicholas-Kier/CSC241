import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) throws FileNotFoundException {
        File fileOne = new File(args[0]);
        File fileTwo = new File(args[1]);
        Scanner kbs = new Scanner(fileOne);
        int[] fileInputOne = new int[500];


        int fileCountOne = 0;
        while (kbs.hasNext()) {
            fileInputOne[fileCountOne] = kbs.nextInt();
            fileCountOne++;
        }
        int[] integerArrayOne = new int[fileCountOne];
        System.arraycopy(fileInputOne, 0, integerArrayOne, 0, fileCountOne);

        kbs = new Scanner(fileTwo);

        int fileCountTwo = 0;
        int[] fileInputTwo = new int[500];
        while (kbs.hasNext()) {
            fileInputTwo[fileCountTwo] = kbs.nextInt();
            fileCountTwo++;
        }

        int[] integerArrayTwo = new int[fileCountTwo];
        System.arraycopy(fileInputTwo, 0, integerArrayTwo, 0, fileCountTwo);

        int i;
        int j;
        int n = integerArrayOne.length;
        for (i = 1; i < n; i++) {
            int startingInt = integerArrayOne[i];
            j = i - 1;
            while (j >= 0 && integerArrayOne[j] > startingInt) {
                integerArrayOne[j + 1] = integerArrayOne[j];
                j--;
            }
            integerArrayOne[j + 1] = startingInt;
        }


        int m = integerArrayTwo.length;
        for (i = 1; i < m; i++) {
            int initial = integerArrayTwo[i];
            j = i - 1;
            while (j >= 0 && integerArrayTwo[j] < initial) {
                integerArrayTwo[j + 1] = integerArrayTwo[j];
                j--;
            }
            integerArrayTwo[j + 1] = initial;
        }

        int[] integerArrayThree = new int[fileCountOne + fileCountTwo];
        i = n - 1;
        j = 0;
        int k = 0;

        while (i >= 0 && j < m) if (integerArrayOne[i] > integerArrayTwo[j])
            integerArrayThree[k++] = integerArrayOne[i--];
        else
            integerArrayThree[k++] = integerArrayTwo[j++];

        while (i >= 0) integerArrayThree[k++] = integerArrayOne[i--];

        while (j < m) {
            integerArrayThree[k++] = integerArrayTwo[j++];
        }

        System.out.print(integerArrayOne[0]);
        for (i = 1; i < n; i++)
            System.out.print(" " + integerArrayOne[i]);
        System.out.print("\n");
        System.out.print(integerArrayTwo[0]);
        for (i = 1; i < m; i++) {
            System.out.print(" " + integerArrayTwo[i]);
        }
        System.out.print("\n");

        System.out.print(integerArrayThree[0]);
        for (i = 1; i < k; i++)
            System.out.print(" " + integerArrayThree[i]);
    }
}
