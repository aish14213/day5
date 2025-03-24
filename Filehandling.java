package day5javaprograms;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Filehandling {
	public static void main(String[]args) throws IOException {
		//file created//
		File obj=new File("C:\\Users\\casstudent\\eclipse-workspace\\day5javaprograms\\src\\day5javaprograms\\file");
		obj.createNewFile();
		System.out.println("File created");
		try {
			FileWriter w1=new FileWriter("C:\\Users\\casstudent\\eclipse-workspace\\day5javaprograms\\src\\day5javaprograms\\filedemo");//write the file//
			w1.write("hello java I/O!");
			w1.close();
			System.out.println("data written to file");
			FileReader r1=new FileReader("C:\\Users\\casstudent\\eclipse-workspace\\day5javaprograms\\src\\day5javaprograms\\filedemo");//read the file//
			int character;
			while((character=r1.read())!=-1) {
				System.out.print((char) character);
			}
			r1.close();
		}catch (IOException e) {
			System.out.println("an error occurred:"+e.getMessage());
			}
	}

}
