import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class DigitalClockGUI extends JFrame {
    private JLabel clockLabel;
    private ClockDisplay clock;

    public DigitalClockGUI() {
        LocalTime now = LocalTime.now();
        clock = new ClockDisplay(now.getHour(), now.getMinute());

        setTitle("Digital Clock");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        clockLabel = new JLabel(clock.getTime(), SwingConstants.CENTER);
        clockLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
        add(clockLabel, BorderLayout.CENTER);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.updateTime();  
                clockLabel.setText(clock.getTime());  
            }
        });

        timer.start();  

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DigitalClockGUI();
            }
        });
    }
}
