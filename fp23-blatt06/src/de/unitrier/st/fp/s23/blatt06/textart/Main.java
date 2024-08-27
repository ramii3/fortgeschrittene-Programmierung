/*
 * Author: Sir Clexalot aka Master Clexington aka Kuenzlord aka Kuenzlinger der Boss
 * Year: 2021
 */

package de.unitrier.st.fp.s23.blatt06.textart;

final class Main
{
    private Main() {}

    public static void main(String[] args)
    {
        final String fileName = "resources/mario-picture.txt";
        final TextArt textArt = new TextArt(fileName);
        final Printer printer = new Printer(System.out);

        final int numberOfArtists = 1000;
        final Thread[] threads = new Thread[numberOfArtists];

        for (int i = 0; i < numberOfArtists; i++)
        {
            threads[i] = new ArtistThread(printer, textArt);
        }

        for (int i = 0; i < numberOfArtists; i++)
        {
            threads[i].start();
        }
    }
}
