package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void allFiles(String root){
		List<File> files=new ArrayList<File>();
		File f = new File(root);
		File[] fs = f.listFiles();
		for (File file : fs) {
			String name = file.getName();
			String n = name.split("\\.")[0].replaceAll("mega_", "");
			if (file.getName().endsWith("jpg")) {
				int intn = Integer.parseInt(n);
				//System.out.println(intn);
				if (57001<=intn&&intn<=59001) {
					files.add(file);
				}
			}
		}
		System.out.println(files.size());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String root = "E:\\photos_DL_20170901\\work\\image4_051001";
		//String root = "E:\\photos_DL_20170901\\work\\image4_049001";
		//String root = "E:\\photos_DL_20170901\\work\\55001";
		//String root = "E:\\photos_DL_20170901\\work\\all";
		String root = "E:\\photos_DL_20170901\\work\\image4_057001";
		allFiles(root);
		File f = new File(root);
		System.out.println(f.listFiles().length);

	}

}
