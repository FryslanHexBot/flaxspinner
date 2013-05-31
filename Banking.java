package flaxspinner;

import org.hexbot.api.methods.Bank;
import org.hexbot.api.methods.Inventory;
import org.hexbot.api.methods.Players;
import org.hexbot.api.wrapper.Area;
import org.hexbot.api.wrapper.Tile;

public class Banking extends Node {


			Area BankArea = new Area(new Tile[] { 
					new Tile(3210, 3223, 0) ,
					new Tile(3206, 3222, 0) ,
					new Tile(3206, 3215, 0) ,
					new Tile(3211, 3214, 0) });
	@Override
	public boolean activate() {
		return !Inventory.contains(Spinning.FLAX_ID) && BankArea.contains(Players.getLocal());
	}

	@Override
	public void execute() {
		if(Bank.isOpen()){
			if(Inventory.getCount() >0 && !Inventory.contains(Spinning.FLAX_ID)){
				Bank.depositAll();
			}else if(Inventory.getCount() == 0){
				Bank.withdraw(Spinning.FLAX_ID,28);
			}
			
		}else if(!Bank.isOpen()){
			Bank.open();
		}

	}

}
