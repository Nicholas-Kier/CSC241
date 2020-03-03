import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) throws IOException {
    int n = 0;
    int[] dataArray;
    StringBuilder raw = new StringBuilder();
    Scanner kbs = new Scanner(new File(args[0]));

    while (kbs.hasNextInt()) {
      raw.append(kbs.nextInt()).append(" ");
      n++;
    }
    kbs.close();

    dataArray = new int[n];
    String[] splitter = raw.toString().split(" ");

    for (n -= 1; n > 0; --n) {
      dataArray[n] = Integer.parseInt(splitter[n]);
    }
    sort(dataArray);
    for (n = 0; n < dataArray.length; n++) {
      System.out.printf("%d\n", dataArray[n]);
    }
  }

  private static int[] sort(int[] array) {
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
  }
}
