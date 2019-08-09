package randomdatacreator;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import descriptor.FileHeaderEnum;


public class RandomCycle{
	private static int uniqueCycleId = 1;
	List<String> randomCycleLine = new ArrayList<>(Collections.nCopies(11, ""));
	
	public RandomCycle() {
		
		getRandomCycleLine().set(FileHeaderEnum.level_id.ordinal(), "1");
		getRandomCycleLine().set(FileHeaderEnum.cycle_id.ordinal(), String.valueOf(uniqueCycleId));
		
		DateFormat ft = new SimpleDateFormat("yyyy.MM.dd (hh:mm:ss)");
		long randomCycle = generateRandomCycleDate();
		getRandomCycleLine().set(FileHeaderEnum.cycle_data.ordinal(), ft.format(randomCycle));
		getRandomCycleLine().set(FileHeaderEnum.cycle_timestamp.ordinal(), Long.toString(randomCycle));

		uniqueCycleId++;
		
	}
	
	private long generateRandomCycleDate() {
		
		Random rand = new Random();
	    Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		long cycleDate = (long) (timeStamp.getTime() - (rand.nextInt(1000000000) + 10000000));
		return cycleDate;
	}

	public List<String> getRandomCycleLine() {
		return randomCycleLine;
	}
	
}
