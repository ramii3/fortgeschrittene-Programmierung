package de.unitrier.st.fp.s23.blatt04;

public class EvenIteratorStrategy implements IteratorStrategy
{
    @Override
    public DataStructureIterator getIterator(DataStructure ds)
    {
        return new EvenIterator(ds);
    }
}
