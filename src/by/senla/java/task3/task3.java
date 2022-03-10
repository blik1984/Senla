package by.senla.java.task3;

/*
 * Создайте программу, которая будет:
 * подсчитывать количество гласных в словах
 * выводить слова отсортированным списком по количеству гласных (сначала те, у которых больше гласных)
 * делать первую гласную букву в слове заглавной
 * Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).
*/

/*
 * Не совсем понятно программа должна это делать всё и сразу или по запросу пользователя
 * Реализован выбор действия по запросу пользователя
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {

	public static void main(String[] args) {

		String str = requestString();
		
		int flag = requestAction();
		
		if (flag == 1) {
			int countVowel = countVowel(str);
			System.out.println("Количество гласных во введённой строке - " + countVowel);
		} else if (flag == 2) {
			String[] words = sortWords(str);
			for (String word : words) {
				System.out.println (word);
			} 
		} else if (flag == 3) {
				String[] words2 = upperFirstVowelString(str);
				for (String word : words2) {
					System.out.println (word);
				} 
			}
		}
		
	/*
	 * метод запрашивает у пользователя начальную строку для дальнейших операций
	 */
	public static String requestString() {
		
		System.out.println("Введите строку>>>");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}
	
	/*
	 * метод запрашивает у пользователя инструкции для дальнейших действий
	 */
	public static int requestAction () {
		
		System.out.println("Доступные действия:  \n1 - подсчитать количество гласных \n2 - отсортировать слова по количеству гласных "
				+ "\n3 - сделать первую гласную букву в каждом слове заглавной \nВведите номер действия >>> \n");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		 
		while (!sc.hasNextInt()) {
			System.out.println("Выбор неверный. Повторите выбор \nДоступные действия:  \n1 - подсчитать количество гласных \n2 - отсортировать слова по количеству гласных "
					+ "\n3 - сделать первую гласную букву в каждом слове заглавной \nВведите номер действия >>> \n");
			@SuppressWarnings("unused")
			String str = sc.nextLine();
		}
		
		int flag = sc.nextInt();
		
		while (flag != 1 &flag != 2 & flag != 3) {
			System.out.println("Выбор неверный. Повторите выбор");
			requestAction();
		}
		return flag;
	}
	
	/*
	 * метод подсчитывает количество гласных буков в строке (русский и латиница оба регистра)
	 */
	public static int countVowel (String str) {
		
		int count = 0;
		
		Pattern pattern = Pattern.compile("[ёйуеыаоэяиюЁЙУЕЫАОЭЯИЮqeyuioajQEYUIOAJ]");
		Matcher text = pattern.matcher(str);
		
		while (text.find()) {
			count++;
		}
		return count;
	}
	
	/*
	 * метод преобразует строку в массив отдельных слов и сортирует их по убыванию частоты встречаемости гласных буков (русский и латиница оба регистра)
	 */
	public static String[] sortWords(String str) {
		
		String[] words = str.split("\\s*(\\s|,|!|\\?|;|:|\\.)\\s*");
		int[]count = new int[words.length];
		
		for (int i = 0; i < words.length; i++) {
			int countVowel = countVowel(words[i]);
			count[i] = countVowel;
		}
		for (int k = 0; k < count.length - 1; k++) {
			if(k < 0) {
				k = 0;
				}
			if (count[k+1] > count[k]) {
				int prom = count[k+1];
				count[k+1] = count[k];
				count[k] = prom;
				String promS = words[k+1];
				words[k+1] = words[k];
				words[k] = promS;
				k = k-2;
			}
		}
		return words;
	}
	
	/*
	 * метод разбивает строку на отдельные слова и в каждом слове первую гласную букву преобразует в верхний регистр
	 */
	public static String[] upperFirstVowelString(String str) {
		
		String[] words = str.split("\\s*(\\s|,|!|\\?|;|:|\\(|\\)|\\.+)\\s*");

		for (int i = 0; i < words.length; i++) {
			
			words[i] = upperFirstVowelWord(words[i]);
		}
		return words;
	}
	
	/*
	 * метод преобразует первую встреченную гласную букву в строке в вехний регистр
	 */
	public static String upperFirstVowelWord (String word) {
		
		for (int k = 0; k < word.length(); k++) {
			
			char ch = word.charAt(k);
			String letter = Character.toString(ch);
			Pattern pattern = Pattern.compile("[ёйуеыаоэяиюЁЙУЕЫАОЭЯИЮqeyuioajQEYUIOAJ]");
			Matcher text = pattern.matcher(letter);
			
			if (text.find()) {
				word = word.substring(0,k) + letter.toUpperCase() + word.substring(k+1);
				return word;
			}
		}
		return word;
	}
}

