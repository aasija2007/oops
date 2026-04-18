import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TimerLogic timer = new TimerLogic();

        // Run the timer logic in a separate thread
        Thread timerThread = new Thread(timer);
        timerThread.setDaemon(true); // runs in background
        timerThread.start();

        Scanner sc = new Scanner(System.in);
        System.out.println("===== OOP Console Timer =====");
        System.out.println("Commands: start, pause, reset, exit");

        while (true) {
            System.out.print("\nEnter command: ");
            String command = sc.nextLine().trim().toLowerCase();

            switch (command) {
                case "start":
                    timer.start();
                    break;
                case "pause":
                    timer.pause();
                    break;
                case "reset":
                    timer.reset();
                    break;
                case "exit":
                    System.out.println("\nExiting Timer...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid command! Use: start, pause, reset, exit");
            }
        }
    }
}
class TimerLogic implements Runnable {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private boolean running = false;

    // Start the timer
    public void start() {
        running = true;
    }

    // Pause the timer
    public void pause() {
        running = false;
    }

    // Reset the timer
    public void reset() {
        running = false;
        hours = 0;
        minutes = 0;
        seconds = 0;
        display();
    }

    // Increment the timer by 1 second
    private void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
    }

    // Display current timer in HH:MM:SS format
    private void display() {
        System.out.printf("\r%02d:%02d:%02d", hours, minutes, seconds);
        System.out.flush();
    }

    // Runnable method for background timer thread
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                if (running) {
                    tick();
                    display();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

