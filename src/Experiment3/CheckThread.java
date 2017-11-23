package Experiment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CheckThread implements Runnable {

	Scanner in;
	int count = 0;
	List<Integer> nums;
	Set<Integer> primes;

	public CheckThread() {
		nums = new ArrayList<>();
		primes = new LinkedHashSet<>();
		try {
			in = new Scanner(new File(Test.URL));
			while (in.hasNext()) {
				int num = in.nextInt();
				nums.add(num);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (count < nums.size()) {
			int num = getNumFromTxt();
			if (Utils.isPrime(num)) {
				synchronized (this) {
					primes.add(num);
				}
			}
		}
	}

	public synchronized int getNumFromTxt() {
		if (count++ < nums.size()) {
			return nums.get(count - 1);
		}
		return -1;
	}
}
