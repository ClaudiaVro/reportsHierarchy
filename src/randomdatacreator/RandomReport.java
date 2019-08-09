package randomdatacreator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import descriptor.FileHeaderEnum;
import nodes.FileFormat;

public class RandomReport {
	
	static int reportId = 1;
		
	List<String> randomReportsLine = new ArrayList<>(Collections.nCopies(11, ""));
	
	public RandomReport(int maxAllowedParentId) {
		
		getRandomReportsLine().set(FileHeaderEnum.level_id.ordinal(), "3");
		getRandomReportsLine().set(FileHeaderEnum.report_group_id.ordinal(), String.valueOf(getRandomParent(maxAllowedParentId)));
		getRandomReportsLine().set(FileHeaderEnum.report_code.ordinal(), generateRandomListOfCodes("code"));
		getRandomReportsLine().set(FileHeaderEnum.report_full_name.ordinal(), generateRandomListOfCodes("name"));
		getRandomReportsLine().set(FileHeaderEnum.report_type.ordinal(), String.valueOf(FileFormat.getRandomFileFormat()));
		getRandomReportsLine().set(FileHeaderEnum.report_id.ordinal(), String.valueOf(reportId));
		
		reportId++;
	}

	private String generateRandomListOfCodes(String caller) {
		
		String[] randomReportCodes = {"FSCM", "DSTM", "AFBY", "LCJY"};
		String[] randomReportNames = {"Daily Statement Report", "Closing Statement Report",
				"New Statement Report", "Quarterly Report"};
		
		int randomAccessedReportCode = new Random().nextInt(randomReportCodes.length);
		
		return caller == "code" ? randomReportCodes[randomAccessedReportCode] 
				: randomReportNames[randomAccessedReportCode]; 		
	}
	
	private int getRandomParent(int parentId) {
		Random rand = new Random();
		int randomParent = rand.nextInt(parentId) + 1;	
		
		return randomParent;
	}

	public List<String> getRandomReportsLine() {
		return randomReportsLine;
	}
}
