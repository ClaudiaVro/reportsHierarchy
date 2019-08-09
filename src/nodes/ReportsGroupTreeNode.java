package nodes;
import java.util.HashMap;
import java.util.Map;

import descriptor.ReportsGroupDescriptor;

public class ReportsGroupTreeNode extends TreeNode{

	static Map<Integer, TreeNode> reportsGroupMap = new HashMap<>();
	ReportsGroupDescriptor descriptor;
	private String nodeToPrint;
	
	public ReportsGroupTreeNode(ReportsGroupDescriptor descriptor) {
		super(CycleTreeNode.cycleMap.get(descriptor.getParentId())); // parent TreeNode is returned here
		
		this.descriptor = descriptor;		
		reportsGroupMap.put(descriptor.getReport_group_id(), this);
		
		nodeToPrint = constructPrintNode();
	}
	
	 public String constructPrintNode() {
			return getUniqueId() + " " 
								+ descriptor.getReport_group_code() + " "
								+ descriptor.getReport_group_full_name();
		}

	public String getNodeToPrint() {
		return nodeToPrint;
	}
}
