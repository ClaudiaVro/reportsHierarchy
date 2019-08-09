package randomdatacreator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import descriptor.FileHeaderEnum;

public class RandomReportGroup{

	static int uniqueReportGroupId = 1;
	List<String> randomReportsGroupLine = new ArrayList<>(Collections.nCopies(11, ""));

	public RandomReportGroup(int maxAllowedParentId) {
		
		getRandomReportsGroupLine().set(FileHeaderEnum.level_id.ordinal(),"2");
		getRandomReportsGroupLine().set(FileHeaderEnum.cycle_id.ordinal(), String.valueOf(getRandomParent(maxAllowedParentId)));
		getRandomReportsGroupLine().set(FileHeaderEnum.report_group_id.ordinal(), String.valueOf(uniqueReportGroupId));
		getRandomReportsGroupLine().set(FileHeaderEnum.report_group_code.ordinal(), generateRandomListOfCodes("code"));
		getRandomReportsGroupLine().set(FileHeaderEnum.report_group_full_name.ordinal(), generateRandomListOfCodes("name"));
		
		uniqueReportGroupId++;
	}

	private String generateRandomListOfCodes(String caller) {
		
		String[] listOfGroupCodes = {"DS", "YS", "CS"}; 
		String[] listOfGroupFullName = {"Daily Statement", "Yearly Statement", "Custom Statement"};
		
		int randomAccessedReportGroupCode = new Random().nextInt(listOfGroupCodes.length);
		
		return caller == "code" ? listOfGroupCodes[randomAccessedReportGroupCode] 
				: listOfGroupFullName[randomAccessedReportGroupCode]; 		
	}
	
	private int getRandomParent(int parentId) {
		Random rand = new Random();
		int randomParent = rand.nextInt(parentId) + 1;	
		
		return randomParent;	
	}

	public List<String> getRandomReportsGroupLine() {
		return randomReportsGroupLine;
	}

}
