package nodes;
import java.util.HashMap;
import java.util.Map;

import descriptor.ReportDescriptor;

public class ReportsTreeNode extends TreeNode{


	static Map<Integer, TreeNode> reportsMap = new HashMap<>();
	ReportDescriptor descriptor;
	private String nodeToPrint;
	
	public ReportsTreeNode(ReportDescriptor descriptor) {
		super(ReportsGroupTreeNode.reportsGroupMap.get(descriptor.getParentId())); // parent TreeNode is returned here
		this.descriptor = descriptor;
		reportsMap.put(descriptor.getReport_id(), this);
		
		nodeToPrint = this.constructPrintNode();
	}
	
	 public String constructPrintNode() {
			return getUniqueId() + " " 
								+ descriptor.getReport_code() + " "
								+ descriptor.getReport_full_name();
		}

	public String getNodeToPrint() {
		return nodeToPrint;
	}
}
