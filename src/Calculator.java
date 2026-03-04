import java.util.*;

public class Calculator {
    private static Double result;
    private static final List<Double> history = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int menu = 1;
        try {
            while (menu != 0){
                System.out.println("\n=== 계산기 메뉴 ===");
                System.out.println("1. 계산하기");
                System.out.println("2. 계산 이력 보기");
                System.out.println("3. 이력 지우기");
                System.out.println("0. 종료");
                System.out.print("선택: ");
                menu = scanner.nextInt();

                switch (menu){
                    case 1: //계산기
                        calMain();
                        break;
                    case 2: //이력 확인
                        printHistory();
                        break;
                    case 3: //이력 삭제
                        clearHistory();
                        break;
                    case 0: //프로그램 종료
                        System.out.println("계산기를 종료합니다.");
                        scanner.close();
                        return;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
            scanner.nextLine();
        }

    }

    //계산기
    private static void calMain(){
        double num1 = 0, num2 = 0;
        String cnt1 = "y", cnt2 = "n";
        String operator = "";
        System.out.println("=== Java 계산기 ===");

        while (cnt1.equals("y")){
            try {
                if(cnt2.equals("n")){
                    System.out.println("첫 번째 숫자를 입력하세요: ");
                    num1 = scanner.nextDouble();
                    System.out.println("연산자를 입력하세요 (+, -, *, /, %, ^, sqrt): ");
                    operator = scanner.next();
                    if (!operator.equals("sqrt")) {
                        System.out.println("두 번째 숫자를 입력하세요: ");
                        num2 = scanner.nextDouble();
                    } else {
                        num2 = 0;
                    }
                } else if(cnt2.equals("y")){ //이전 결과 이용
                    num1 = result;
                    System.out.println("연산자를 입력하세요 (+, -, *, /, %, ^, sqrt): ");
                    operator = scanner.next();
                    if (!operator.equals("sqrt")) {
                        System.out.println("숫자를 입력하세요: ");
                        num2 = scanner.nextDouble();
                    } else {
                        num2 = 0;
                    }
                }

                cal(num1,operator,num2);

                System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);
                history.add(result);
                while (true) {
                    System.out.println("계속 계산하시겠습니까? (y/n): ");
                    cnt1 = scanner.next().toLowerCase();

                    if (cnt1.equals("y") || cnt1.equals("n")) {
                        break;
                    }
                    System.out.println("잘못된 입력입니다. 'y' 또는 'n'만 입력해주세요.");
                }

                if (cnt1.equals("y")) {
                    while (true) {
                        System.out.println("이전 결과(" + result + ")를 사용하시겠습니까? (y/n):");
                        cnt2 = scanner.next().toLowerCase();

                        if (cnt2.equals("y") || cnt2.equals("n")) {
                            break;
                        }

                        System.out.println("잘못된 입력입니다. 'y' 또는 'n'만 입력해주세요.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
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
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = n1 / n2;
                break;
            case "%":
                if (n2 == 0) {
                    throw new ArithmeticException("0으로 나눈 나머지는 구할 수 없습니다.");
                }
                result = n1 % n2;
                break;
            case "^":
                result = Math.pow(n1, n2);
                break;
            case "sqrt":
                if (n1 < 0) {
                    throw new IllegalArgumentException("음수의 제곱근은 실수 범위에서 구할 수 없습니다.");
                }
                result = Math.sqrt(n1);
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

    }

    //계산 기록 출력
    private static void printHistory() {
        System.out.println("=== 계산 이력 ===");
        if (history.isEmpty()) {
            System.out.println("이력이 없습니다.");
            return;
        }

        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    //계산 기록 삭제
    private static void clearHistory() {
        history.clear();
        System.out.println("이력을 모두 삭제했습니다.");
    }

}