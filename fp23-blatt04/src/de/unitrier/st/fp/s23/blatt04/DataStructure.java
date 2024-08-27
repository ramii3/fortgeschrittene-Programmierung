package de.unitrier.st.fp.s23.blatt04;

class DataStructure
{
    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    int getSize()
    {
        return SIZE;
    }

    int[] getInts()
    {
        return arrayOfInts;
    }

    DataStructure()
    {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++)
        {
            arrayOfInts[i] = i;
        }
    }

    private DataStructureIterator getIterator(IteratorStrategy strategy)
    {
        return strategy.getIterator(this);
    }

    void printEven()
    {
        // Print out values of even indices of the array
        DataStructureIterator iterator = getIterator(new EvenIteratorStrategy());
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
