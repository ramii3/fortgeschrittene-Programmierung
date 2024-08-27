package de.unitrier.st.fp.s23.blatt05;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.BiFunction;

import static java.lang.System.out;

final class Main
{
    private Main() {}

    private static boolean testFunctionality(BiFunction<String, String, String> func,
                                             BiFunction<String, String, String> testFunc,
                                             String arg1, String arg2)
    {
        return func.apply(arg1, arg2).equals(testFunc.apply(arg1, arg2));
    }

    private static boolean testFunctionality(BiFunction<String, String, String> func,
                                             Method testMethod,
                                             String arg1, String arg2) throws InvocationTargetException, IllegalAccessException
    {
        return func.apply(arg1, arg2).equals(testMethod.invoke(null, arg1, arg2));
    }

    public static void main(String[] args)
    {
		// Test call. Your task is to find the method 'ObfuscatedUtil::i3f20y1OZq' via the Reflection API, i.e. regardless of its name, but based on its signature and functionality.

      //  out.println(testFunctionality(String::concat, ObfuscatedUtil::i3f20y1OZq, "Hallo", "Du"));


		
		
        // TODO
    }
}
