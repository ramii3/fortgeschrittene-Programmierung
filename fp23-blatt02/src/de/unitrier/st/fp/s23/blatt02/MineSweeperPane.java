package de.unitrier.st.fp.s23.blatt02;

import javafx.scene.layout.GridPane;

final class MineSweeperPane extends GridPane
{
    void setGame(Game game)
    {
        for (int i = 0; i < game.getColumns(); i++)
        {
            for (int j = 0; j < game.getRows(); j++)
            {
                FieldButton button = new FieldButton(game.getField(i, j));
                add(button, i, j);
            }
        }
    }

    MineSweeperPane(Game game)
    {
        setGame(game);
    }
}
