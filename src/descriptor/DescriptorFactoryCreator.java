package descriptor;

import nodes.LevelsEnum;

public class DescriptorFactoryCreator {

	public static BaseDescriptor createNodeDescriptor(String lineFromFile, int idLevel) {
		LevelsEnum nodeLevel = LevelsEnum.getEnumKeyword(idLevel); 
		
		switch (nodeLevel) {
		case CYCLE:
			System.out.println("Creating Cycle Descriptor");
			return new CycleDescriptor(lineFromFile);
		case REPORTSGROUP:
			System.out.println("Creating Reports Group Descriptor");
			return new ReportsGroupDescriptor(lineFromFile);
		case REPORTS:
			System.out.println("Creating Reports Descriptor");
			return new ReportDescriptor(lineFromFile);
		default:
			return null;
		}
	}
	
	
}
