package exam.oop3.step05;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/*
 * 문제 : c:\\javaide의 모든 폴더를 출력하시오.
 * 		  단, 그 하위 폴더도 포함한다.
 * 
 * 문제 : 폴더를 출력할 때 다음 형식으로 출력하시오.
 * 		출력되는 폴더 이름에 전체 경로를 출력하시오.
 * 		 c:/javaide
 * 		 c:/javaide/servers
 * 		 c:/javaide/tomcat...
 */

public class File03 {
	public static void main(String[] args) {
		File f = new File("D:\\javaide\\server");
		displayDirectory(f);
	}
	static void displayDirectory(File dir){
		if(dir.isDirectory()){
			 for (File f : dir.listFiles()) {
				 if(f.isDirectory()){
					 System.out.println(f.getAbsolutePath());
					displayDirectory(f); //재귀호출 
				 }
			 }
			
		}
	}

}












