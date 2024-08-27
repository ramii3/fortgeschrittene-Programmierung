package de.unitrier.st.fp.s23.blatt09.client;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public final class ChatClientFX extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        int nrOfWindows;
        final Parameters parameters = getParameters();
        final List<String> raw = parameters.getRaw();
        if (raw.size() < 1)
        {
            nrOfWindows = 3;
        } else
        {
            try
            {
                nrOfWindows = Integer.parseInt(raw.get(0));
            } catch (NumberFormatException e)
            {
                nrOfWindows = 3;
            }
        }

        int port = 3305;

        for (int i = 0; i < nrOfWindows; i++)
        {
            final ChatWindow chatWindow = new ChatWindow();
            if (chatWindow.connect(port))
            {
                chatWindow.show(i, nrOfWindows);
            } else
            {
                final Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Could not connect to a server on port " + port + ".");
                alert.setContentText("Make sure a server on port " + port + " is running and is listening for connections.");
                alert.showAndWait();
                break;
            }
        }
    }

    /**
     * Opens an input dialog to ask the user for a port.
     *
     * @return The server's port.
     */
    private int promptPort() throws NumberFormatException
    {
        // TODO: Get the port from the user.
        return -1;
    }
}
