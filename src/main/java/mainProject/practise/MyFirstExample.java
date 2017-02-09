package mainProject.practise;

public class MyFirstExample{

	public static int multiplyTwoNum(double num1,double num2){
		Double num = (num1/(1/num2));
		return num.intValue();	
	}

	public static void main(String [] args) throws Exception{
		double num1 = 0;
		double num2 = 0;
		try{
			num1 = Double.parseDouble(args[0]);
			num2 = Double.parseDouble(args[1]);
			System.out.println("Calculate Products of Numbers "+multiplyTwoNum(num1,num2));			
		}catch(Exception e){
			throw e;
		}
	}
}
