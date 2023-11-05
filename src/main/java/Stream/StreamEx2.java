package Stream;

import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File[] fileArr = { new File("Ex1.Java"), new File("Ex1.bak")};
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		Stream<String> filenameStream = fileStream.map(File::getName);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
		.filter(s -> s.indexOf('.') != -1)
		.map(s -> s.substring(s.indexOf('.') + 1))
		.map(String::toUpperCase)
		.distinct()
		.forEach(System.out::print);
		System.out.println();
	}

}
