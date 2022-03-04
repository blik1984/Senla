package by.senla.java.task3;

/*
 * �������� ���������, ������� �����:
 * ������������ ���������� ������� � ������
 * �������� ����� ��������������� ������� �� ���������� ������� (������� ��, � ������� ������ �������)
 * ������ ������ ������� ����� � ����� ���������
 * ����������� �������� ������������� ������� �������� �������. ����������� ������ (� �).
*/

/*
 * �� ������ ������� ��������� ������ ��� ������ �� � ����� ��� �� ������� ������������
 * ���������� ����� �������� �� ������� ������������
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
			System.out.println("���������� ������� �� �������� ������ - " + countVowel);
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
	 * ����� ����������� � ������������ ��������� ������ ��� ���������� ��������
	 */
	public static String requestString() {
		
		System.out.println("������� ������>>>");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}
	
	/*
	 * ����� ����������� � ������������ ���������� ��� ���������� ��������
	 */
	public static int requestAction () {
		
		System.out.println("��������� ��������:  \n1 - ���������� ���������� ������� \n2 - ������������� ����� �� ���������� ������� "
				+ "\n3 - ������� ������ ������� ����� � ������ ����� ��������� \n������� ����� �������� >>> \n");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		 
		while (!sc.hasNextInt()) {
			System.out.println("����� ��������. ��������� ����� \n��������� ��������:  \n1 - ���������� ���������� ������� \n2 - ������������� ����� �� ���������� ������� "
					+ "\n3 - ������� ������ ������� ����� � ������ ����� ��������� \n������� ����� �������� >>> \n");
			@SuppressWarnings("unused")
			String str = sc.nextLine();
		}
		
		int flag = sc.nextInt();
		
		while (flag != 1 &flag != 2 & flag != 3) {
			System.out.println("����� ��������. ��������� �����");
			requestAction();
		}
		return flag;
	}
	
	/*
	 * ����� ������������ ���������� ������� ����� � ������ (������� � �������� ��� ��������)
	 */
	public static int countVowel (String str) {
		
		int count = 0;
		
		Pattern pattern = Pattern.compile("[����������������������qeyuioajQEYUIOAJ]");
		Matcher text = pattern.matcher(str);
		
		while (text.find()) {
			count++;
		}
		return count;
	}
	
	/*
	 * ����� ����������� ������ � ������ ��������� ���� � ��������� �� �� �������� ������� ������������� ������� ����� (������� � �������� ��� ��������)
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
	 * ����� ��������� ������ �� ��������� ����� � � ������ ����� ������ ������� ����� ����������� � ������� �������
	 */
	public static String[] upperFirstVowelString(String str) {
		
		String[] words = str.split("\\s*(\\s|,|!|\\?|;|:|\\(|\\)|\\.+)\\s*");

		for (int i = 0; i < words.length; i++) {
			
			words[i] = upperFirstVowelWord(words[i]);
		}
		return words;
	}
	
	/*
	 * ����� ����������� ������ ����������� ������� ����� � ������ � ������ �������
	 */
	public static String upperFirstVowelWord (String word) {
		
		for (int k = 0; k < word.length(); k++) {
			
			char ch = word.charAt(k);
			String letter = Character.toString(ch);
			Pattern pattern = Pattern.compile("[����������������������qeyuioajQEYUIOAJ]");
			Matcher text = pattern.matcher(letter);
			
			if (text.find()) {
				word = word.substring(0,k) + letter.toUpperCase() + word.substring(k+1);
				return word;
			}
		}
		return word;
	}
}

