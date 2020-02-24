import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DistributionCountingSort {
  private static void sort(int[] arr, int num) {
    int arrayLength = arr.length;
    if (arrayLength == 0) return;
    int max = arr[0], min = arr[0];
    for (int i = 1; i < arrayLength; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    int range = max - min + 1;

    int[] count = new int[range];
    for (int value : arr) count[value - min]++;
    for (int i = 1; i < range; i++) count[i] += count[i - 1];
    int j = 0;
    for (int i = 0; i < range; i++) while (j < count[i]) arr[j++] = i + min;
  }

  public static void main(String[] args) throws FileNotFoundException {
    int num = Integer.parseInt(args[0]);
    File fileInput = new File(args[1]);
    Scanner kbs = new Scanner(fileInput);
    int minimum = Integer.parseInt(args[2]);
    int maximum = Integer.parseInt(args[3]);

    int[] array = new int[num];

    for (int i = 0; i < num; i++) {
      array[i] = kbs.nextInt();
    }

    sort(array, num);

    for (int j = 0; j < num; j++) {
      System.out.println(array[j]);
    }
    kbs.close();
  }
}
