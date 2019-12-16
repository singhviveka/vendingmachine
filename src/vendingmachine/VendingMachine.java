package vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import vendingmachine.service.VendingMachineService;

public class VendingMachine {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Commands:");
		int amount=0,num,arg = 0,itemIndex = 0;
		Map<String,Integer> changes = new HashMap<String, Integer>();
		VendingMachineService vendingService = new VendingMachineService();
		do {
		num = s.nextInt();
		if(num==1) 
			arg = s.nextInt();
			amount = arg;
		if(num==2) {
			arg = s.nextInt();
			itemIndex = arg-1;
			changes = vendingService.purchage(amount, itemIndex);
		}
		if(num==3)
			System.out.println(vendingService.items.get(itemIndex).getName()+" is successfully purchased");
		if(num==4)
			System.out.println("Take item..");
		if(num==5)
			System.out.println("Take changes:"+changes);
		}while(num!=5);
	}
}
