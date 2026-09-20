import java.util.*;
public class nochoice {
    public static void main(String args[]){
        //create
        HashMap<String, Integer> hm = new HashMap<>();
        //Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        System.out.println(hm);

        //size
        System.out.println(hm.size());//3

        //Is Empty
        System.out.println(hm.isEmpty());//false
        //Get - O(1)
        int population = hm.get("India");
        System.out.println(population);//100
        System.out.println(hm.get("Indonesia"));//null

        //containsKey - O(1)
        System.out.println(hm.containsKey("India"));//true
        System.out.println(hm.containsKey("Indonesia"));//false

        //remove - O(1)
        System.out.println(hm.remove("China"));//150
        System.out.println(hm);//{US=50, India=100}

        hm.clear();
        System.out.println(hm.isEmpty());//true


    }
}
