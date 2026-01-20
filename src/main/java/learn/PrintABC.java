package learn;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/24
 */
public class PrintABC {

    public static void main(String[] args) {

        Printer printer = new Printer();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printer.printA();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printer.printB();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printer.printC();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }


    public static final class Printer {
        public volatile Integer state = 0;
        private final Object lock = Printer.class;

        private void printA() throws Exception {
            synchronized (lock) {
                while (state != 0) {
                    lock.wait();
                }
                System.out.print("A");
                state = 1;
                lock.notifyAll();
            }
        }

        private void printB() throws Exception {
            synchronized (lock) {
                while (state != 1) {
                    lock.wait();
                }
                System.out.print("B");
                state = 2;
                lock.notifyAll();
            }
        }

        private void printC() throws Exception {
            synchronized (lock) {
                while (state != 2) {
                    lock.wait();
                }
                System.out.print("C");
                state = 0;
                lock.notifyAll();
            }
        }
    }
}
