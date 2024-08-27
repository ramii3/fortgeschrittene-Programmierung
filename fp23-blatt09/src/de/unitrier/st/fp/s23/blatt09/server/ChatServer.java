package de.unitrier.st.fp.s23.blatt09.server;

import static java.lang.System.out;
import static java.lang.System.err;

import de.unitrier.st.fp.s23.blatt09.common.Message;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class ChatServer extends Thread
{
    /*
    Client management.
     */



    Set<ChatClient> getClients()
    {
        return null;
    }

    void registerClient(final ChatClient client)
    {

    }

    void removeClient(final ChatClient client)
    {

    }

    private static int clientNum = 0;

    private static synchronized int getNextClientNum() {return clientNum++;}

    /*
    Messages.
     */

    void broadcastMessage(final Message message)
    {
        // TODO: Send the message to all clients
    }

    List<Message> getMessages()
    {
        return null;
    }

    void addMessage(final Message message)
    {

    }

    /*
    Port.
     */

    private final int port;
    private final String host;

    /*
    Constructor.
     */

    ChatServer(final String host, final int port)
    {
        this.host = host;
        this.port = port;

    }

    /*
    Thread.
     */

    @Override
    public void run()
    {
        //TODO: Wait for new clients to connect. On connection, start a new client thread.

    }
}
