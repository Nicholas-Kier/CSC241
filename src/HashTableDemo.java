import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableDemo {
  public static void main(String[] args) {
    Hashtable <String, Double> balance = new Hashtable <>();
    Enumeration <String> names;
    String str;
    double bal;

    balance.put("Zara", 3434.34);
    balance.put("Mahnaz", 123.22);
    balance.put("Ayan", 1378.00);
    balance.put("Daisy", 99.22);
    balance.put("Qadir", -19.08);

    names = balance.keys();

    while (names.hasMoreElements()) {
      str = names.nextElement();
      System.out.println(str + ": " + balance.get(str));
    }
    System.out.println();

    bal = balance.get("Zara");
    balance.put("Zara", bal + 1000);
    System.out.println("Zara's new balance: " + balance.get("Zara"));
  }
}
