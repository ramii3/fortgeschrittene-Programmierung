package de.unitrier.st.fp.s23.blatt05;

import javax.management.RuntimeErrorException;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Stream;

import static java.lang.System.out;

public class A2
{
    private static String commonAncestor(Object a, Object b)
    {
        // TODO
        Class returnClass = a.getClass();
        while (!returnClass.isInstance(b)) returnClass = returnClass.getSuperclass();
        return returnClass.getName();
    }

    public static void main(String[] args)
    {
        out.println(commonAncestor(new LinkedList<Integer>(), new HashSet<Integer>()));
        out.println(commonAncestor(new HashMap<>(), new Stack<>()));
        out.println(commonAncestor(new ArrayIndexOutOfBoundsException(), new ArithmeticException()));
    }
}
