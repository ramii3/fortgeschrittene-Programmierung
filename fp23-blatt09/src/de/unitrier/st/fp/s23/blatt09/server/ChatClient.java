package de.unitrier.st.fp.s23.blatt09.server;

import de.unitrier.st.fp.s23.blatt09.common.Handshake;
import de.unitrier.st.fp.s23.blatt09.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Set;

import static java.lang.System.err;
import static java.lang.System.out;

final class ChatClient extends Thread
{

    @Override
    public void run()
    {
        // TODO: Send the Handshake object and wait for incoming messages.

    }

    void send(Object object)
    {
        // TODO: Send a message (class Message/Handshake) to the client.

    }
}
