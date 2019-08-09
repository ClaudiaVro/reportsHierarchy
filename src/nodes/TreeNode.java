package nodes;
import java.util.LinkedList;
import java.util.List;

public abstract class TreeNode {
	private static int incrementalId = 1;
	
	private TreeNode parent; // null for root
	private List<TreeNode> children = new LinkedList<>();
	private int uniqueId;
	
	TreeNode(TreeNode parent){
		if (parent != null) {
			this.setParent(parent);
			this.getParent().getChildren().add(this);
		}
		
		uniqueId = incrementalId;
		incrementalId++;
	}

	private TreeNode getParent() {
		return parent;
	}

	private void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public abstract String getNodeToPrint();

}
