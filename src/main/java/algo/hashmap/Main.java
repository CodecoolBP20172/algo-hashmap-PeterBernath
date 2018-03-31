package algo.hashmap;

public class Main {

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.add("Aa", 3);
        map.add("BB", 4);
        map.add("CC", 24);
        map.add("hello", 5);
        map.add("hello", 6);
        map.remove("CC");
        map.remove("kkkkk");
        System.out.println(map);
        System.out.println(map.getValue("Aa"));
        System.out.println(map.getValue("BB"));
        System.out.println(map.getValue("hello"));
        System.out.println(map.getValue("CC"));
        map.clearAll();
        System.out.println(map);
    }

}
