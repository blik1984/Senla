package by.senla.java.task4;

/*
 * Создайте программу, которая будет получать число и печатать его в виде картинки из звездочек
 * максимальную цифру в числе нужно печатать этими же маленькими цифрами
 */

import java.util.*;

public class task4 {
	
	private final static int[] noll = {11,9,0,2,0,4,1,1,1,5,2,0,2,6,3,0,3,6,4,0,4,6,5,0,5,6,6,0,6,6,7,0,7,6,8,0,8,6,9,1,9,5,10,2,10,4};
	private final static int[] one = {11,5,2,0,1,1,0,2,1,2,2,2,3,2,4,2,5,2,6,2,7,2,8,2,9,2,10,2};
	private final static int[] two = {11,8,2,0,1,0,0,1,0,2,0,3,0,4,1,5,2,5,3,5,4,4,5,3,6,2,7,1,8,0,9,0,10,0,10,1,10,2,10,3,10,4,10,5};
	private final static int[] three = {11,7,1,0,0,1,0,2,0,3,1,4,2,4,3,3,4,1,4,2,5,3,6,4,7,4,8,4,9,4,10,3,10,2,10,1,9,0};
	private final static int[] four = {11,7,0,0,1,0,2,0,3,0,4,0,5,0,5,1,5,2,5,3,5,4,4,4,3,4,2,4,1,4,0,4,6,4,7,4,8,4,9,4,10,4};
	private final static int[] five = {11,7,0,4,0,3,0,2,0,1,0,0,1,0,2,0,3,0,3,1,3,2,3,3,4,4,5,4,6,4,7,4,8,4,9,4,10,3,10,2,10,1,10,0};
	private final static int[] six = {11,7,0,4,1,3,2,2,3,1,4,0,5,0,6,0,7,0,8,0,9,0,10,1,10,2,10,3,9,4,8,4,7,4,6,4,5,3,5,2,5,1};
	private final static int[] seven = {11,7,0,0,0,1,0,2,0,3,0,4,1,4,2,3,3,2,4,1,5,0,6,0,7,0,8,0,9,0,10,0};
	private final static int[] eight = {11,8,0,2,0,3,1,1,1,4,2,1,2,4,3,2,3,3,4,1,4,4,5,0,5,5,6,0,6,5,7,0,7,5,8,0,8,5,9,1,9,4,10,2,10,3};
	private final static int[] nine = {11,7,0,1,0,2,0,3,1,0,1,4,2,0,2,4,3,0,3,4,4,0,4,4,5,1,5,2,5,3,5,4,6,4,7,3,8,2,9,1,10,0};
	

	public static void main(String[] args) {
		
		int num = 991809;
		
		printNum(num);
	}
	
	public static void printNum (int num) {
		
		ArrayList<Integer> numMas = convertToMas(num);
		ArrayList<Integer> indexMaxValue = searchIndexMaxValue(numMas);
		String[][] numPict = convertNumToPict(numMas, indexMaxValue);
		print(numPict);
		
	}
	
	/*
	 * получаем массив цифр заданного чила
	 */
	public static ArrayList<Integer> convertToMas (int num) {
		
		ArrayList<Integer> numMas = new ArrayList<>();
		if(num < 0) {
			num = Math.abs(num);
		}
		do {
			numMas.add(0,num%10);
			num = num / 10;
		} while (num > 0);
		
		return numMas;
	}
	
	/*
	 * находим индекс(ы) максимальной цифры в числе
	 */
	public static ArrayList<Integer> searchIndexMaxValue (ArrayList<Integer> numMas) {
		
		ArrayList<Integer> result = new ArrayList<>();
		int value = 0;
		
		for (int i = 0; i < numMas.size()-1; i++) {
			
			if (numMas.get(i) > value){
				value = numMas.get(i);
			}
		}
		for(int k = 0; k < numMas.size(); k++) {
			if (numMas.get(k) == value) {
				result.add(k);
			}
		}
		return result;
	}
	
	/*
	 * конвертируем всё число в картинку
	 */
	public static String[][] convertNumToPict(ArrayList<Integer> num, ArrayList<Integer> index){
		
		String[][] result = new String[11][1];
		String pict = "";
		int num2[] = new int[1];
		String[][] numPict = new String[1][1];
		int flag = 0;
		
		for (int i = 0; i < num.size(); i++) {
			if(num.get(i) == 0) {
				num2 = noll;
			} else if(num.get(i) == 1) {
				num2 = one;
			} else if(num.get(i) == 2) {
				num2 = two;
			} else if(num.get(i) == 3) {
				num2 = three;
			} else if(num.get(i) == 4) {
				num2 = four;
			} else if(num.get(i) == 5) {
				num2 = five;
			} else if(num.get(i) == 6) {
				num2 = six;
			} else if(num.get(i) == 7) {
				num2 = seven;
			} else if(num.get(i) == 8) {
				num2 = eight;
			} else if(num.get(i) == 9) {
				num2 = nine;
			}
 			for(int k = 0; k < index.size(); k++) {
				
				if (i == index.get(k)) {
					flag = 1;
				} 
			}
			if (flag == 1) {
				pict = ""+num.get(i) + " ";
				numPict = convertNum(num2, pict);
				result = cotcatNumPict(result, numPict);
			} else {
				pict = "* ";
				numPict = convertNum(num2, pict);
				result = cotcatNumPict(result, numPict);
			}
			flag = 0;
		}
		return result;
	}
	
	/*
	 * метод объединяет два двумерных массива путём добавления второго массива вправо от первого
	 */
	public static String[][] cotcatNumPict(String[][] one, String[][] two){
		
		String[][] result = new String[11][one[0].length + two[0].length - 1];
		
		for (int i = 0; i < one.length; i++) {
			
			for (int k = 0; k < one[i].length; k++) {
				result[i][k] = one[i][k];
			}
		}
		
		for (int i = 0; i < two.length; i++) {
			
			for (int k = 0; k < two[i].length; k++) {
				
				result[i][k - 1 + one[i].length] = two[i][k];
			}
		}
		return result;
	}
	
	/*
	 * метод получает одномерный массив и символ для заполнения. 
	 * Первые два значения одномерного массива это размерность для нового двумерного массива. 
	 * Последующие значения это "координаты для" заполнения двумерного массива символами.
	 */
	public static String[][] convertNum(int[] num, String pict) {
		
		String[][] num2 = new String[num[0]][num[1]];
		
		for(int i = 0; i<num2.length; i++) {
			for (int k = 0; k < num2[i].length; k++) {
				num2[i][k] = "  ";
			}
		}
		for (int i = 2; i < num.length; i = i+2) {
				num2[num[i]][num[i+1]] = pict;
			}
		return(num2);
	}
	
	/*
	 * метод выводит двумерный массив на экран
	 */
	public static void print (String[][] num) {
		
		for(int i = 0; i<num.length; i++) {
			System.out.println ("\n");
			for (int k = 0; k < num[i].length; k++) {
				System.out.print (num[i][k]);
			}
		}
	}
}
