package de.unitrier.st.fp.s23.blatt09.client;

import de.unitrier.st.fp.s23.blatt09.common.Message;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

class TextBubble extends HBox
{
    TextBubble(final Message message, final boolean isOwnMessage)
    {
        final Pos alignment;
        final String hexBackgroundColor;
        final String senderPrefix;
        if (isOwnMessage)
        {
            senderPrefix = "";
            alignment = Pos.BASELINE_RIGHT;
            hexBackgroundColor = "#e2fec7";
        } else
        {
            senderPrefix = "User" + message.getSenderId() + ": ";
            alignment = Pos.BASELINE_LEFT;
            hexBackgroundColor = "#fefefe";
        }

        final String messageText = message.getText();
        final Label textLabel = new Label(senderPrefix + messageText);

        setAlignment(alignment);
        textLabel.setStyle("-fx-background-color: " + hexBackgroundColor + "; -fx-background-radius: 15px; -fx-text-fill: #000000");

        textLabel.setPadding(new Insets(5));
        textLabel.setWrapText(true);
        getChildren().add(textLabel);

        setMargin(this, new Insets(10, 10, 10, 10));
        textLabel.setMaxSize(280, Integer.MAX_VALUE);
    }
}
