package descriptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nodes.LevelsEnum;

public abstract class BaseDescriptor {
	
	private static final String DELIMITER = ",";
	
	private LevelsEnum level_id; 
	private List<String> dataExtracted; 
	
	public BaseDescriptor(String lineFromFile) {
		dataExtracted = generateArrayFromLine(lineFromFile);
		level_id = LevelsEnum.getEnumKeyword(Integer.parseInt(getDataExtracted().get(FileHeaderEnum.level_id.ordinal())));	
	}
	
	private List<String> generateArrayFromLine(String lineFromFile){
		String[] splitEntries = lineFromFile.split(DELIMITER);
		List<String> listRetrieved = new ArrayList<>();
			for (int j = 0; j < splitEntries.length; j++) {
				splitEntries[j] = splitEntries[j].trim();
			}
			listRetrieved = Arrays.asList(splitEntries);
			return listRetrieved;
	}

	public LevelsEnum getLevel_id() {
		return level_id;
	}

	public List<String> getDataExtracted() {
		return dataExtracted;
	}


}
