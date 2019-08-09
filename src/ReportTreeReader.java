import java.util.ArrayList;
import java.util.List;

import descriptor.BaseDescriptor;
import descriptor.DescriptorFactoryCreator;
import nodes.CycleTreeNode;
import nodes.NodeFactoryCreator;
import nodes.TreeNode;
import reader.FileLineReader;

public class ReportTreeReader {

	public static void createTree() {

		List<String> linesFromFile = FileLineReader.readFile();

		List<BaseDescriptor> descriptorsGenerated = new ArrayList<>();

		for (String lineGenerated : linesFromFile) {
			int nodeLevelFromFile = Character.getNumericValue(lineGenerated.charAt(0));		
			descriptorsGenerated.add(DescriptorFactoryCreator.createNodeDescriptor(lineGenerated, nodeLevelFromFile));
		}

		for (BaseDescriptor descriptor : descriptorsGenerated) {
			NodeFactoryCreator.getNodeCreator(descriptor);
		}

	}


	public static void printTree() {
		for (TreeNode node : CycleTreeNode.cycleMap.values()) {
			printNode(node, "");
		}
	}

	public static void printNode(TreeNode node, String prefix) {
		System.out.println(prefix + node.getNodeToPrint());
		prefix +="\t";
		for (TreeNode child : node.getChildren()) {
			printNode(child, prefix);
		}
	}


}
