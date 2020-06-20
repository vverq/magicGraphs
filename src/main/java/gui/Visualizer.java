package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Visualizer extends JPanel {
    private AlgorithmVisualizer algorithmVisualizer;
    private final Timer m_timer = initTimer();
    private static Timer initTimer()
    {
        Timer timer = new Timer("events generator", true);
        return timer;
    }
    PropertyChangeSupport support;

    Visualizer(AlgorithmVisualizer algorithmVisualizer) {
        support = new PropertyChangeSupport(this);
        this.algorithmVisualizer = algorithmVisualizer;
    }

    void start() {
        m_timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                onRedrawEvent();
            }
        }, 0, 100);
        algorithmVisualizer.start();
    }

    private void onRedrawEvent()
    {
        EventQueue.invokeLater(this::repaint);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage image = (BufferedImage)createImage(
                getWidth(), getHeight());
        Graphics2D g2 = image.createGraphics();
        super.paint(g2);
        algorithmVisualizer.paint(g2, getWidth() / 2, getHeight() / 2);
        g.drawImage(image, 0, 0, this);
        if (!algorithmVisualizer.isFinished()) {
            support.firePropertyChange("image", null, image);
        }
    }
}
