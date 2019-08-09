package nodes;
import java.util.HashMap;
import java.util.Map;

import descriptor.CycleDescriptor;

public class CycleTreeNode extends TreeNode{

	public static Map<Integer, TreeNode> cycleMap = new HashMap<>();
	CycleDescriptor descriptor;
	private String nodeToPrint;
	
	public CycleTreeNode(CycleDescriptor descriptor) {
		super(null);
		this.descriptor = descriptor;
		
		cycleMap.put(descriptor.getCycle_id(), this);
		
		nodeToPrint = constructPrintNode();
	}
	
	 public String constructPrintNode() {
		return getUniqueId() + " " + descriptor.getCycle_data() + " " + descriptor.getCycle_timestamp();
	}

	public String getNodeToPrint() {
		return nodeToPrint;
	}
	
}
