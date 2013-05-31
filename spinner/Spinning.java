package flaxspinner;

import org.hexbot.api.methods.Calculations;
import org.hexbot.api.methods.GameObjects;
import org.hexbot.api.methods.Inventory;
import org.hexbot.api.methods.Players;
import org.hexbot.api.util.Time;
import org.hexbot.api.wrapper.Area;
import org.hexbot.api.wrapper.GameObject;
import org.hexbot.api.wrapper.Item;
import org.hexbot.api.wrapper.Tile;

public class Spinning extends Node {

	public static int FLAX_ID = 1779;
	static Area SPINNER_AREA = new Area(new Tile[] { 
			new Tile(3212, 3209, 0) ,
			 new Tile(3212, 3213, 0) ,
			 new Tile(3212, 3217, 0) ,
			 new Tile(3205, 3217, 0) ,
			new Tile(3205, 3209, 0) });

	
	
	@Override
	public boolean activate() {
		
		Item flax = Inventory.getItem(FLAX_ID);
		return flax != null && SPINNER_AREA.contains(Players.getLocal());
	}

	@Override
	public void execute() {
		try{
		Tile doorTile = new Tile(3207, 3214);
		Tile wheelTile = new Tile(3209, 3212);
		GameObject door = GameObjects.getAt(doorTile);
		GameObject wheel = GameObjects.getAt(wheelTile);
		
		if(door != null){
			if(Calculations.distanceTo(wheel)>2){
				door.interact("Open");
				Time.sleep(1250, 1500);
			}
		}

	}catch(Exception e){
		e.printStackTrace();
		
	}
	}
}
