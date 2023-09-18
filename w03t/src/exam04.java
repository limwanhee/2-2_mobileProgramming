public class exam04 {
	public static void main(String args[]) {
		int first[] = new int[3];
		for (int i = 0; i < first.length; i++) {
			first[i] = 10 * i;
		}
		for(int i: first) {
			System.out.println("i = " + i);
		}
		String second[] = { "하나", "둘", "셋" };
		for (String str : second) {
			System.out.println(str);
		}
		int j = 0;
		while (j < first.length) {
			System.out.println(first[j]);
			j++;
		}
	}
}