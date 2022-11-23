package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ConnectFour extends JFrame {

    public final int ROW = 6;
    public final int COLS = 7;

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Connect Four");

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(ROW, COLS));

        for (int i = ROW; i > 0; i--) {
            gridPanel.add(new Cell("A" + i));
            gridPanel.add(new Cell("B" + i));
            gridPanel.add(new Cell("C" + i));
            gridPanel.add(new Cell("D" + i));
            gridPanel.add(new Cell("E" + i));
            gridPanel.add(new Cell("F" + i));
            gridPanel.add(new Cell("G" + i));
        }

        setLayout(new BorderLayout());
        add(gridPanel, BorderLayout.CENTER);

        JPanel resetPanel = new JPanel();
        resetPanel.add(new ButtonReset());
        add(resetPanel, BorderLayout.SOUTH);
    }
}