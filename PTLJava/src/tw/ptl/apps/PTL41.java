package tw.ptl.apps;
// file 沒有動到檔案內容
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PTL41 {

	public static void main(String[] args) {
		File dir2 = new File("dir2");
		File[] files = dir2.listFiles();
		for(File file : files) {
			Calendar cal = Calendar.getInstance(); 
			//因為Calendar是abstract class故無法直接new，而是利用static method創出物件
			cal.setTime(new Date(file.lastModified()));
//			cal.setTimeInMillis(file.lastModified()); 此行與上行擇一
			
			System.out.println(file.getName() +":"+
					file.length() + ":" +
					cal.get(Calendar.YEAR)+"-"+
					(cal.get(Calendar.MONTH)+1) +"-"+
					cal.get(Calendar.DAY_OF_MONTH));
			
			//或整個改成以下寫法
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			Date current = new Date(file.lastModified());
//			System.out.println(file.getName() +":"+
//					file.length() +":"+sdf.format(current));
		
		}
		
		
		
	}

}
