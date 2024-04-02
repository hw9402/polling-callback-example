package callback;

public class CallbackExampleWithThreads {

    public static void main(String[] args) {
        Worker worker = new Worker();


        // 1번 방법
        worker.doWork((String result) -> System.out.println("작업 결과: " + result));

        // 2번 방법
        Callback callback = new Callback() {
            @Override
            public void onComplete(String result) {
                System.out.println("작업 결과: " + result);
            }
        };

        worker.doWork(callback);


        System.out.println("메인 스레드는 다른 작업을 수행합니다.");
    }
}
