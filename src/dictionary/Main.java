package dictionary;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Scanner sc = null;
	
	static void openHash(int tip) {
		int a;
		Dictionary h = null;
		while(true) {
			System.out.println("�������� ��������:");
			System.out.println("1 - ��������� ����� �������;");
			System.out.println("2 - ���������� ��������;");
			System.out.println("3 - ����� ��������;");
			System.out.println("4 - �������� ��������;");
			System.out.println("5 - ������� �������;");
			System.out.println("0 - �����;");
			if (sc.hasNextInt()) {
				a = sc.nextInt();
				sc.nextLine();
				if (a == 0) {
					System.out.println("��� ��? ;(");
					return;
				}
				else if (a == 1) {
					System.out.println("������� ������ ������� (�� 100 �� 1000000):");
					int b = 100;
					if (sc.hasNextInt()) {
						b = sc.nextInt();
						sc.nextLine();
						if (b>=100 && b <=1000000) {
							if (tip == 1)
								h = new OpenHashTable(b);
							else 
								h = new ChainHashTable(b);
							System.out.println("������� ������.");
						}
						else {
							System.out.println("������� �������� �� ������ � ��������. ���������� �����.");
						}
					}
					else {
						System.out.println("������� �������� �� �������� ����� ������. ���������� �����.");
						sc.nextLine();
					}
				}
				else if (a == 2) {
					if (h != null)
					{
						int mx = h.getSize() - h.getCount();
						if (mx == 0) {
							System.out.println("������� �����.");
						}
						else {
							System.out.println("������� ����� ����������� ��������� (�� 1 �� "+ mx +"):");
							int b = 1;
							if (sc.hasNextInt()) {
								b = sc.nextInt();
								sc.nextLine();
								if (b >= 1 && b <= mx) {
									if (b==1) 
										System.out.println("������� ���� <����> <��������>:");
									else
										System.out.println("������� "+ b +" ��� <����> <��������>:");
									for(int i=1;i<=b;i++) {
										String s1 = new String();
										String s2 = new String();
										if (sc.hasNext())
											s1 = sc.next();
										if (sc.hasNext())
											s2 = sc.next();
										if (s1!=null && s2!=null) {
											DictionaryItem it = new DictionaryItem();
											it.key = s1;
											it.value = s2;
											if (h.add(it))
												System.out.println("������� � ��������� � ������� ���� <"+s1+"> <"+s2+">");
											else
												System.out.println("���� <"+s1+"> <"+s2+"> �������, �� �� ���������.");
										}
										else {
											System.out.println("��������� ������ ��� ����������. ���������� �����.");
										}
									}
								}
								else {
									System.out.println("������� �������� �� ������ � ��������. ���������� �����.");
								}
							}
							else {
								System.out.println("������� �������� �� �������� ����� ������. ���������� �����.");
								sc.nextLine();
							}
						}
					}
					else {
						System.out.println("������� �� ������. �������� �������, ������ ������ �����.");
					}
				}
				else if (a == 3) {
					if (h != null)
					{
						System.out.println("������� ���� ��� ������:");
						String s1 = new String();
						if (sc.hasNext())
						{
							s1 = sc.next();
							if (s1!=null) 
							{
								String s2 = h.find(s1);
								if (s2 != null) {
									System.out.println("������� ���� <"+s1+"> <"+s2+">");
								}
								else {
									System.out.println("���� �� ����� <"+s1+"> �� �������.");
								}
							}
							else {
								System.out.println("��������� ������ ��� ����������. ���������� �����.");
							}
						}
						else {
							System.out.println("�� ����, ���, �� ������� �������� �� �������� �������. ���������� �����.");
							sc.nextLine();
						}
					}
					else {
						System.out.println("������� �� ������. �������� �������, ������ ������ �����.");
					}
				}
				else if (a == 4) {
					if (h != null)
					{
						int mx = h.getCount();
						if (mx == 0) {
							System.out.println("������� ����.");
						}
						else {
							System.out.println("������� ����� ��������� ��������� (�� 1 �� "+ mx +"):");
							int b = 1;
							if (sc.hasNextInt()) {
								b = sc.nextInt();
								sc.nextLine();
								if (b >= 1 && b <= mx) {
									if (b==1) 
										System.out.println("������� <����>:");
									else
										System.out.println("������� "+ b +" ��������� ����� ���� <����>:");
									for(int i=1;i<=b;i++) {
										String s1 = new String();
										if (sc.hasNext())
											s1 = sc.next();
										if (s1!=null) {
											if (h.remove(s1))
												System.out.println("����� �� ������� ������� � ������ <"+s1+">");
											else
												System.out.println("������� � ������ <"+s1+"> �� �����.");
										}
										else {
											System.out.println("��������� ������ ��� ����������. ���������� �����.");
										}
									}
								}
								else {
									System.out.println("������� �������� �� ������ � ��������. ���������� �����.");
								}
							}
							else {
								System.out.println("������� �������� �� �������� ����� ������. ���������� �����.");
								sc.nextLine();
							}
						}
					}
					else {
						System.out.println("������� �� ������. �������� �������, ������ ������ �����.");
					}
				}
				else if (a == 5) {
					if (h != null)
					{
						h.clear();
						System.out.println("������� ������.");
					}
					else {
						System.out.println("������� �� ������. �������� �������, ������ ������ �����.");
					}
				}
				else {
					System.out.println("������� ����� �� �������� �� ����� �� ���������.");
				}
			}
			else {
				System.out.println("������� �������� �� �������� ����� ������. ���������� �����.");
				sc.nextLine();
			}
		}
	}
	static void notOpenHash() {
	}
	public static void main(String[] args) throws IOException {
		int a;
		sc = new Scanner(System.in);
		while(true) {
			System.out.println("�������� ������ ���������� �������:");
			System.out.println("1 - � �������� ����������;");
			System.out.println("2 - ����� �������;");
			System.out.println("0 - ����� �� ���������;");
			if (sc.hasNextInt()) {
				a = sc.nextInt();
				sc.nextLine();
				if (a == 0) {
					System.out.println("��� ��? ;(");
					return;
				}
				else if (a == 1 || a == 2) {
					openHash(a);
				}
				else {
					System.out.println("������� ����� �� �������� �� ����� �� ���������.");
				}
			}
			else {
				System.out.println("������� �������� �� �������� ����� ������. ���������� �����.");
				sc.nextLine();
			}
		}
	}

}
