package de.unitrier.st.fp.s23.blatt05;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Locale;

import static java.lang.System.out;

public class A1
{
    public void methodA(int x, int y)
    {
        out.println((x + y));
    }

    public boolean testIfEven(int x)
    {
        return x % 2 == 0;
    }

    public int methodB(int z)
    {
        return z * z;
    }

    public boolean isOdd(int test)
    {
        return test % 2 != 0;
    }

    public boolean isNullTestMethod(Object o) {return o == null;}

    private static void printTestMethods(Object o)
    {
        // TODO
        Class c = o.getClass();
        Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            String methodName =methods[i].getName().toLowerCase();
            if(methodName.contains("test")&&!Modifier.isStatic(methods[i].getModifiers()))
            {
                out.println(methods[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        printTestMethods(new A1());
    }
}
