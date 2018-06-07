package sample;


public class Main {

    public static void main(String[] args) {

        CustomHashMap<String, String> myMap = new CustomHashMap<>();

        myMap.put("Hello", "Hallo");
        myMap.put("Bye", "Auf Wiedersehen");
        myMap.put("Drink", "Trinken");

        String str = myMap.get("Drink");
        System.out.println(str);

    }
}

