package diff;

import java.io.File;
import java.util.ArrayList;

public class Diff {
	static int count=0;
	static ArrayList list2 = new ArrayList();
	public static void main(String[] args) {
		String a,b;
		Diff demo = new Diff();
		
		demo.fileList("D:\\CCU\\Desktop\\hi");
		a=list2.toString();
		System.out.println(a);
		list2.clear();
		demo.fileList("D:\\CCU\\Desktop\\hi-½Æ»s");
		b=list2.toString();
		System.out.println(b);
		if(a.equals(b))System.out.println("\n\nALL FILES EXIST AND MATCH");
		else System.out.println("\n\nFAIL");

	}
	
	private ArrayList fileList(String filePath) {
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
	private ArrayList fileList2(String filePath) {
		ArrayList list = new ArrayList();
		File file = new File(filePath);
		
		if (file.isDirectory()) {
			if (!filePath.matches(".*\\\\$")){
				filePath += "\\";
			}
			//list.add(filePath);
			for (String fileName : file.list()) {
				list.addAll(this.fileList(filePath + fileName));
			}
			return list;
		} else {
			list.add(filePath.toString());
			return list;
		}
	}

}
