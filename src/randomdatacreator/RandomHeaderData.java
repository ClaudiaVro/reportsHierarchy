package randomdatacreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomHeaderData{
		
	List<String> headerDataLine = new ArrayList<>();

	 public RandomHeaderData() {
		 headerDataLine = createDataArray();
	}

	public List<String> createDataArray() {
		List<String> dataArray = new ArrayList<>();
		
		String[] headerElements = {"level_id", "cycle_id", "cycle_data", "cycle_timestamp",
				 "report_group_id", "report_group_code", "report_group_full_name", 
				 "report_code", "report_full_name", "report_type", "report_id"};
		
		dataArray = Arrays.asList(headerElements);
		
		return dataArray;
	}

	public List<String> getHeaderDataLine() {
		return headerDataLine;
	}

	
}
