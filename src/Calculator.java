import java.util.Scanner;

public class Calculator {
    private static double num1, num2, result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //재실행 체크
        String cnt1 = "y", cnt2 = "n";
        String operator = "";

        while (cnt1.equals("y")){
            if(cnt2.equals("n")){
                System.out.println("=== Java 계산기 ===");
                System.out.println("첫 번째 숫자를 입력하세요: ");
                num1 = scanner.nextInt();
                System.out.println("연산자를 입력하세요 (+, -, *, /): ");
                operator = scanner.next();
                System.out.println("두 번째 숫자를 입력하세요: ");
                num2 = scanner.nextInt();
            } else if(cnt2.equals("y")){
                num1 = result;
                System.out.println("연산자를 입력하세요 (+, -, *, /): ");
                operator = scanner.next();
                System.out.println("숫자를 입력하세요: ");
                num2 = scanner.nextInt();
            }

            cal(num1,operator,num2);
            System.out.println("결과: " + result);
            System.out.println("계속 계산하시겠습니까? (y/n): ");
            cnt1 = scanner.next().toLowerCase();

            if(cnt1.equals("y")){
                System.out.println("이전 결과(" + result + ")를 사용하시겠습니까? (y/n):");
                cnt2 = scanner.next().toLowerCase();
            }
        }

        System.out.println("계산기를 종료합니다.");
        scanner.close();
    }

    private static void cal(double n1, String operator, double n2) {
        switch (operator){
            case "+":
                result = (double) (n1 + n2);
                break;
            case "-":
                result = (double) (n1 - n2);
                break;
            case "*":
                result = (double) (n1 * n2);
                break;
            case "/":
                result = (double) (n1 / n2);
                break;
        }

    }

}