package week1.day2;

public class FindIntersection {
	public static void main(String[] args) {

		int[] a = { 3, 2, 11, 4, 6, 7 };
		int[] b = { 1, 2, 8, 4, 9, 7 };

		int len = a.length;
		int len1 = b.length;

		for (int i = 0; i <= len - 1; i++) {
			for (int j = 0; j <= len1 - 1; j++) {
				if (a[i] == b[j]) {
					System.out.println(a[i]);
					}
			}
			

		}
	}
}
