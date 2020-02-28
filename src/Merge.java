import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Merge {
  public static void main(String[] args) throws FileNotFoundException {
    File fileOne = new File(args[0]);
    File fileTwo = new File(args[1]);
    int i = 0;
    int j = 0;
    int lengthOne = 0;
    int lengthTwo = 0;
    try {
      Scanner kbs = new Scanner(fileOne);
      while (kbs.hasNextInt()) {
        kbs.nextInt();
        lengthOne++;
      }
      kbs.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    try {
      Scanner kbs2 = new Scanner(fileTwo);
      while (kbs2.hasNextInt()) {
        kbs2.nextInt();
        lengthTwo++;
      }
      kbs2.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int[] arrayOne = new int[lengthOne];
    int[] arrayTwo = new int[lengthTwo];
    try {
      Scanner kbs3 = new Scanner(fileOne);
      while (kbs3.hasNextInt()) {
        arrayOne[i] = kbs3.nextInt();
        i++;
      }
      kbs3.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    try {
      Scanner kbs4 = new Scanner(fileTwo);
      while (kbs4.hasNextInt()) {
        arrayTwo[j] = kbs4.nextInt();
        j++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int[] ascendingOrder = new int[lengthOne];
    Merge sortOne = new Merge();
    ascendingOrder = sortOne.sort(arrayOne);
    for (int m = 0; m < ascendingOrder.length - 1; m++) {
      System.out.println(ascendingOrder[m] + " ");
    }
    System.out.println(ascendingOrder[lengthOne - 1]);
    int[] descendingOrder = new int[lengthTwo];
    Merge sortTwo = new Merge();
    descendingOrder = sortTwo.sort(arrayTwo);
    for (int n = descendingOrder.length - 1; n > 0; n--) {
      System.out.println(descendingOrder[n] + " ");
    }
    System.out.println(descendingOrder[0]);
    int[] arrayThree = new int[lengthOne + lengthTwo];

    int a = descendingOrder.length - 1;
    int b = ascendingOrder.length - 1;

    for (int c = 0; c < arrayThree.length; c++) {
      if (a > -1 && b > -1) {
        if (descendingOrder[a] > ascendingOrder[b]) {
          arrayThree[c] = descendingOrder[a];
          a--;
        } else {
          arrayThree[c] = ascendingOrder[b];
          b--;
        }
      } else if (a <= -1) {
        while (a > -1) {
          arrayThree[c] = ascendingOrder[a];
          b--;
          c++;
        }
      }
      else {
        while (a > -1){
          arrayThree[c] = descendingOrder[a];
          a--;
          c++;
        }
      }
    }
    for (int r = 0; r < arrayThree.length - 1; r++){
      System.out.println(arrayThree[r] + " ");
    }
    System.out.println(arrayThree[arrayThree.length -1]);
  }

  private int[] sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int integerKey = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > integerKey) {
        array[j + 1] = array[j];
      }
      array[j + 1] = (integerKey);
    }
    return array;
  }
}
