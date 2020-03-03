import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) throws FileNotFoundException {
        File fileOne = new File(args[0]);
        File fileTwo = new File(args[1]);
        Scanner scanner = new Scanner(fileOne);


        int fileCountOne = 0;
        int[] fileInputOne = new int[500];
        while (scanner.hasNext()) {
            fileInputOne[fileCountOne] = scanner.nextInt();
            fileCountOne++;
        }
        int[] integerArrayOne = new int[fileCountOne];
        System.arraycopy(fileInputOne,
                0,
                integerArrayOne,
                0,
                fileCountOne);

        scanner = new Scanner(fileTwo);

        int fileCountTwo = 0;
        int[] fileInputTwo = new int[500];
        while (scanner.hasNext()) {
            fileInputTwo[fileCountTwo] = scanner.nextInt();
            fileCountTwo++;
        }

        int[] integerArrayTwo = new int[fileCountTwo];
        System.arraycopy(fileInputTwo,
                0,
                integerArrayTwo,
                0,
                fileCountTwo);

        int i;
        int j;
        int arrayLength = integerArrayOne.length;
        for (i = 1; i < arrayLength; i++) {
            int startingInt = integerArrayOne[i];
            j = i - 1;
            while (j >= 0 && integerArrayOne[j] > startingInt) {
                integerArrayOne[j + 1] = integerArrayOne[j];
                j--;
            }
            integerArrayOne[j + 1] = startingInt;
        }
        System.out.print(integerArrayOne[0]);
        for (i = 1; i < arrayLength; i++)
            System.out.print(" " + integerArrayOne[i]);
        System.out.print("\n");

        int arrayTwoLength = integerArrayTwo.length;
        for (i = 1; i < arrayTwoLength; i++) {
            int initial = integerArrayTwo[i];
            j = i - 1;
            while (j >= 0 && integerArrayTwo[j] < initial) {
                integerArrayTwo[j + 1] = integerArrayTwo[j];
                j--;
            }
            integerArrayTwo[j + 1] = initial;
        }
        System.out.print(integerArrayTwo[0]);
        for (i = 1; i < arrayTwoLength; i++) {
            System.out.print(" " + integerArrayTwo[i]);
        }
        System.out.print("\n");

        int[] integerArrayThree = new int[fileCountOne + fileCountTwo];
        i = arrayLength - 1;
        j = 0;
        int k = 0;

        while (i >= 0 && j < arrayTwoLength) if (integerArrayOne[i] > integerArrayTwo[j])
            integerArrayThree[k++] = integerArrayOne[i--];
        else
            integerArrayThree[k++] = integerArrayTwo[j++];

        while (i >= 0) integerArrayThree[k++] = integerArrayOne[i--];

        while (j < arrayTwoLength) {
            integerArrayThree[k++] = integerArrayTwo[j++];
        }

        System.out.print(integerArrayThree[0]);
        for (i = 1; i < k; i++)
            System.out.print(" " + integerArrayThree[i]);
        System.out.print("\n");
    }
}
