package nodes;

import descriptor.BaseDescriptor;
import descriptor.CycleDescriptor;
import descriptor.ReportDescriptor;
import descriptor.ReportsGroupDescriptor;

public class NodeFactoryCreator {
	public static TreeNode getNodeCreator(BaseDescriptor descriptor) {
		switch (descriptor.getLevel_id()) {
		case CYCLE:
			System.out.println("Creating Cycle");
			return new CycleTreeNode((CycleDescriptor) descriptor);
		case REPORTSGROUP:
			System.out.println("Creating Reports Group");
			return new ReportsGroupTreeNode((ReportsGroupDescriptor) descriptor);
		case REPORTS:
			System.out.println("Creating Reports");
			return new ReportsTreeNode((ReportDescriptor) descriptor);
		default:
			return null;
		}
	}
}
