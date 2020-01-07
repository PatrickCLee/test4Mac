package a.lot.of.practices;
// 注意s和e的宣告方式和建構方式
public class E03VirtualDemo {

	   public static void main(String [] args) {
	      E02Salary s = new E02Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
	      E01Employee e = new E02Salary("John Adams", "Boston, MA", 2, 2400.00);
	      System.out.println("Call mailCheck using Salary reference --");   
	      s.mailCheck();
	      System.out.println("\nCall mailCheck using Employee reference--");
	      e.mailCheck();
	   }
	}
//當呼叫 s.mailCheck(), 編譯器看到的是在Salary類別的mailCheck(), 
//JVM呼叫/使用(原文為invokes)的也是在Salary類別裡的mailCheck()

//***當呼叫e.mailCheck(), 編譯器看到的是在Employee類別的mailCheck()
//在編譯時, 編譯器用的是Employee類別來辨別這個敘述是否合理(該類別裡有否此method)
//但, 執行時, JVM呼叫/使用(原文為invokes)的是Salary類別裡的mailCheck()

//這種行為被稱為 virtual method invocation, 而這種method被稱為virtual methods
//An overridden method is invoked at run time, 
//no matter what data type the reference is that was used in the source code at compile time.
