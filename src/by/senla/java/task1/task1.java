package by.senla.java.task1;
/*
 * Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке. 
 * Если цифр нет, то возвращаемая сумма должна быть равна 0.
 */

public class task1 {

	public static void main(String[] args) {
		
		String str = "168..71vgyu--n863";
		
		int sum = sumFromString(str);
		
		System.out.println(sum);
		
	}
	
	public static int sumFromString (String str) {
		
		int sum = 0;
		
		for(int i = 0; i< str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if (Character.isDigit(ch)) {
				
				sum = sum + (ch - '0');
			}
		}
		return sum;
	}
}
