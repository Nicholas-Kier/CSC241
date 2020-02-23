import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class distributionCountingSort {
  private static void sort(int[] arr, int value) {
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
    System.out.println("Length of the array: " + arrayLength);
    System.out.println("Max value: " + max);
    System.out.println("Min value: " + min);
  }

  public static void main(String[] args) throws FileNotFoundException {
    int num = Integer.parseInt(args[0]);
    File file = new File(args[1]);
    int minimum = Integer.parseInt(args[2]);
    int maximum = Integer.parseInt(args[3]);

    Scanner kbs = new Scanner(file);

    int[] array = new int[num];

    for (int i = 0; i < num; i++) {
      array[i] = kbs.nextInt();
    }

    sort(array,num);
    int[] testArray = {10, 13, 9, 15, 7, 13};
    System.out.println("Elements before applying countingSort: " + Arrays.toString(testArray));
    sort(testArray);
    System.out.println("Elements after apply countingSort: " + Arrays.toString(testArray));
  }
}
