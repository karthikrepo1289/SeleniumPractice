package seleniumsessions;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(10/0);
		}catch(ArithmeticException e) {
			System.out.println(10/0);
		}
		
		try {
			System.out.println("Testing");
		}catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Its a successful");
	}

}
