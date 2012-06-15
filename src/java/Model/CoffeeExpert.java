/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fauzan
 */
public class CoffeeExpert {
    
    public List getTypes(String type) {

     List types = new ArrayList();

     if (type.equals("milky")) {
       types.add("latte");
       types.add("cappuccino");
     }
     else if (type.equals("froffy")) {
       types.add("latte");
       types.add("cappuccino");
       types.add("frappuccino");
     }
     else if (type.equals("icey")) {
       types.add("frappuccino");
     }
     else if (type.equals("strong")) {
       types.add("espresso");
       types.add("double espresso");
     }
     else {
       types.add("Vending Machine");
     }
     return(types);
   }
}
