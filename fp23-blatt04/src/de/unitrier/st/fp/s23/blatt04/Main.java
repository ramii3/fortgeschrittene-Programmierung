package de.unitrier.st.fp.s23.blatt04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class Main
{
    private Main() {}



    public static double averege(List<Integer> list){
        return list.stream().filter(e -> e%2==0).mapToDouble(e -> e).average().orElse(0);
        //Man startet den Stream mit einer Liste mit dem Methodenaufruf stream()
        //filter -> Da kommt ein Prädikat rein. Dafür verwendet man ein Lambda ausdruck
        //Bei MapToDouble kann man im hinteren des Lambda ausdrucks mit geschweiften
        //Klammern über mehrere Zeilen schreiben. Er braucht aber ein return statement am Ende
        //Averege macht die ganze Arbeit fürs arthmetische Mittel
        //orElse(0) braucht man aus irgendeinem Grund nach averege. Nicht vergessen!
    }
    public static List<String> upperCase(List<String> list){
        return list
                .stream()
                .map(e -> e.toLowerCase())
                .map(e -> {
                    if(e.length()==3||e.startsWith("a")){
                        e=e.toUpperCase();
                    }
                    return e;
                })
                .collect(Collectors.toList());
    }
    //map kann man mehrmals verwenden. -Bei geschweiften Klammern wird
    //der Wert nicht einfach so umgewandelt in map sondern man muss ihn wie
    //als ob man ganz normal kodiert ändern. also e = e.toUpperCase und
    //nicht wie beim ersten map einfach e.toLowerCase(). Sonst wird e nicht
    //geändert
    //Mit collect(Collectors.toList()) abschließen. Dann hat man wieder
    //eine Liste als Rückgabewert. Ensprechend der Methodendeklaration

    //A1.3
    public static String getString(List<Integer> list){
        return list
                .stream()
                .map(e -> {
                    String x;
                    if(e%2==0){
                        x="g"+e;
                    }
                    else {
                        x="u"+e;
                    }
                    return x;
                })
                .collect(Collectors.joining(", "));
    }
    //hier neu: Letzer Operatior: .collect(Collectors.joining(", ")
    //Liefert als Rückgabewert ein String indem es jeder Eintrag im Stream
    //der ans Ende kommt aneinander fügt und durch etwas separiert hier: ", "



    //A2.1
    public static List<String> nGramme(String str, int n){
        final String normalisiert = str.trim().replaceAll("\\s", " ");
        return IntStream.rangeClosed(0, normalisiert.length() - n).mapToObj(index -> normalisiert.substring(index, index + n)).collect(Collectors.toList());
    }
    //A2.2
    public static void nGramme2(List<String> list, int n){
        Map<String, Integer> map = new HashMap<>();
        list.stream().map(s -> nGramme(s, n)).forEach(nGrammListe -> nGrammListe.forEach(s -> map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1)));
        map.forEach((string, vorkommen) -> System.out.println(string + " " + vorkommen));
    }

    public static void main(String[] argv)
    {
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();

        List<String> list = new ArrayList<>();
        list.add("hallo");
        list.add("allo");
        list.add("llo");
        list.add("amanolaschakata");
        list.add("gmanolaschakata");
        list.add("FFmanolaschakata");
        System.out.println( upperCase(list));

        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(2);
        list2.add(3);
        list2.add(99);
        list2.add(100);
        list2.add(4);
        System.out.println( getString(list2));













//        ds.print(new EvenIteratorStrategy());

//        ds.print(new IteratorStrategy()
//        {
//
//        });

        // Even
 //        ds.print(...);

        // Odd
//        ds.print(...);


//        ds.print(DataStructure::isEvenIndex);
//        ds.print(DataStructure::isOddIndex);
    }
}