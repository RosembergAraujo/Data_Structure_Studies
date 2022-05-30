import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("Some key", "Some value");
        hashTable.add("Some key", "Other value");
        System.out.println(hashTable.getValue("Some key"));
    }
}
