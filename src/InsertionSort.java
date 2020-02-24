import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {

  private static String[] insertionSortAlgo(String[] array) {
    for (int j = 0; j < array.length; j++) {
      String stringArray = array[j];
      int i = j - 1;
      while (i >= 0 && array[i].compareTo(stringArray) > 0) {
        array[i + 1] = array[i];
        i--;
      }
      array[i + 1] = stringArray;
    }
    return array;
  }

  public static void main(String[] args) throws FileNotFoundException {
    File fileInput = new File(args[1]);
    Scanner kbs = new Scanner(fileInput);
    int lengthOfString = Integer.parseInt(args[0]);
    String[] stringArray = new String[lengthOfString];

    for (int i = 0; i < lengthOfString; i++) {
      stringArray[i] = (kbs.nextLine());
    }

    insertionSortAlgo(stringArray);

    for (int i = 0; i < stringArray.length; i++) {
      System.out.println(stringArray[i]);
    }
    kbs.close();
  }
}
