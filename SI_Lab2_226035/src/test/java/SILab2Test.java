import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

   private List<Item>productsList = new ArrayList<>(1);

   @Test
   void EveryBranchTest(){

       //Test cases:
       Item item1 = new Item("", "0213", 360, 4.5f);
       Item item2 = new Item("Nivea Kozmetika","0813",350,0);
       Item item3 = new Item("Cedevita","-1",78,5.3f);
       Item item4 =  new Item("Leb",null,35,3.4f);

       //1,3,4.1,4.2,5,6,7,8,9,10,11.1,11.2,12,13,11.3,15,16,21,22,4.3,23,25,26
       productsList.add(item1);
       boolean result = SILab2.checkCart(productsList,250);
       assertFalse(result);
       productsList.remove(item1);

       //1,2,26
       RuntimeException ex;
       ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(null,200));
       assertTrue(ex.getMessage().contains("allItems list can't be null!"));

       //1,3,4.1,4.2,5,6,8,9,10,11.1,11.2,12,13,11.3,15,17,21,4.3,23,24,26
       productsList.add(item2);
       result = SILab2.checkCart(productsList,530);
       assertTrue(result);
       productsList.remove(item2);

       //1,3,4.1,4.2,5,6,8,9,10,11.1,11.2,12,13,14,26
       productsList.add(item3);
       ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(productsList,300));
       assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
       productsList.remove(item3);

       //1,3,4.1,4.2,5,6,8,20,26
       productsList.add(item4);
       ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(productsList,130));
       assertTrue(ex.getMessage().contains("No barcode!"));
       productsList.remove(item4);
   }
   @Test
   void MultipleCondition(){
      // T && T && T
       Item item1 = new Item("", "0213", 360, 4.5f);
       productsList.add(item1);
       assertFalse(SILab2.checkCart(productsList, 250));
       assertEquals(1590,SILab2.finalSum); // so ovaa funkcija se proveruva dali ke ja dobieme ocekuvanata suma so iskoristeniot special discount
       productsList.remove(item1);

      // F && X && X
       item1 = new Item("Nivea Kozmetika","0813",300,0);
       productsList.add(item1);
       assertTrue(SILab2.checkCart(productsList, 530));
       assertEquals(300,SILab2.finalSum);// so ovaa funkcija se proveruva dali ke ja dobieme ocekuvanata suma bez iskoristeniot special discount
       productsList.remove(item1);

      // T && T && F
       item1 = new Item("product1","6532",320,4.3f);
       productsList.add(item1);
       assertFalse(SILab2.checkCart(productsList, 400));
       assertEquals(1376,SILab2.finalSum);// so ovaa funkcija se proveruva dali ke ja dobieme ocekuvanata suma bez iskoristeniot special discount
       productsList.remove(item1);

      // T && F && X
       item1 = new Item("product1","6782",376,0);
       productsList.add(item1);
       assertTrue(SILab2.checkCart(productsList, 400));
       assertEquals(376,SILab2.finalSum);// so ovaa funkcija se proveruva dali ke ja dobieme ocekuvanata suma bez iskoristeniot special discount
       productsList.remove(item1);
   }
}