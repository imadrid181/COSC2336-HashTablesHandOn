package hashTablesHandsOn;
public class MyHashTable {
  private Employee[] table;
  private int initialCapacity;
  private float loadFactor;
  private int threshold;
  private static int size;
  
  public MyHashTable() {
    this.table = new Employee[11];
    this.initialCapacity = 11;
    this.loadFactor = 0.75f;
    this.size = 0;
    this.threshold = (int)(loadFactor * table.length);
  }
  
  public MyHashTable(int capacity, int loadFactor) {
    this.initialCapacity = capacity;
    this.loadFactor = (float)(loadFactor);
    this.size = 0;
    this.threshold = (int)(loadFactor * table.length);
    this.table = new Employee[initialCapacity];
  }
  
  private int hash(int id) {
    return id%table.length;
  }
  
  public Employee get(int id) {
    if(size > threshold)
      reHash();
    int index = hash(id);
    while(table[index] != null) {
      if(table[index].getId() == id) {
        size++;
        return table[index];
      }
      else
        index++;
    }
    return null;
  }
  
  public void put(Employee employee) {    
    int key = hash(employee.getId());
    int i = key;
    while(table[i] != null) {
      i++;
      i %= table.length;
      if(i == key) 
        return;
    }
    table[i] = employee;
  }
  
  private void reHash() {
    Employee[] oldTable = table;
    table = new Employee[2*oldTable.length];
    size = 0;
    threshold = (int)(loadFactor * table.length);
    for(int i = 0; i < oldTable.length; i++) 
      if(oldTable[i] != null)
      put(oldTable[i]);
  }
  
  public void print() { 
    for(int i = 0; i < size; i++) {
      if(table[i] != null)
        System.out.println("["+(hash(table[i].getId()) % table.length)+"] --> ["+ i +"]" + table[i]);
      else
        System.out.println("[" + i + "] --> " + table[i]);
    }
  }
}