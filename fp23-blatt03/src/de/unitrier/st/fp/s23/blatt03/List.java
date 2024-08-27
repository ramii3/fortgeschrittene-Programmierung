package de.unitrier.st.fp.s23.blatt03;

import static java.lang.System.out;

/**
 * Doppelt verkettete Liste.
 */
public class List
{
    protected Element begin;
    protected Element end;
    protected int length;

    /**
     * Fuege ein Element am Ende der Liste hinzu.
     *
     * @param e Neues Listenelement.
     */
    public void append(final Element e)
    {
        if (begin == null)
        {
            begin = e;
            end = e;
            e.setPrev(null);
            e.setNext(null);
        } else
        {
            Element tmp = end;
            end = e;
            tmp.setNext(e);
            e.setPrev(tmp);
            e.setNext(null);
        }
        length++;
    }

    /**
     * Erzeuge ein Element, das den Wert v enthaelt, und fuege es am Ende der Liste hinzu.
     *
     * @param value Wert des neuen Elements.
     */
    public void append(final double value)
    {
        append(new Element(value));
    }

    /**
     * Fuege die Elemente aus der uebergebenen Liste am Ende dieser Liste hinzu.
     *
     * @param list Die Liste, deren Elemente angefuegt werden sollen.
     */
    public void append(final List list)
    {
        Element e = list.getBegin();
        while (e != null)
        {
            Element next = e.getNext(); // append sets e.next to null
            append(e);
            e = next;
        }
    }

    /**
     * Erzeuge ein neues Element pro Wert im uebergebenen Array und fuege die neuen Elemente am Ende der Liste hinzu.
     *
     * @param values Array mit Double-Werten, die eingefuegt werden sollen.
     */
    public void append(final double[] values)
    {
        for (final double value : values)
        {
            append(value);
        }
    }

    /**
     * Erzeuge ein Array mit den Elementen aus der Liste (gleiche Reihenfolge).
     *
     * @return Array mit Elementen der Liste (in gleicher Reihenfolge).
     */
    public double[] asArray()
    {
        double[] array = new double[length];
        Element element = begin;
        int arrayPos = 0;
        while (element != null)
        {
            array[arrayPos] = element.value;
            arrayPos++;
            element = element.next;
        }
        return array;
    }

    /**
     * Gib die Liste auf der Konsole aus.
     */
    public void print()
    {
        if (isEmpty())
        {
            out.printf("Empty\n");
        } else
        {
            Element pos = begin;
            while (pos != null)
            {
                pos.print();
                pos = pos.next;
            }
        }
    }

    /**
     * Leere die Liste.
     */
    public void empty()
    {
        begin = null;
        end = null;
        length = 0;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(final int length)
    {
        this.length = length;
    }

    public Element getBegin()
    {
        return begin;
    }

    public void setBegin(final Element begin)
    {
        this.begin = begin;
    }

    public Element getEnd()
    {
        return end;
    }

    public void setEnd(final Element end)
    {
        this.end = end;
    }

    public boolean isEmpty()
    {
        return (begin == null) && (end == null) && (length == 0);
    }

    /**
     * Die Klasse fuer die Elemente der doppelt verketteten Liste.
     */
    private final class Element
    {
        private double value;
        private Element next;
        private Element prev;

        Element(final double value)
        {
            setValue(value);
        }

        double getValue()
        {
            return value;
        }

        void setValue(final double value)
        {
            this.value = value;
        }

        Element getNext()
        {
            return next;
        }

        void setNext(final Element next)
        {
            this.next = next;
        }

        Element getPrev()
        {
            return prev;
        }

        void setPrev(final Element prev)
        {
            this.prev = prev;
        }

        void print()
        {
            out.printf("%.2f\n", value);
        }
    }
}
