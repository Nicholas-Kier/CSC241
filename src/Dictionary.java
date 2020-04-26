import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
  public static void main(String[] args) {
    Scanner kbs = new Scanner(System.in);
    AVLTree tree = wordInput(args[0]);
    System.out.println(tree.heightOfTree(tree.root));

    while (true) {
      System.out.print("$ ");
      String response = kbs.nextLine();
      String[] wordsArray = response.split(" ");

      if (wordsArray[0].equals("EXIT")) {
        break;
      } else if (wordsArray[0].equalsIgnoreCase("SEARCH")) {
        //noinspection AccessStaticViaInstance
        Node nodeSearch = tree.treeSearch(tree.root, wordsArray[1]);

        if (nodeSearch == null) {
          System.out.println("WORD does not exist");
        } else {
          nodeSearch.nodePrint();
        }
      } else {
        System.out.println("Invalid command");
      }
    }
  }

  private static AVLTree wordInput(String fileInput) {
    AVLTree tree = new AVLTree();
    try {
      Scanner fileReader = new Scanner(new File(fileInput));
      String stringInput = fileReader.nextLine();

      while (!stringInput.equals(
          "*** START OF THIS PROJECT GUTENBERG EBOOK WEBSTER'S UNABRIDGED DICTIONARY ***")) {
        stringInput = fileReader.nextLine();
      }
      while (fileReader.hasNextLine()) {
        if (stringInput.equals(stringInput.toUpperCase())) {
          tree.root = tree.insert(tree.root, stringInput);
          Node node = AVLTree.treeSearch(tree.root, stringInput);

          stringInput = fileReader.nextLine();
          while (fileReader.hasNextLine()
              && (!stringInput.equals(stringInput.toUpperCase()) || stringInput.equals(""))) {
            assert node != null;
            node.addDefinition(stringInput);
            stringInput = fileReader.nextLine();
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return tree;
  }
}

class Node {
  final String key;
  int height;
  Node left;
  Node right;
  private final ArrayList<String> dictionaryDefinitions;

  Node(String string) {
    key = string;
    height = 1;
    dictionaryDefinitions = new ArrayList<>();
  }

  void nodePrint() {
    System.out.println();
    for (String definition : dictionaryDefinitions) {
      System.out.println(definition);
    }
  }

  void addDefinition(String definition) {
    dictionaryDefinitions.add(definition);
  }
}

class AVLTree {
  Node root;

  private static boolean alphabet(String A, String B) {
    int comparison = A.compareToIgnoreCase(B);

    if (comparison < 0) {
      return false;
    } else return comparison > 0;
  }

  static Node treeSearch(Node root, String target) {
    if (root == null) {
      return null;
    }
    if (target.equals(root.key)) {
      return root;
    } else if (alphabet(root.key, target)) {
      return treeSearch(root.left, target);
    } else if (!alphabet(root.key, target)) {
      return treeSearch(root.right, target);
    }
    return null;
  }

  private int max(int a, int b) {
    return Math.max(a, b);
  }

  int heightOfTree(Node n) {
    if (n == null) {
      return -1;
    } else {
      int left = heightOfTree(n.left);
      int right = heightOfTree(n.right);

      return (1 + (left > right ? left : right));
    }
  }

  private int height(Node n) {
    if (n == null) {
      return 0;
    }
    return n.height;
  }

  private int balanceCheck(Node n) {
    if (n == null) {
      return 0;
    }
    return height(n.left) - height(n.right);
  }

  private Node rotateRight(Node y) {
    Node x = y.left;
    Node T2 = x.right;
    x.right = y;
    y.left = T2;
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;
    return x;
  }

  private Node rotateLeft(Node x) {
    Node y = x.right;
    Node T2 = y.left;
    y.left = x;
    x.right = T2;
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;
    return y;
  }

  Node insert(Node n, String key) {
    if (n == null) {
      return (new Node(key));
    }
    if (!alphabet(key, n.key)) {
      n.left = insert(n.left, key);
    } else if (alphabet(key, n.key)) {
      n.right = insert(n.right, key);
    } else {
      return n;
    }
    n.height = 1 + max(height(n.left), height(n.right));

    int b = balanceCheck(n);

    if (b > 1 && !(alphabet(key, n.left.key))) {
      return rotateRight(n);
    }
    if (b > 1 && alphabet(key, n.left.key)) {
      n.left = rotateLeft(n.left);
      return rotateRight(n);
    }
    if (b < -1 && alphabet(key, n.right.key)) {
      return rotateLeft(n);
    }
    if (b < -1 && !(alphabet(key, n.right.key))) {
      n.right = rotateRight(n.right);
      return rotateLeft(n);
    }
    return n;
  }
}
