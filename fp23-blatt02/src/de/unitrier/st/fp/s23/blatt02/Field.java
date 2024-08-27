package de.unitrier.st.fp.s23.blatt02;

import javafx.scene.control.Alert;

import javax.swing.*;

final class Field
{
    private int x, y;
    private Game game;
    private boolean isBomb;
    private boolean isHidden = true;
    private int neighborsWithBombs = 0;
    private FieldButton button;
    static boolean isOver=false;

    Field(Game game, int x, int y)
    {
        this.game = game;
        this.x = x;
        this.y = y;
        this.isBomb = Math.random() < 0.03;

    }

    FieldButton getButton()
    {
        return this.button;
    }

    void setButton(FieldButton b)
    {
        this.button = b;
    }

    boolean isBomb() { return isBomb; }

    boolean isHidden() { return isHidden; }

    void unHide() {
        if(!isOver) {
            if (isHidden) {
                isHidden = false;
                game.increaseUnhiddenFields();
            }
            button.setText(isBomb() ? "B" : (neighborsWithBombs > 0 ? "" + neighborsWithBombs : " "));
            button.setStyle(isBomb() ? "-fx-background-color: tomato" : "-fx-background-color: lightgreen");
        }
    }

    void computeNeighborsWithBombs()
    {
        if (isBomb)
        {
            Field tmp;
            tmp = n();
            if (tmp != null) tmp.neighborsWithBombs++;
            tmp = s();
            if (tmp != null) tmp.neighborsWithBombs++;
            tmp = w();
            if (tmp != null) tmp.neighborsWithBombs++;
            tmp = o();
            if (tmp != null) tmp.neighborsWithBombs++;
            tmp = no();
            if (tmp != null) tmp.neighborsWithBombs++;
            tmp = nw();
            if (tmp != null) tmp.neighborsWithBombs++;
            tmp = so();
            if (tmp != null) tmp.neighborsWithBombs++;
            tmp = sw();
            if (tmp != null) tmp.neighborsWithBombs++;
        }
    }

    void checkField()
    {
        if (isBomb&&!isOver) {
            unHide();
            JOptionPane.showMessageDialog(null, "you lost");
            isOver = true;

        } else {
            if (!isOver) {
                if (neighborsWithBombs > 0) {
                    unHide();

                } else {
                    propagate();
                }
                if (game.allUnhidden()) {
                    System.out.println("You won!");
                    JOptionPane.showMessageDialog(null, "you won");
                    isOver = true;

                }
            }
        }

    }

    private void propagate()
    {
        if (neighborsWithBombs > 0) unHide();
        if (!isHidden) return;
        unHide();
        Field tmp;
        tmp = n();
        if (tmp != null) tmp.propagate();
        tmp = s();
        if (tmp != null) tmp.propagate();
        tmp = w();
        if (tmp != null) tmp.propagate();
        tmp = o();
        if (tmp != null) tmp.propagate();
        tmp = no();
        if (tmp != null) tmp.propagate();
        tmp = nw();
        if (tmp != null) tmp.propagate();
        tmp = so();
        if (tmp != null) tmp.propagate();
        tmp = sw();
        if (tmp != null) tmp.propagate();
    }

    // auxiliary function to access neighbor at north, south, etc

    private Field n()
    {
        return (y == 0 ? null : game.getField(x, y - 1));
    }

    private Field s()
    {
        return (y == game.getRows() - 1 ? null : game.getField(x, y + 1));
    }

    private Field w()
    {
        return (x == 0 ? null : game.getField(x - 1, y));
    }

    private Field o()
    {
        return (x == game.getColumns() - 1 ? null : game.getField(x + 1, y));
    }

    private Field no()
    {
        Field f = n();
        if (f != null) { f = f.o(); }
        return f;
    }

    private Field so()
    {
        Field f = s();
        if (f != null) { f = f.o(); }
        return f;
    }

    private Field nw()
    {
        Field f = n();
        if (f != null) { f = f.w(); }
        return f;
    }

    private Field sw()
    {
        Field f = s();
        if (f != null) { f = f.w(); }
        return f;
    }
}
