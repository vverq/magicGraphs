package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Visualizer extends JPanel {
    private AlgorithmVisualizer algorithmVisualizer;
    private final java.util.Timer m_timer = initTimer();
    private static java.util.Timer initTimer()
    {
        java.util.Timer timer = new Timer("events generator", true);
        return timer;
    }

    public Visualizer(AlgorithmVisualizer algorithmVisualizer) {
        this.algorithmVisualizer = algorithmVisualizer;
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onRedrawEvent();
            }
        }, 0, 100);
    }

    private void onRedrawEvent()
    {
        EventQueue.invokeLater(this::repaint);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        algorithmVisualizer.paint(g, getWidth() / 2, getHeight() / 2);
    }
}
