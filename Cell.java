package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Cell extends JButton {
    public static int player = 1;
    private final boolean setFocus = false;
    public static boolean win = false;

    private int row;
    private int col;
    public static Cell[][] virtualBoard = new Cell[6][7];

    private void setRow(String name) {
        String[] rowNumber;
        rowNumber = name.split("[A-Z]");
        this.row = Integer.parseInt(rowNumber[1]) - 1;
    }

    private void setCol(String name) {
        String[] col = name.split("[-0-9]");
        String colLetter = col[0];
        String[] indexes = {"A", "B", "C", "D", "E", "F", "G"};
        ArrayList<String> colLetters = new ArrayList<>(Arrays.asList(indexes));
        this.col = colLetters.indexOf(colLetter);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private boolean checkHorizontalWin(int row, int col) {
        int count = 1;

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row][col + i].getText())) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row][col + i].setBackground(Color.GREEN);
            }
            return true;
        }

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row][col - i].getText())) {
                   count ++;
                } else  {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row][col - i].setBackground(Color.GREEN);
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean checkVerticalWin(int row, int col) {
        int count = 0;

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row + i][col].getText())) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row + i][col].setBackground(Color.GREEN);
            }
            return true;
        }

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row - i][col].getText())) {
                    count ++;
                } else  {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row - i][col].setBackground(Color.GREEN);
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean checkDiagonalWin(int row, int col) {
        int count = 0;

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row + i][col + i].getText())) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row + i][col + i].setBackground(Color.GREEN);
            }
            return true;
        }

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row - i][col - i].getText())) {
                    count ++;
                } else  {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row - i][col - i].setBackground(Color.GREEN);
            }
            return true;
        }

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row - i][col + i].getText())) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row - i][col + i].setBackground(Color.GREEN);
            }
            return true;
        }

        try {
            for (int i = 1; i < 4; i++) {
                if (virtualBoard[row][col].getText().equals(virtualBoard[row + i][col - i].getText())) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 0;
        }

        if (count == 3) {
            virtualBoard[row][col].setBackground(Color.GREEN);
            for (int i = 1; i < 4; i++) {
                virtualBoard[row + i][col - i].setBackground(Color.GREEN);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isWin(int row, int col) {

        if (checkHorizontalWin(row, col)) {
            return true;
        }

        if (checkVerticalWin(row, col)) {
            return true;
        }

        if (checkDiagonalWin(row, col)) {
            return true;
        }

        return false;
    }

    public Cell (String name) {
        super(" ");
        setFocusPainted(setFocus);
        setBackground(Color.LIGHT_GRAY);
        super.setName("Button" + name);
        setRow(name);
        setCol(name);
        virtualBoard[getRow()][getCol()] = this;

        super.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!win) {
                    int selectedRow = getRow();
                    int selectedCol = getCol();
                    for (int i = 0; i < 6; i++) {
                        if (virtualBoard[i][selectedCol].getText().equals(" ")) {
                            if (player == 1) {
                                virtualBoard[i][selectedCol].setText("X");
                                win = isWin(i, selectedCol);
                                player++;
                                break;
                            } else {
                                virtualBoard[i][selectedCol].setText("O");
                                win = isWin(i, selectedCol);
                                player--;
                                break;
                            }
                        }
                    }
                }
            }
        });
    }
}
