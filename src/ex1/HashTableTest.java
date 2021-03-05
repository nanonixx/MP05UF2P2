package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void count() {
        HashTable ht = new HashTable();

        Assertions.assertEquals(0, ht.count());

    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable ht = new HashTable();

        Assertions.assertEquals(16, ht.size());
    }

    @ParameterizedTest
    @CsvSource({"1", "3", "10"})
    void put(int n) {
        HashTable ht = new HashTable();

        for (int i = 0; i < n; i++) {
            ht.put("key1", "value"+i);
            ht.put("key1", "value"+i);
        }


        String toString = "\n bucket["+ (n) +"] = ";
        for (int i = 0; i < n; i++) {
            toString = toString + "[key1, value" + i + "] -> [key1, value" + i + "]";
        }

        Assertions.assertEquals(toString, ht.toString());
    }

    @org.junit.jupiter.api.Test
    void get() {
        HashTable ht = new HashTable();

        ht.put("key1", "value1");
        ht.put("key1", "value2");

        Assertions.assertEquals("value1", ht.get("key1"));
    }

    @org.junit.jupiter.api.Test
    void drop() {
        HashTable ht = new HashTable();

        ht.put("key1", "value1");
        ht.drop("key1");

        Assertions.assertEquals(null, ht.get("key1"));

    }
}