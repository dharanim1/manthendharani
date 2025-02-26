package java_day3;


public class threading {

	public static int addnumbers(int a,int b) {
		int sum=0;
		sum = a+b;
		return sum;
		
		

	}
	public static int addnumbers2(int a,int b) {
		int sum=0;
		sum = a+b;
		return sum;
		
		

	}
	public static void main(String[] args) {
		int result;
		result=addnumbers(5,6);
		System.out.println(result);
		System.out.println(addnumbers2(256, 24));
	
	}

}
