package wednesday.fileandstorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = null;
		String data = "";
		List<String> arrayListData = new ArrayList<String>();
		List<String[]> arrayListDelimited = new ArrayList<String[]>();

		try {
			String location = "/Users/Habboubi/eclipse-workspace/Boston-Week6/src/wednesday/LoremIpsum.txt";
			File file = new File(location);
			input = new Scanner(file);

			while (input.hasNextLine()) {
				int counter = 0;
				String line = input.nextLine();
				arrayListData.add(line);
				data += arrayListData.get(counter);
				arrayListDelimited.add(line.split(","));
				counter++;

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} finally {

			System.out.println(data);
			System.out.println();
			System.out.println();
			for (String line : arrayListData) {
				System.out.println(line);
			}
			System.out.println();
			System.out.println();
			System.out.println("Array of Arrays");
			for (int i = 0; i < arrayListDelimited.size(); i++) {
				for (int b = 0; b < arrayListDelimited.get(i).length; b++) {
					System.out.println(arrayListDelimited.get(i)[b]);
				}
			}
			input.close();

		}

		// course

		String locationCourse = "/Users/Habboubi/eclipse-workspace/Boston-Week6/src/wednesday/courses.csv";
		try {
			File file = new File(locationCourse);

			Scanner input2 = new Scanner(file);
			ArrayList<Course> data2 = new ArrayList<Course>();
			while(input2.hasNextLine()) {
				String[] line = input2.nextLine().split(",");
				data2.add(new Course(line[0],line[1],line[2]));
			}
			for(Course course: data2) {
				System.out.format("%-15s | %-35s | %-25s \n", course.getCode(),course.getName(), course.getInstructor());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		Scanner userInput = new Scanner(System.in);
		

		System.out.println("Course Code:");
		String code = userInput.nextLine();
		System.out.println("Course Name:");
		String courseName = userInput.nextLine();
		System.out.println("Instructor Name:");
		String instructorName = userInput.nextLine();
		ArrayList<Course> data3 = new ArrayList<Course>();

		try {
		File file3 = new File("/Users/Habboubi/eclipse-workspace/Boston-Week6/src/wednesday/courses2.csv");
		FileWriter writer = new FileWriter(file3,true);
		String line4 = "\n"+code+","+courseName+","+instructorName;
		writer.write(line4);
		writer.close();
	//	Scanner input5 = new Scanner(file3);
		
		}catch(IOException e) {
			
		}finally{
			File file3 = new File("/Users/Habboubi/eclipse-workspace/Boston-Week6/src/wednesday/courses2.csv");
			Scanner input5 = new Scanner(file3);
			while(input5.hasNextLine()) {
				String[] line = input5.nextLine().split(",");
				data3.add(new Course(line[0],line[1],line[2]));
			}
			for(Course course: data3) {
				System.out.format("%-15s | %-35s | %-25s \n", course.getCode(),course.getName(), course.getInstructor());
			}
			
		}
		


		
	}// main

}// class
