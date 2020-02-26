import java.util.Hashtable;

public class HashTableDemoTwo {
  public static void main(String[] args) {
    Hashtable<Integer, String> h = new Hashtable<Integer, String>();

      h.put(3, "Geeks");
    h.put(2, "forGeeks");
    h.put(1, "isBest");

      Hashtable <Integer, String> h1;
      h1 = (Hashtable <Integer, String>) h.clone();
      System.out.println("values in clone: " + h1);
    h.clear();
    System.out.println("after clearing: " + h);
  }
}
