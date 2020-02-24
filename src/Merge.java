import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Merge {
  public static void main(String[] args) throws FileNotFoundException {
    int num = Integer.parseInt(args[0]);
    File fileInput = new File(args[1]);
    Scanner kbs = new Scanner(fileInput);

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

  private static void sort(int[] array, int num) {}
}
