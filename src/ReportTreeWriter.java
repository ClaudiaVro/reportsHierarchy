import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import randomdatacreator.RandomCycle;
import randomdatacreator.RandomHeaderData;
import randomdatacreator.RandomReport;
import randomdatacreator.RandomReportGroup;
import writer.DataWriter;

public class ReportTreeWriter {

	public static List<List<String>> completeDataSet = new ArrayList<List<String>>();

	
	public static void createFile() {
		
		Collections.shuffle(completeDataSet);
		
		completeDataSet.add(0, new RandomHeaderData().getHeaderDataLine());

		DataWriter.deletePriorFile();
		
		try {
			DataWriter.writeDataToFile(completeDataSet);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addCompleteDataToFile() {
		try {
			DataWriter.writeDataToFile(completeDataSet);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<List<String>> generateData() {

		List<List<String>> fullDataGenerated = new ArrayList<>();
		
		Random rand = new Random();
		int cycleIterations = rand.nextInt(8) + 1;	
		int reportsGroupIterations = rand.nextInt(15) + 1;
		int reportsIterations = rand.nextInt(30) + 1;
				
		for (int i = 1; i <= cycleIterations; i++) {
			fullDataGenerated.add(new RandomCycle().getRandomCycleLine());
		}
		
		for (int j = 1; j <= reportsGroupIterations; j++) {
			fullDataGenerated.add(new RandomReportGroup(cycleIterations).getRandomReportsGroupLine());
		}
		
		for (int k = 1; k <= reportsIterations; k++) {
			fullDataGenerated.add(new RandomReport(reportsGroupIterations).getRandomReportsLine());
		}
		
		return fullDataGenerated;
	}
	
	
	
}
