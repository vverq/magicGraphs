package gui;

import java.awt.*;

public interface AlgorithmVisualizer {
    void paint(Graphics g, int centerX, int centerY);
    boolean isFinished();
    void start();
}
