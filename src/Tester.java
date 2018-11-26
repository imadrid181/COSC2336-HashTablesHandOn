package hashTablesHandsOn;
import java.util.*;
public class Tester {
  public static void main(String[] args) {
    MyHashTable tester = new MyHashTable();
    tester.put(new Employee("Marcus Douglas", "md@gmail.com"));
    tester.print();
  }
}