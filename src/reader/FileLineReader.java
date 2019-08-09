package reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileLineReader {

	private static final String FILE = System.getProperty("user.home") + "/Desktop/text.txt";

	public static List<String> readFile() {
		List<String> completeLinesList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			for (int nodeLevel = 1; nodeLevel <= 3; nodeLevel++) {
				completeLinesList.addAll(readFileLines(br, nodeLevel));
				br.close();
				br = new BufferedReader(new FileReader(FILE));
			}
		} catch(IOException e) {
			System.out.println("File not found" + e);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return completeLinesList;
	}

	private static List<String> readFileLines(BufferedReader br, int nodeLevel) {
		List<String> linesByLevelList = new LinkedList<>();
		String lineFromFile;
		try {
			br.readLine();
			while ((lineFromFile = br.readLine()) != null) {
				int nodeLevelFromFile = Character.getNumericValue(lineFromFile.charAt(0));
				if(nodeLevel == nodeLevelFromFile || nodeLevel == 0 ) {
					linesByLevelList.add(lineFromFile);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return linesByLevelList;
	}
}
