import java.util.*;
import java.io*;

class Main {
   public static void main(String[] args) {
      LinkedList<String> k = new LinkedList<String>();
      k.add("1");
      k.add("8");
      k.add("6");
      k.add("4");
      k.add("5");
      System.out.println(k);
      k.subList(2, 4).clear();
      System.out.println(k);
   }
}
