package java8;

public class UsingFunctionalI1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Functional_1 fi1 = new Functional_1(){

			@Override
			public void printHello() {
				// TODO Auto-generated method stub
				System.out.println("Hello from functional interface");
			}
			
		};
		
		fi1.printHello();
		
		Functional_1 fi2 = new Functional_1(){

			@Override
			public void printHello() {
				// TODO Auto-generated method stub
				System.out.println("Hello from functional interface 2");
			}
			
		};
		
		fi2.printHello();
		
		Functional_1 fi3 = ()->System.out.println("Hello from Lambda implementation of FI ");
		
		
		
		fi3.printHello();
		

	}

}
