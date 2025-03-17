import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketBookingSystem {
    private static int availableSeats = 5;
    private static final Lock lock = new ReentrantLock();

    static class TicketBookingThread extends Thread {
        private String customerType;

        public TicketBookingThread(String customerType, int priority) {
            this.customerType = customerType;
            setPriority(priority);
        }

        public void run() {
            lock.lock();
            try {
                if (availableSeats > 0) {
                    System.out.println(customerType + " booked a ticket. Seats left: " + (--availableSeats));
                } else {
                    System.out.println(customerType + " failed to book a ticket. No seats available.");
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TicketBookingThread vip1 = new TicketBookingThread("VIP Customer 1", Thread.MAX_PRIORITY);
        TicketBookingThread vip2 = new TicketBookingThread("VIP Customer 2", Thread.MAX_PRIORITY);
        TicketBookingThread regular1 = new TicketBookingThread("Regular Customer 1", Thread.NORM_PRIORITY);
        TicketBookingThread regular2 = new TicketBookingThread("Regular Customer 2", Thread.NORM_PRIORITY);
        TicketBookingThread regular3 = new TicketBookingThread("Regular Customer 3", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        regular3.start();
    }
}

