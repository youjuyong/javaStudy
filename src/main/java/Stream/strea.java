package Stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class strea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Student> studentStream = Stream.of(new Student("이자바", 3, 300),
												  new Student("김자바", 1, 200));
		
		studentStream.sorted(Comparator.comparing(Student::getBan)
							.thenComparing(Comparator.naturalOrder()))
							.forEach(System.out::println);
	}

}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	
	String getName() { return name; }
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }
	
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
	
}