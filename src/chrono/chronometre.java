package chrono;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class chronometre extends JFrame {
    private JLabel label;
    private Timer timer;
    private int seconds;

    public chronometre() {
        initializeUI();
        initializeTimer();
    }

    private void initializeUI() {
        setTitle("Chronomètre");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Temps : 00:00:00");
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        add(label, BorderLayout.CENTER);

        JButton startButton = new JButton("START");
        JButton restartButton = new JButton("RESTART");
        JButton pauseButton = new JButton("PAUSE");

        startButton.addActionListener(e -> startTimer());
        restartButton.addActionListener(e -> restartTimer());
        pauseButton.addActionListener(e -> pauseTimer());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(restartButton);
        buttonPanel.add(pauseButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initializeTimer() {
        timer = new Timer(1000, e -> {
            seconds++;
            updateLabel();
        });
    }

    private void startTimer() {
        timer.start();
    }

    private void restartTimer() {
        timer.stop();
        seconds = 0;
        updateLabel();
    }

    private void pauseTimer() {
        timer.stop();
    }

    private void updateLabel() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
        label.setText("Temps : " + time);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new chronometre().setVisible(true));
    }
}
