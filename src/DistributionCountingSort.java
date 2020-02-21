import java.util.Arrays;

public class DistributionCountingSort {
  private static void sort(int[] arr) {
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
    System.out.println(arrayLength);
    System.out.println(max);
    System.out.println(min);
  }

  public static void main(String[] args) {
    //int maxVal = Integer.parseInt(args[0]);
    //int minVal = Integer.parseInt(args[1]);

    int[] testArray = {10, 13, 9, 15, 7, 13};
    System.out.println("Elements before applying countingSort: " + Arrays.toString(testArray));
    sort(testArray);
    System.out.println("Elements after apply countingSort: " + Arrays.toString(testArray));
  }
}
