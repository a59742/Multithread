package Experiment3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static final String PATH = Test.class.getPackage().getName().replace(".", "\\");
	public static final String URL = System.getProperty("user.dir") + "\\src\\" + PATH + "\\" + "numbers" + ".txt";
	static Scanner in = null;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ�ж�������:");
		String numbers = input.nextLine();
		Utils.toTxt(numbers);

		System.out.println("¼��ɹ���");
		ExecutorService es = Executors.newFixedThreadPool(10);
		Thread[] threads = new Thread[10];
		CheckThread ct = new CheckThread();
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(ct);
			es.execute(threads[i]);
		}
		es.shutdown();

		while (true) {
			if (es.isTerminated()) {
				System.out.println("�ж���ɣ��Ƿ���в�ѯ��(Y or N)");
				String choice = input.nextLine();
				if (choice.equalsIgnoreCase("y")) {
					System.out.println("�ж�Ϊ������������:");
					Iterator<Integer> iterator = ct.primes.iterator();
					while(iterator.hasNext()){
						System.out.print(iterator.next() + " ");
					}
				} else {
					System.out.println("���������");
					System.exit(0);
				}
				break;
			}
		}
	}
}
