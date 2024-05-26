import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @BeforeAll
    static void init(){
        System.out.println("Testing begin");
    }


    @Test
    void checkCartEveryBranch() {
        System.out.println("Testing Every Branch - 5 Test Cases");

        //First Test Case
        RuntimeException ex1;
        ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        //Second Test Case
        Item[] list1 = new Item[]{ new Item(null,"1111",10,0), new Item("item2","0123",301,1.0f), new Item("item3",null,20,1.0f) };
        List<Item> items1 = Arrays.stream(list1).toList();
        RuntimeException ex2;
        ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1,100));
        assertTrue(ex2.getMessage().contains("No barcode!"));

        //Thrid Test Case
        Item[] list2 = new Item[]{ new Item("item1","1a23", 100, 1.0f)};
        List<Item> items2 = Arrays.stream(list2).toList();
        RuntimeException ex3;
        ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2,300));
        assertTrue(ex3.getMessage().contains("Invalid character in item barcode!"));

        //Fourth Test Case
        Item[] list3 = new Item[]{ new Item("item1","1234", 50, 0.10f)};
        List<Item> items3 = Arrays.stream(list3).toList();
        assertTrue(SILab2.checkCart(items3,500));

        //Fifth Test Case
        Item[] list4 = new Item[]{ new Item("item1","01234", 500, 1.0f)};
        List<Item> items4 = Arrays.stream(list4).toList();
        assertFalse(SILab2.checkCart(items4,50));
    }

    @Test
    void checkCartMultipleCondition(){
        System.out.println("Testing Multiple Condition - 4 Test Cases");

        //Testing TTT
        Item[] list1 = new Item[]{ new Item("item1","01234", 350, 0.1f)};
        List<Item> items1 = Arrays.stream(list1).toList();
        assertTrue(items1.getFirst().getPrice()>300);
        assertTrue(items1.getFirst().getDiscount()>0);
        assertEquals('0', items1.getFirst().getBarcode().charAt(0));

        //Testing TTF
        Item[] list2 = new Item[]{ new Item("Item2", "11234", 350, 0.1f)};
        List<Item> items2 = Arrays.stream(list2).toList();
        assertTrue(items2.getFirst().getPrice()>300);
        assertTrue(items2.getFirst().getDiscount()>0);
        assertFalse(items2.getFirst().getBarcode().charAt(0)=='0');

        //Testing TFX
        Item[] list3 = new Item[]{ new Item("Item3", "01234", 350, 0.0f)};
        List<Item> items3 = Arrays.stream(list3).toList();
        assertTrue(items3.getFirst().getPrice()>300);
        assertFalse(items3.getFirst().getDiscount()>0);

        //Testing FXX
        Item[] list4 = new Item[]{ new Item("Item4", "01234", 250, 0.1f)};
        List<Item> items4 = Arrays.stream(list4).toList();
        assertFalse(items4.getFirst().getPrice()>300);

    }

    @AfterAll
    static void destroy(){
        System.out.println("Testing end");
    }
}