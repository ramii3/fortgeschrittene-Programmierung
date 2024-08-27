package de.unitrier.st.fp.s23.blatt04;

abstract class DataStructureIterator implements java.util.Iterator<Integer>
{
    int nextIndex;
    DataStructure ds;

    DataStructureIterator(DataStructure ds)
    {
        this.ds = ds;
    }
}
