import java.util.Stack;

public class IntegerStackTwo {

  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();

    for (int i = 10; i >= 1; i--) {

      stack.add(i * 2);
    }

    for (int i = 10; i < 20; i++) {

      System.out.print(stack.pop() + ",");
    }
  }
}
