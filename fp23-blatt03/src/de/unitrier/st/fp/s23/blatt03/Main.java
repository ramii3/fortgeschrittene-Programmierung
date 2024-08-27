package de.unitrier.st.fp.s23.blatt03;

final class Main
{
    private Main() {}

    public static void main(String[] argv)
    {
        final List list = new List();
        for (int i = 0; i < 20; i++)
        {
            list.append(i);
        }
        list.print();
    }
}
