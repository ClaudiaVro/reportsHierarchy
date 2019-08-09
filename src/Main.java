import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		ReportTreeWriter.generateData();
		ReportTreeWriter.createFile();
		
		ReportTreeReader.createTree();
		ReportTreeReader.printTree();

	}
}