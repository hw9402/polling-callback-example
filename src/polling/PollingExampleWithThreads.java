package polling;

import java.util.Scanner;

public class PollingExampleWithThreads {

    private static String input = "";

    public static void main(String[] args) {
        new Thread(PollingExampleWithThreads::eventListener).start();
        new Thread(PollingExampleWithThreads::readKeyboardInput).start();
    }

    private static void eventListener() {
        String temp = "";

        while (true) {
            System.out.println("이벤트를 확인 중...");

            if (!temp.equals(input)) {
                System.out.println("input 변경~~!");
                System.out.println("변경된 input: " + input);
                temp = input;
            }

            if (input.equals("q")) {
                System.out.println("이벤트 감지 종료~~");
                break;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readKeyboardInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("키보드 입력 종료~~");
                break;
            }
        }
    }
}
