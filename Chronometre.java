package Timerchronometre;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Chronometre extends JFrame {
    private JLabel label;
    private Timer timer;
    private int seconds;

    public Chronometre() {
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("chrono: 00:00:00");
        add(label, BorderLayout.CENTER);

        JButton startButton = new JButton("Commencer");
        JButton restartButton = new JButton("Recommencer");
        JButton pauseButton = new JButton("Pause");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(restartButton);
        buttonPanel.add(pauseButton);

        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartTimer();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseTimer();
            }
        });

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                updateLabel();
            }
        });

        setVisible(true);
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
        label.setText("Temps écoulé: " + time);
    }

    public static void main(String[] args) {
        new Chronometre();
    }
}
