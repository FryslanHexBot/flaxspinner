package flaxspinner;

import org.hexbot.api.util.Random;
import org.hexbot.script.Manifest;
import org.hexbot.script.Script;

@Manifest(author = "Fryslan", name = "Flax Spinner", description = "Spins Flax In Lumbridge Castle v1.0", version = 0.1)
public class Spinner extends Script {

	private static final Node[] jobs = {new Banking(),new Walking(),new Spinning()};

	@Override
	public int loop() {
		try{
		for (Node job : jobs) {
			if (job.activate()) {
				job.execute();
				return Random.nextInt(50, 150);
			}
		}
		
		}catch(Exception e){
		e.printStackTrace();
		}
		return 50;
	}
	

	@Override
	public void onEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub

	}

}