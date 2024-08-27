package de.unitrier.st.fp.s23.blatt09.client;

import de.unitrier.st.fp.s23.blatt09.common.*;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import static java.lang.System.err;
import static java.lang.System.out;

final class ChatWindow implements Runnable
{
    /*
    UI
     */

    private int clientId;
    private final VBox messageContainer = new VBox(5); // Spacing of 5 pixels between the child nodes, i.e., the text bubbles.
    private final BorderPane root;

    ChatWindow()
    {
        root = new BorderPane();

        final MenuBar menuBar = new MenuBar();
        final Menu menu = new Menu("File");
        menuBar.getMenus().add(menu);

        menu.getItems().add(new MenuItem("Backup"));
        menu.getItems().add(new MenuItem("Restore"));
        root.setTop(menuBar);
        final ScrollPane messageScrollPane = new ScrollPane(messageContainer);
        messageScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        messageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        messageScrollPane.setFitToWidth(true);
        messageScrollPane.setFitToHeight(true);
        messageContainer.setStyle("-fx-background-color: #f0e7de;");
        messageContainer.heightProperty().addListener(observable -> messageScrollPane.setVvalue(1D)); // Auto scroll down.

        final HBox hBox = new HBox();
        final TextField msgField = new TextField();
        final Button sendButton = new Button("Send");
        sendButton.setMinWidth(50);

        final Runnable sendEventHandler = () -> {
            final String text = msgField.getText();
            if (text != null && !text.isEmpty())
            {
                sendMessage(text);
                msgField.clear();
            }
        };

        sendButton.setOnAction(actionEvent -> sendEventHandler.run());

        msgField.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            final KeyCode keyCode = keyEvent.getCode();
            if (keyCode == KeyCode.ENTER)
            {
                sendEventHandler.run();
            }
        });

        msgField.setPrefWidth(250);
        hBox.getChildren().add(msgField);
        hBox.getChildren().add(sendButton);
        root.setCenter(messageScrollPane);
        root.setBottom(hBox);
    }

    void show(int currentWindowNr, int totalNrOfWindows)
    {
        final double prefSceneWidth = 300;
        final double prefSceneHeight = 400;

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double screenWidth = screenSize.getWidth();
        final double screenHeight = screenSize.getHeight();

        final int hPadding = 10;

        final int totalPadding = (totalNrOfWindows + 1) * hPadding;

        final double availableWidthForScenes = (screenWidth - totalPadding);

        final double sceneWidth = Math.min(availableWidthForScenes / totalNrOfWindows, prefSceneWidth);
        final double sceneHeight = Math.min(screenHeight, prefSceneHeight);

        final Scene scene = new Scene(root, sceneWidth, sceneHeight);
        final Stage stage = new Stage();
        stage.setTitle("User " + clientId);
        stage.setScene(scene);

        final double hOffset = (availableWidthForScenes - totalNrOfWindows * sceneWidth) / 2;
        stage.setX(hOffset + (currentWindowNr + 1) * hPadding + currentWindowNr * sceneWidth);
        stage.setY((screenHeight - sceneHeight) / 2);

        // TODO: on stage hidden -> disconnect from server.

        stage.show();
    }

    void displayMessage(final Message message)
    {
        if (message == null) return;
        final int senderId = message.getSenderId();
        final boolean isOwnMessage = senderId == clientId;
        final TextBubble finalTextBubble = new TextBubble(message, isOwnMessage);
        Platform.runLater(() -> messageContainer.getChildren().add(finalTextBubble));
    }

    /*
    Thread
     */

    @Override
    public void run()
    {
        // TODO: Wait for a new message. Upon reception, display it. Disconnect on thread exit.

    }

    /*
    Network
     */


    /**
     * Connect to the server on host 'host' at port 'port'.
     * The first message of the server is a Handshake object that contains
     * the clientId and former messages.
     *
     * @param host The host, i.e., the inet-address or ip-address where the server is reachable.
     * @param port The port on which the server is listening.
     * @return Whether the connection could be established.
     */
    boolean connect(final String host, final int port)
    {

        return false;
    }

    boolean connect(final int port)
    {
        return connect(null, port); // Host=null is equivalent with loopback interface, i.e., localhost or 127.0.0.1
    }

    void sendMessage(final String text)
    {
        // TODO: Send a chat message to the server.

    }

    void disconnect()
    {
        // TODO: Disconnect the socket and close any related resources.
    }
}
