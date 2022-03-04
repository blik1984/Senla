package by.senla.java.task2;

/*
 * Создайте программу, которая будет вычислять и выводить на экран простые множители, 
 * из которых состоит целое число, введенное пользователем. 
 * Если введенное число не целое, то нужно сообщать пользователю об ошибке.
 */

import java.util.*;

public class task2 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите целове число");
		
		while (!sc.hasNextInt() & !sc.hasNextShort() & !sc.hasNextLong()) { 
			
			System.out.println("Введено не целое число. Повторите ввод");
			@SuppressWarnings("unused")
			String str = sc.nextLine();
		} 
		
		long num = sc.nextLong();
		
		ArrayList<Long> simpleMultiplier = new ArrayList<Long>();
		
		simpleMultiplier = getSimpleMultiplier(num);
		
		System.out.println(simpleMultiplier);
	}
	
	public static ArrayList<Long> getSimpleMultiplier(long num) {
		
		ArrayList<Long> mas = new ArrayList<Long>();
		mas.add(1L);
		
		for(long i = 2; i<= num; i++) {
			
			while (num%i == 0) {
				num = num / i;
				mas.add(i);
				if (num == 1) {
					return mas;
				}
				if(checkSimple(num)) {
					mas.add(num);
					return mas;
				}
			}
		}
		return mas;
	}
	
	public static boolean checkSimple(long num) {
		long end = (long)Math.sqrt(num);
		
		for (long i = 2; i<=end; i++) {
			if (i%2 == 0 & i != 2) {
				i++;
			}
			if (i%3 == 0 & i != 3) {
				i++;
			}
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}
}
