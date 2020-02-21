import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) throws FileNotFoundException {
    /*
    File input = new File(args[0]);
    Scanner kbs = new Scanner(input);
    int arrayLength = Integer.parseInt(args[0]);
    String[] data = new String[arrayLength];
    for (int i = 0; i < arrayLength; i++) data[i] = (kbs.nextLine());

      InsertionSort(data);

      for (String datum : data) {
          System.out.println(datum);
      }*/
    String[] unsorted = {"b","c","a","x","y","e","h","s","e","l"};
    String[] sorted = sort(unsorted);
    for( String s : sorted ) System.out.print(s+", ");

  }

  public static String[] sort(String[] array){
    for (int j = 0; j < array.length; j++){
      String key = array[j];
      int i = j -1 ;
      while (i >= 0 && array[i].compareTo(key) > 0){
        array[i +1] = array[i];
        i--;
      }
      array[i + 1] = key;
    }
    return array;
  }
}
