package a.lot.of.practices;
// 宣告為父，用子建構範例	注意mailCheck()
public class E01Employee {
	   private String name;
	   private String address;
	   private int number;

	   public E01Employee(String name, String address, int number) {
	      System.out.println("Constructing an Employee");
	      this.name = name;
	      this.address = address;
	      this.number = number;
	   }

	   public void mailCheck() {
	      System.out.println("Mailing a check to " + this.name + " " + this.address);
	   }

	   public String toString() {
	      return name + " " + address + " " + number;
	   }

	   public String getName() {
	      return name;
	   }

	   public String getAddress() {
	      return address;
	   }

	   public void setAddress(String newAddress) {
	      address = newAddress;
	   }

	   public int getNumber() {
	      return number;
	   }
	}