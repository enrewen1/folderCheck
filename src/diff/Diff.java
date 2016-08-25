package diff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Diff {
	static ArrayList list2 = new ArrayList();
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("path.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String[] path =new String[2];
		int countLine=0;
		while (br.ready()) {
			
			path[countLine++]=br.readLine();
			
		}
		
		System.out.println(path[0]);
		System.out.println(path[1]);
		String fileString1,fileString2;
		Diff demo = new Diff();
		
		demo.fileList(path[0]);
		fileString1=list2.toString();
		System.out.println(fileString1);
		list2.clear();
		
		demo.fileList(path[1]);
		fileString2=list2.toString();
		System.out.println(fileString2);
		if(fileString1.equals(fileString2))
			System.out.println("\n\nSUCCESS\nALL FILES EXIST AND MATCH");
		
		else System.out.println("\n\nFAIL\nThey're Different");
		
		
		
		
		fr.close();

	}
	
	public ArrayList fileList(String filePath) {
		ArrayList list = new ArrayList();
		File file = new File(filePath);
		
		if (file.isDirectory()) {
			if (!filePath.matches(".*\\\\$")){
				filePath += "\\";
			}
			list.add(filePath);
			for (String fileName : file.list()) {
				list2.add(fileName);
				list.addAll(this.fileList(filePath + fileName));
			}
			return list;
		} else {
			list.add(filePath.toString());
			return list;
		}
		
	}

}
