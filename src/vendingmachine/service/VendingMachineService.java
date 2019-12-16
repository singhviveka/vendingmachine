package vendingmachine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vendingmachine.model.Item;

public class VendingMachineService {
   int coin10,coin50,coin100,coin500;
   public  ArrayList<Item> items = new ArrayList<Item>();
     public VendingMachineService(){
    	 coin10 = 10;
    	 coin50 = 10;
    	 coin100 = 10;
    	 coin500 = 10;
    	 items.add(new Item("Canned coffee",120,5));
    	 items.add(new Item("Water PET bottle",100,5));
    	 items.add(new Item("Sport drinks",150,5));
     }
     public Map<String,Integer> purchage(int amount,int itemIndex){
    	 Map<String,Integer> m = new HashMap<String,Integer>();
    	 if(items.get(itemIndex).getQuantity()>0) {
    		 if(amount>=items.get(itemIndex).getPrice()) {
    			 if(isChangable(amount-items.get(itemIndex).getPrice())) {
    				 int hundredes = (amount-items.get(itemIndex).getPrice())/100;
    				 int tens = ((amount-items.get(itemIndex).getPrice())%100)/10;
    				 coin100 -= hundredes;
    				 coin10 -= tens;
    				 m.put("Hundredes", hundredes);
    				 m.put("Tens", tens);
    				 items.get(itemIndex).setQuantity(items.get(itemIndex).getQuantity()-1);
    			 }
    			 else
    				 throw new RuntimeException("Remaining amount are not changable..");
    		 }
    		 else
    			 throw new RuntimeException("Amout is less than item..");
    	 }
    	 else
    		 throw new RuntimeException("Items Out of stock..");
		return m;
     }
	private boolean isChangable(int num) {
		if(num%10>0)
			return false;
        int hundredes = num/100;
        int tens = num/10;
        if((coin100<hundredes && hundredes>0)|| (coin100 <4 && hundredes>0))
        	return false;
        if((coin10<tens && tens>0) || (coin10<9 && tens>0))
        	return false;
		return true;
	}
}
