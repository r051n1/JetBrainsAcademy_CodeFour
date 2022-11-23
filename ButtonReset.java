package four;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonReset extends JButton {

    private void reset() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cell.virtualBoard[i][j].setText(" ");
                Cell.virtualBoard[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
        Cell.player = 1;
        Cell.win = false;
    }

    public ButtonReset() {
        super("Reset");
        super.setName("ButtonReset");
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reset();
            }
        });
    }
}