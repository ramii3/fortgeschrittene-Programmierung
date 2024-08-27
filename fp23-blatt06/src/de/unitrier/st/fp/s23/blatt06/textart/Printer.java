package de.unitrier.st.fp.s23.blatt06.textart;

import java.io.PrintStream;

final class Printer
{
    private int printedIndex;
    private final PrintStream stream;

    Printer(final PrintStream stream)
    {
        this.stream = stream;
        printedIndex = -1;
    }

    void print(final int indexToPrint, final char c)
    {
        stream.print(c);
        printedIndex = indexToPrint;
    }
}
