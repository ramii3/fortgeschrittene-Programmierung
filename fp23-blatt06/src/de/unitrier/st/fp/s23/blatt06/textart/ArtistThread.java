/*
 * Author: Sir Clexalot aka Master Clexington aka Kuenzlord aka Kuenzlinger der Boss
 * Year: 2021
 */
package de.unitrier.st.fp.s23.blatt06.textart;

final class ArtistThread extends Thread
{
    private static int threadInitNumber;

    private static synchronized int nextThreadNum()
    {
        return threadInitNumber++;
    }

    private final Printer printer;
    private TextArt textArt;

    ArtistThread(final Printer printer, final TextArt textArt)
    {
        super(ArtistThread.class.getName() + "-" + nextThreadNum());
        this.printer = printer;
        this.textArt = textArt;
    }

//    ArtistThread(final Printer printer, final TextArtReader textArtReader)
//    {
//        super(ArtistThread.class.getName() + "-" + nextThreadNum());
//        this.printer = printer;
//        this.textArtReader = textArtReader;
//    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            final int nextCharacterIndex = textArt.getNextCharacterIndex();
            if (nextCharacterIndex < 0)
            {
                break;
            }

            final char nextCharacter = textArt.getCharacter(nextCharacterIndex);

            printer.print(nextCharacterIndex, nextCharacter);

            try
            {
                //noinspection BusyWait
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
