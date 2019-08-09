package nodes;
import java.util.Random;

public enum FileFormat {
	PDF,
	TXT, 
	XML;


	public static FileFormat getReportType(String string) {
		for (FileFormat	formatType : FileFormat.values()) {
			if (formatType.name().equalsIgnoreCase(string)){
				return formatType;
			}
		}
		System.out.println("Something went wrong");
		return null;
	}
	
	public static FileFormat getRandomFileFormat() {
		int rnd = new Random().nextInt(FileFormat.values().length);
		return FileFormat.values()[rnd];
	}
}