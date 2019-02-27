import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
    	int result = 0;
    	List<String> lines = getFileLines("test_input.txt");
		for(String line : lines){
			int field1, field2, field3;
			int[] dimensions = Arrays.stream(line.toLowerCase().split("x"))
					.mapToInt(Integer::parseInt)
					.toArray();
			field1 = dimensions[0] * dimensions[1];
			field2 = dimensions[1] * dimensions[2];
			field3 = dimensions[0] * dimensions[2];
			int lowestField = getLowestField(field1, field2, field3);
			int sumOfCuboid = (field1+field2+field3)*2 + lowestField;
			result += sumOfCuboid;
		}
		System.out.println("Wynik: " + result);
    }

	private static int getLowestField(int field1, int field2, int field3) {
		return field1>field2 ? (field2>field3 ? field3 : field2) : (field1>field3 ? field3 : field1);
	}
	private static List<String> getFileLines(String fileName) throws IOException {
		String filePath = "src/" + fileName;
		Path path = Paths.get(filePath);
		return Files.readAllLines(path);
	}
}
