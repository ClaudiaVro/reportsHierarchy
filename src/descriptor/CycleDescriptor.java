package descriptor;

public class CycleDescriptor extends BaseDescriptor{

	private int cycle_id;
	private String cycle_data;
	private String cycle_timestamp;
	public CycleDescriptor(String lineFromFile) {
		super(lineFromFile);
		
		cycle_id = Integer.parseInt(getDataExtracted().get(FileHeaderEnum.cycle_id.ordinal()));
		cycle_data = getDataExtracted().get(FileHeaderEnum.cycle_data.ordinal());
		cycle_timestamp = getDataExtracted().get(FileHeaderEnum.cycle_timestamp.ordinal());
		
	}
	public int getCycle_id() {
		return cycle_id;
	}
	public String getCycle_data() {
		return cycle_data;
	}
	public String getCycle_timestamp() {
		return cycle_timestamp;
	}
}
