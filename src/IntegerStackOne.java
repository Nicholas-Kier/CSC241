import java.util.Stack;

public class IntegerStackOne {
  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();

    for (int i = 10; i >= 1; i--) {

      stack.add(i * 2);
    }

    for (int i = 10; i < 20; i++) {

      if (i % 2 == 0) {

        System.out.print(stack.pop() + ",");
      }
    }
  }
}
