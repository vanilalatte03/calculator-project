import java.util.*;

public class Calculator {
    private static double num1, num2, result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //재실행 체크
        String cnt1 = "y", cnt2 = "n";
        String operator = "";
        System.out.println("=== Java 계산기 ===");

        while (cnt1.equals("y")){
            try {
                if(cnt2.equals("n")){
                    System.out.println("첫 번째 숫자를 입력하세요: ");
                    num1 = scanner.nextDouble();
                    System.out.println("연산자를 입력하세요 (+, -, *, /): ");
                    operator = scanner.next();
                    System.out.println("두 번째 숫자를 입력하세요: ");
                    num2 = scanner.nextDouble();
                } else if(cnt2.equals("y")){
                    num1 = result;
                    System.out.println("연산자를 입력하세요 (+, -, *, /): ");
                    operator = scanner.next();
                    System.out.println("숫자를 입력하세요: ");
                    num2 = scanner.nextDouble();
                }

                cal(num1,operator,num2);
                System.out.println("결과: " + result);
                System.out.println("계속 계산하시겠습니까? (y/n): ");
                cnt1 = scanner.next().toLowerCase();

                if(cnt1.equals("y")){
                    System.out.println("이전 결과(" + result + ")를 사용하시겠습니까? (y/n):");
                    cnt2 = scanner.next().toLowerCase();
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }

        }

        System.out.println("계산기를 종료합니다.");
        scanner.close();
    }

    //계산 메서드
    private static void cal(double n1, String operator, double n2) {
        switch (operator){
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }
                result = n1 / n2;
                break;
            default:
                System.out.println("지원하지 않는 연산자입니다.");
        }

    }

}