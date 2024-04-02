package callback;

class Worker {

    void doWork(Callback callback) {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            callback.onComplete("작업 완료!");
        }).start();
    }
}
