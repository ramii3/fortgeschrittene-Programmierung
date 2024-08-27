package de.unitrier.st.fp.s23.blatt09.server;

final class ChatServerMain
{
    private ChatServerMain() {}

    public static void main(String[] args)
    {
        int port;
        if (args.length > 0)
        {
            final String portStr = args[0];
            try
            {
                port = Integer.parseInt(portStr);
            } catch (NumberFormatException e)
            {
                System.err.printf("Could not parse input=%s as integer. Please provide an integer value as port.", portStr);
                return;
            }
        } else
        {
            port = 3305;
        }
        //final ChatServer chatServer = new ChatServer(null, port);
        final ChatServer chatServer = new ChatServer("localhost", port);
        chatServer.start();
    }
}
