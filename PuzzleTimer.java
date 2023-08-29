import java.util.Timer;
import java.util.TimerTask;

public class PuzzleTimer {
    private Timer timer;
    private int secondE;

    public PuzzleTimer() {
        timer = new Timer();
        secondE = 0;
    }

    public void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondE++;
                System.out.println("Time over: " + secondE + " seconds");
            }
        }, 1000, 1000); // Schedule the task to run every 1 second
    }

    public void stopTimer() {
        timer.cancel();
    }

    public int getsecondE() {
        return secondE;
    }
}