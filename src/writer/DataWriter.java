package writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class DataWriter {
	
	private static final String FILE = System.getProperty("user.home") + "/Desktop/text.txt";
	
	public static void writeDataToFile(List<List<String>> shuffledCompleteData) 
			throws FileNotFoundException, IOException, ClassNotFoundException {	
		System.out.println("writing to file: " + FILE);
		FileWriter writer = new FileWriter(FILE, true);	
		BufferedWriter output = new BufferedWriter(writer); 
		
		for (String headerEntries : shuffledCompleteData.get(0)) {
			output.write(headerEntries + ",\t");
		}
		
		output.newLine();
		
		List<List<String>> trimmedListOfData = shuffledCompleteData.subList(1, shuffledCompleteData.size()); 
		
		for (List<String> dataLine : trimmedListOfData) {
			for (String dataEntry : dataLine) {
				output.write(dataEntry + ",\t\t");
			}
			output.newLine();
		}
		
		output.close();
		writer.close();
	}
	
	public static void deletePriorFile() {
		File file = new File(FILE);
		if(file.exists()) {
			file.delete();
		} 
	}
}
