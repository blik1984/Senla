package by.senla.java.task5;

/*
 * ���� ����� ���������, ���������� �������, �������� ����� �����������. 
 * ������� ����� 2 ��������� (������������, ��������� ��������� �� ����������): ����� (����� ��������) � �������� (����� ��������). 
 * �������� ��������. ����� ������� ���� � ������������ ���������� ��� ������ (����� ��������).
 * ����� �������� ���������, ������� ��������� ���� ������� ��������� ����� �������, ����� �������� ����� ������ ���� ������������.
 */

/*
 * ��� ������� ������������ ������������ ����������������
 * �������� ���������� �� �����
 */

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
	
	int size = 23;									//������ �����
	ArrayList<Thing> things = new ArrayList<>();
	
	things.add(new Thing(3,5));
	things.add(new Thing(3,9));
	things.add(new Thing(2,5));
	things.add(new Thing(3,5));
	things.add(new Thing(3,35));
	things.add(new Thing(3,5));
	things.add(new Thing(2,1));
	things.add(new Thing(3,5));
	things.add(new Thing(12,1));
	things.add(new Thing(2,88));
	things.add(new Thing(13,5));
	things.add(new Thing(3,1));
	things.add(new Thing(9,5));
	things.add(new Thing(2,5));
	things.add(new Thing(3,15));
	things.add(new Thing(75,1));
	
	ArrayList<Integer> maxKit = new ArrayList<>();
	maxKit = searchMaxKit(things, size);
	
	print (maxKit);
	
	}
	
	public static ArrayList<Integer> searchMaxKit (ArrayList<Thing>things, int size) {
		
		ArrayList<Integer> result = new ArrayList<>();
		things = checkAllSizeInList(things, size); 		//������� ��������, ������� ���������� ������ �����
		int[][][] cost = new int [things.size()][size][things.size()];		//������� ��� �������� ��������� ������,
															//������ - ������ �����, ������� - ��������� ������
		for (int i = 1; i <= size; i++) {
			int thingSize = things.get(0).getSize();
			int thingCost = things.get(0).getPrice();
			if ( thingSize <= i) {
				cost[0][i-1][0] = thingCost;
				cost[0][i-1][1] = things.get(0).getNumber();
			}
		}
		for (int k = 0; k < things.size()-1; k++) {			//������� ���������
			for (int m = 0; m < size; m++) {				//������� �������� �������
				if (things.get(k+1).getSize() > (m+1)) {	//���� ������� �� ������ � ������ ������ �������, �� ��������� ���������� �����
					cost[k+1][m][0] = cost[k][m][0];
					for(int y = 1; y < cost[k][m].length; y++) {
						cost[k+1][m][y] = cost[k][m][y];
					}
				} else if (things.get(k+1).getSize() == (m+1)) {	//���� ������� ����� ������� �������, 
																	//�� ���������� ��������� � ���������� ��������� � ������ �����
					if (things.get(k+1).getPrice() > cost[k][m][0]) {	//���� ���� �������� �������� ������ ����������� ������, �� �������� �����
						cost[k+1][m][0] = things.get(k+1).getPrice();
						for(int y = 1; y < cost[k][m].length; y++) {	//�������� ������ ���� ��������� � ������
							cost[k+1][m][y] = 0;
							}
						cost[k+1][m][1] = things.get(k+1).getNumber();		//������ � ����� ����� ������ ��������
					}
				}else if (things.get(k+1).getSize() < (m+1)) {					//���� ������ �������� ������ ������, 
																				//����� �������� ����� ���������� ������� � 
																				//������ �������� �������� �� ���������� 
																				//����������� ������� �����
						
						int costFree = cost[k][m - things.get(k+1).getSize()][0];	//���� ���������� �����
						int costNew = things.get(k+1).getPrice() + costFree;
						if ( costNew > cost[k][m][0]) {							//���� ����� ��������� ������ ���������� - ��������� ����� �����
							cost[k+1][m][0] = costNew;
							for(int y = 1; y < cost[k][m].length; y++) {
								while(cost[k][m - things.get(k+1).getSize()][y] != 0) {
									cost[k+1][m][y] = cost[k][m - things.get(k+1).getSize()][y];
									y++;
								}
								cost[k+1][m][y] = things.get(k+1).getNumber();
								y = cost[k][m].length;
							}
						} else {												//����� ��������� ���������� �����
							cost[k+1][m][0] = cost [k][m][0];
							for(int y = 1; y < cost[k][m].length; y++) {
								cost[k+1][m][y] = cost[k][m][y];
							}
						}
					}
				}
			}
			result.add(cost[things.size()-1][size - 1][0]);						//��������� ������, � ������� ������ �������� - ������������ ���������
			for(int i = 1; i < cost[things.size() - 1][size - 1].length; i++) { //����������� - ������ ��������� � ������
				result.add(cost[things.size() - 1][size - 1][i]);
			}
		return result;
	}
	
	/*
	 * ����� ������� �� ������ ��������, ������� ���� �� ���� ������ �����
	 */
	public static ArrayList<Thing> checkAllSizeInList (ArrayList<Thing> list, int size){
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSize() > size) {
				list.remove(i);
				i--;
			}
		}
		return list;
	}
	
	public static void print (ArrayList<Integer> maxKit) {
		
		System.out.println("������������ ��������� ��������� ��������� - " + maxKit.get(0) + ", � ����� ������ ��������� ��������: ");
		for (int i = 1; i < maxKit.size(); i++) {
			if(maxKit.get(i) != 0) {
				System.out.print (maxKit.get(i) + ", ");
			}
		}
	}
}
