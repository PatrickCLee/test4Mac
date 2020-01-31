package tw.ptl.apps;

import java.util.Collections;
import java.util.LinkedList;

public class Ztest implements Comparable<Ztest> {
	String name;
	int age;
	double height;
	Ztest(String name, int age, double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	@Override
	public int compareTo(Ztest o) {
		return (int) (this.height - o.height);
	}
	
	public String toString() {
		return name + " " + age + " " + height;
		
	}
	
	public static void main(String[] args) {
		LinkedList<Ztest> list = new LinkedList<Ztest>();
		list.add(new Ztest("Prayer",30,176.5));
		list.add(new Ztest("Sully",36,190.5));
		list.add(new Ztest("Ivan",26,178.3));
		Collections.sort(list);
		System.out.println(list);
	}


}
