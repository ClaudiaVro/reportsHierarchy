package descriptor;

import nodes.FileFormat;

public class ReportDescriptor extends BaseDescriptor{
	private String report_code;
	private String report_full_name;
	private FileFormat report_type;
	private int report_id;
	
	private int parentId;
	
	public ReportDescriptor(String lineFromFile) {
		super(lineFromFile);
		this.report_code = getDataExtracted().get(FileHeaderEnum.report_code.ordinal());
		this.report_full_name = getDataExtracted().get(FileHeaderEnum.report_full_name.ordinal());
		this.report_type = FileFormat.valueOf(getDataExtracted().get(FileHeaderEnum.report_type.ordinal()));
		this.report_id = Integer.parseInt(getDataExtracted().get(FileHeaderEnum.report_id.ordinal()));
		
		this.parentId = Integer.parseInt(getDataExtracted().get(FileHeaderEnum.report_group_id.ordinal()));
	}

	public int getParentId() {
		return parentId;
	}

	public String getReport_code() {
		return report_code;
	}

	public String getReport_full_name() {
		return report_full_name;
	}

	public FileFormat getReport_type() {
		return report_type;
	}

	public int getReport_id() {
		return report_id;
	}
	
	
}
