package de.unitrier.st.fp.s23.blatt09.common;

import java.io.Serializable;

public class Message implements Serializable
{
    protected MessageType type;
    private final String text;
    private final int senderId;

    public Message(final String text, final int senderId)
    {
        this.text = text;
        this.senderId = senderId;
    }

    public String getText()
    {
        return text;
    }

    public int getSenderId()
    {
        return senderId;
    }

    public MessageType getType()
    {
        return type;
    }
}
