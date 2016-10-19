package dictionary;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Scanner sc = null;
	
	static void openHash(int tip) {
		int a;
		Dictionary h = null;
		while(true) {
			System.out.println("Выберите операцию:");
			System.out.println("1 - созидание новой таблицы;");
			System.out.println("2 - добавление элемента;");
			System.out.println("3 - поиск элемента;");
			System.out.println("4 - удаление элемента;");
			System.out.println("5 - очистка таблицы;");
			System.out.println("0 - выход;");
			if (sc.hasNextInt()) {
				a = sc.nextInt();
				sc.nextLine();
				if (a == 0) {
					System.out.println("Уже всё? ;(");
					return;
				}
				else if (a == 1) {
					System.out.println("Введите размер словаря (от 100 до 1000000):");
					int b = 100;
					if (sc.hasNextInt()) {
						b = sc.nextInt();
						sc.nextLine();
						if (b>=100 && b <=1000000) {
							if (tip == 1)
								h = new OpenHashTable(b);
							else 
								h = new ChainHashTable(b);
							System.out.println("Словарь создан.");
						}
						else {
							System.out.println("Введёное значение не входит в диапазон. Попробуйте снова.");
						}
					}
					else {
						System.out.println("Введёное значение не является целым числом. Попробуйте снова.");
						sc.nextLine();
					}
				}
				else if (a == 2) {
					if (h != null)
					{
						int mx = h.getSize() - h.getCount();
						if (mx == 0) {
							System.out.println("Словарь полон.");
						}
						else {
							System.out.println("Введите число добавляемых элементов (от 1 до "+ mx +"):");
							int b = 1;
							if (sc.hasNextInt()) {
								b = sc.nextInt();
								sc.nextLine();
								if (b >= 1 && b <= mx) {
									if (b==1) 
										System.out.println("Введите пару <ключ> <значение>:");
									else
										System.out.println("Введите "+ b +" пар <ключ> <значение>:");
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
												System.out.println("Считана и добавлена в словарь пара <"+s1+"> <"+s2+">");
											else
												System.out.println("Пара <"+s1+"> <"+s2+"> считана, но не добавлена.");
										}
										else {
											System.out.println("Произошла ошибка при считывании. Попробуйте снова.");
										}
									}
								}
								else {
									System.out.println("Введёное значение не входит в диапазон. Попробуйте снова.");
								}
							}
							else {
								System.out.println("Введёное значение не является целым числом. Попробуйте снова.");
								sc.nextLine();
							}
						}
					}
					else {
						System.out.println("Словарь не создан. Создайте словарь, выбрав первый пункт.");
					}
				}
				else if (a == 3) {
					if (h != null)
					{
						System.out.println("Введите ключ для поиска:");
						String s1 = new String();
						if (sc.hasNext())
						{
							s1 = sc.next();
							if (s1!=null) 
							{
								String s2 = h.find(s1);
								if (s2 != null) {
									System.out.println("Найдена пара <"+s1+"> <"+s2+">");
								}
								else {
									System.out.println("Пара по ключу <"+s1+"> не найдена.");
								}
							}
							else {
								System.out.println("Произошла ошибка при считывании. Попробуйте снова.");
							}
						}
						else {
							System.out.println("Не знаю, как, но введёное значение не является строкой. Попробуйте снова.");
							sc.nextLine();
						}
					}
					else {
						System.out.println("Словарь не создан. Создайте словарь, выбрав первый пункт.");
					}
				}
				else if (a == 4) {
					if (h != null)
					{
						int mx = h.getCount();
						if (mx == 0) {
							System.out.println("Словарь пуст.");
						}
						else {
							System.out.println("Введите число удаляемых элементов (от 1 до "+ mx +"):");
							int b = 1;
							if (sc.hasNextInt()) {
								b = sc.nextInt();
								sc.nextLine();
								if (b >= 1 && b <= mx) {
									if (b==1) 
										System.out.println("Введите <ключ>:");
									else
										System.out.println("Введите "+ b +" удаляемых строк типа <ключ>:");
									for(int i=1;i<=b;i++) {
										String s1 = new String();
										if (sc.hasNext())
											s1 = sc.next();
										if (s1!=null) {
											if (h.remove(s1))
												System.out.println("Удалён из словаря элемент с ключом <"+s1+">");
											else
												System.out.println("Элемент с ключом <"+s1+"> не удалён.");
										}
										else {
											System.out.println("Произошла ошибка при считывании. Попробуйте снова.");
										}
									}
								}
								else {
									System.out.println("Введёное значение не входит в диапазон. Попробуйте снова.");
								}
							}
							else {
								System.out.println("Введёное значение не является целым числом. Попробуйте снова.");
								sc.nextLine();
							}
						}
					}
					else {
						System.out.println("Словарь не создан. Создайте словарь, выбрав первый пункт.");
					}
				}
				else if (a == 5) {
					if (h != null)
					{
						h.clear();
						System.out.println("Словарь очищен.");
					}
					else {
						System.out.println("Словарь не создан. Создайте словарь, выбрав первый пункт.");
					}
				}
				else {
					System.out.println("Введёное число не является ни одним из вариантов.");
				}
			}
			else {
				System.out.println("Введёное значение не является целым числом. Попробуйте снова.");
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
			System.out.println("Выберите способ реализации словаря:");
			System.out.println("1 - с открытой адресацией;");
			System.out.println("2 - метод цепочек;");
			System.out.println("0 - выход из программы;");
			if (sc.hasNextInt()) {
				a = sc.nextInt();
				sc.nextLine();
				if (a == 0) {
					System.out.println("Уже всё? ;(");
					return;
				}
				else if (a == 1 || a == 2) {
					openHash(a);
				}
				else {
					System.out.println("Введёное число не является ни одним из вариантов.");
				}
			}
			else {
				System.out.println("Введёное значение не является целым числом. Попробуйте снова.");
				sc.nextLine();
			}
		}
	}

}
