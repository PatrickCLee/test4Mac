package tw.ptl.apps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PTL999 {
	public static void main(String[] args) {
		File dir = new File("C:/NVIDIA");
		if (!dir.exists()) {
			dir.mkdirs();
										}		File src = new File("C:/");	File dst = new File("C:/NVIDIA/aaa");	try {		System.out.println(".");		FileInputStream fin =			new FileInputStream(src);		FileOutputStream fout =		new FileOutputStream(dst);		int len; byte[] buf = new byte[4096*1024];		while ( (len = fin.read(buf)) != -1) {		fout.write(buf,0,len);		}			fout.flush();		fout.close();	fin.close();	System.out.println(21);	}catch (Exception e) {	System.out.println(e.toString());
		}
	}
}
