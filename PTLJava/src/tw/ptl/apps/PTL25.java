package tw.ptl.apps;
//正規化以及檢查重複 以供24的猜數字使用
public class PTL25 {

	public static void main(String[] args) {
		String a = "23498765";
		if(a.matches("^[0-9]{"+ a.length() + "}$")) { //^開頭,[]裡面的字元出現(預設一次) ,{8}出現8次,$結尾
			boolean isDup = false;
			for(int i=0; i<a.length()-1; i++) {   //往後檢查是否有重複 最後一個字元不用往後檢查
				char c = a.charAt(i);
				if(a.substring(i+1).indexOf(c)>=0) {
					isDup = true;
					break;
				}
			}
			System.out.println(isDup?"XX2":"OK");
		}else {
			System.out.println("XX1");
		}
	}

}
