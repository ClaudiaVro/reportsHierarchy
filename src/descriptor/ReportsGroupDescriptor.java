package descriptor;
public class ReportsGroupDescriptor extends BaseDescriptor{
	private int report_group_id;
	private String report_group_code;
	private String report_group_full_name;
	
	private int parentId;
	
	public ReportsGroupDescriptor(String linefromFile) {
		super(linefromFile);
		this.report_group_id = Integer.parseInt(getDataExtracted().get(FileHeaderEnum.report_group_id.ordinal()));
		this.report_group_code = getDataExtracted().get(FileHeaderEnum.report_group_code.ordinal());
		this.report_group_full_name = getDataExtracted().get(FileHeaderEnum.report_group_full_name.ordinal());
		
		this.parentId = Integer.parseInt(getDataExtracted().get(FileHeaderEnum.cycle_id.ordinal()));
		
	}

	public int getReport_group_id() {
		return report_group_id;
	}

	public String getReport_group_code() {
		return report_group_code;
	}

	public String getReport_group_full_name() {
		return report_group_full_name;
	}

	public int getParentId() {
		return parentId;
	}
}


// readfile --> transmite linia --> creeaza descriptor --> descriptor trimite catre factory de noduri