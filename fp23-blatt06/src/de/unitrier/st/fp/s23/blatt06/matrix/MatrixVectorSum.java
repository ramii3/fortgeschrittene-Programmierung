package de.unitrier.st.fp.s23.blatt06.matrix;

final class MatrixVectorSum
{
    private long sum;
    private final Matrix m;
    private final Vector v;

    MatrixVectorSum(Matrix m, Vector v)
    {
        sum = 0;
        this.m = m;
        this.v = v;
        threadsDone = m.getRows();
    }

    private int threadsDone;

    private boolean resetDoneThreads()
    {
        if (!done()) return false;
        threadsDone = 0;
        return true;
    }

    void threadDone()
    {
        threadsDone++;
    }

    private boolean done()
    {
        return threadsDone == m.getRows();
    }

    long computeMatrixVectorSum() throws Exception
    {
        if (!resetDoneThreads())
        {
            throw new Exception("Computation not done yet!");
        }
        sum = 0;
        if (m.getColumns() != v.getRows())
        {
            throw new IllegalArgumentException("The number of columns does not match the number of rows!");
        }
        for (int i = 0; i < m.getRows(); i++)
        {
            new Thread(new SumThread(this, i)).start();
        }
        while (!done())
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return sum;
    }

    Matrix getMatrix()
    {
        return m;
    }

    Vector getVector()
    {
        return v;
    }

    private long getSum()
    {
        return sum;
    }

    private void setSum(long sum)
    {
        this.sum = sum;
    }

    void addValueToSum(int value)
    {
        long currentSum = getSum();
        currentSum = currentSum + value;
        try
        {
            Thread.sleep(10);
        } catch (Exception e)
        {
            //ignored
        }
        setSum(currentSum);
    }
}
