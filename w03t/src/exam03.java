public class exam03 {
	public static void main(String args[]) {
		int third[] = {1, 2, 3, 4};
		System.out.println("Third array length = [" + third.length + "]");

		int count = 85;
		if (count >= 90) {
			System.out.println("if문: 합격 (장학생)");
		}
		else if (count >= 60) {
			System.out.println("if문: 합격");
		}

		else {
			System.out.println("if문: 불합격");
		}

		int jumsu = (count / 10) * 10;
		switch (jumsu) {
		case 100:
		case 90:
			System.out.println("switch문 : 합격(장학생)");
			break;

		case 80:
		case 70:
		case 60:
			System.out.println("switch문 : 합격");
			break;

		default:
			System.out.println("switch문 : 불합격");
		}		
	}
}