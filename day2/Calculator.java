package week1.day2;

public class Calculator {
	public int addThreeNumbers(int a,int b,int c) {
		return (a+b+c);
	}
public float subTwoNumbers(int i,float j) {
	return (i-j);
	}
public int divideTwoNumbers(int a,int b) {
	return (a/b);	
}

public static void main(String[] args) {
	Calculator Cl=new Calculator();
	Cl.addThreeNumbers(8, 4, 3);
	System.out.println(Cl.addThreeNumbers(8, 4, 3));
	
	Cl.subTwoNumbers(10, 4.5f);
	System.out.println(Cl.subTwoNumbers(10, 4.5f));
	
	Cl.divideTwoNumbers(8, 4);
	System.out.println(Cl.divideTwoNumbers(8, 4));
	
}

	
}

