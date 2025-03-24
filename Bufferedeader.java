package day5javaprograms;
import java.io.*;
public class Bufferedeader {
	public static void main(String[]args) {
		try {
			//buffer reader//
			BufferedReader r1=new BufferedReader(new FileReader("C:\\samplefolder\\sample.txt"));
					String line;
			System.out.println("reading file line by line:");
			while((line=r1.readLine())!=null) {
				System.out.println(line);
			}
			r1.close();
		}catch(IOException e) {
			System.out.println("error reading file:"+e.getMessage());
		}
try {
	BufferedWriter bw=new BufferedWriter (new FileWriter("C:\\samplefolder\\sample.txt"));
bw.write("java file handling example");
bw.newLine();
bw.write("bufferedwriter makes writing more efficient");
bw.close();
System.out.println("data written to file successfully");
}catch(IOException e) {
	System.out.println("error writing tofile:"+e.getMessage());
}
}
}