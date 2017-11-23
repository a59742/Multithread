package Experiment3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Utils {
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < n; ++i)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void toTxt(String str) {
		try {
			FileOutputStream fileOutput=new FileOutputStream(Test.URL);
			fileOutput.write(str.trim().getBytes("UTF-8"));
			fileOutput.flush();
			fileOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
