package nodes;
public enum LevelsEnum {
	CYCLE(1),
	REPORTSGROUP(2),
	REPORTS(3);

	private int id;

	LevelsEnum(int id) {
		this.id = id;
	}

	public static LevelsEnum getEnumKeyword(int id) {
		for(LevelsEnum levelTypes: LevelsEnum.values()) {
			if(levelTypes.id == id){
				return levelTypes;
			}
		}
		return null;
	}
	
}
