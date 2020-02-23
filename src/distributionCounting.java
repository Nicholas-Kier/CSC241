import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class distributionCounting {

  private static void distributionSortingCode(int[] array, int size) {

    int[] output = new int[size + 1];

    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max) max = array[i];
    }

    int[] count = new int[max + 1];

    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }

    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    int number = Integer.parseInt(args[0]);
    File fileInput = new File(args[1]);
    int minimumValue = Integer.parseInt(args[2]);
    int maximumValue = Integer.parseInt(args[3]);

    Scanner kbs = new Scanner(fileInput);

    int[] numberArray = new int[number];

    for (int i = 0; i < number; i++) {
      numberArray[i] = kbs.nextInt();
    }

    distributionSortingCode(numberArray, number);

    for (int i = 0; i < number; i++) {
      System.out.println(numberArray[i]);
    }
    kbs.close();
  }
}
