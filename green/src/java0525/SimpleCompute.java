package java0525;
import java.util.Scanner;

public class SimpleCompute {
	public static void main(String[] args) {
		
	   int number1, number2, sum, diff, product;
	// �������� �����Ѵ� number1, number2, sum, diff, product	

	Scanner scan = new Scanner(System.in);
	System.out.println("ù�� ° ������ �Է��ϼ���.");
	number1 = scan.nextInt();
	System.out.println("�ι� ° ������ �Է��ϼ���.");
	number2 = scan.nextInt();
	sum = number1 + number2;
	diff = number1 - number2;
	product = number1 * number2;
	
	System.out.printf("%d %d %d", sum, diff, product);


   }
}
//��°��
//ù ��° ������ �Է��ϼ���: 50
//�� ��° ������ �Է��ϼ���: 30
//�� = 80
//�� = 20
//�� = 1500