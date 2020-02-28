import java.util.LinkedList;
import java.util.Queue;

public class IntegerStackThree {

  public static void main(String[] args) {

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 10; i >= 1; i--) {

      queue.add(i * 2);
    }

    for (int i = 10; i < 20; i++) {

      System.out.print(queue.remove() + ",");
    }
  }
}
