package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Lab3 {

    public static void main(String[] args) {
//      ZADANIE 1
        // Różnica jest taka, klucz w TreeSet mogą być uporządkowane, i że podczas iterowania będą w jakiejś ustalonej kolenośći
        // W HashMap nie ma żadnej pewności w jakiej kolejności klucze zostaną ułożone.
        // HashMap jest szybsza, ale pochłania więcej pamięci. Użycie jednej albo drugiej może zależeć od wydajności czasowej lub pamięciowej
        // Nie jest wymagana zmiana, żadna inna linia kodu oprócz miejsca tworzenia obiektu

        // Set<String> zbiorDni = new HashSet<>();
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");

        for (String dzien : zbiorDni) {
            System.out.println(dzien);
        }
        System.out.println();

//      ZADANIE 2
        Teacher t1 = new Teacher("Bjarne", "Stroustrup", "Introduction to C++", "bjarne@fake.org");
        Teacher t2 = new Teacher("Nauczyciel", "Jeden", "Programowanie obiektowe", "njeden@fake.org");
        Teacher t3 = new Teacher("Nauczyciel", "Dwa", "Podstawy programowania", "ndwa@fake.org");
        Teacher t4 = new Teacher("Nauczyciel", "Trzy", "Systemy internetowe", "ntrzy@fake.org");
        Teacher t5 = new Teacher("Nauczyciel", "Cztery", "Technologie programowania systemów internetowych", "ncztery@fake.org");

        Map<String, String> przedmioty = new HashMap<>();
        przedmioty.put(t1.getCourseName(), t1.getFirstName() + " " + t1.getLastName());
        przedmioty.put(t2.getCourseName(), t2.getFirstName() + " " + t2.getLastName());
        przedmioty.put(t3.getCourseName(), t3.getFirstName() + " " + t3.getLastName());
        przedmioty.put(t4.getCourseName(), t4.getFirstName() + " " + t4.getLastName());
        przedmioty.put(t5.getCourseName(), t5.getFirstName() + " " + t5.getLastName());

        for (String przedmiot : przedmioty.keySet()) {
            if (przedmiot == "Programowanie obiektowe") {
                System.out.println("Programowanie obiektowe prowadzi: " + przedmioty.get(przedmiot));
            }
        }

        List<Student> grupa31 = new ArrayList<>();
        grupa31.add(new Student("Jan", "Kowalski", "31", "aa@aa.pl"));
        grupa31.add(new Student("John", "Smith", "31", "aa@aa.pl"));
        grupa31.add(new Student("Super", "Gosc", "31", "aa@aa.pl"));
        grupa31.add(new Student("AA", "BB", "31", "aa@aa.pl"));
        grupa31.add(new Student("CC", "DD", "31", "aa@aa.pl"));
        grupa31.add(new Student("EE", "FF", "31", "aa@aa.pl"));

        List<Student> grupa32 = new ArrayList<>();
        grupa32.add(new Student("Jan", "Kowalski", "32", "aa@aa.pl"));
        grupa32.add(new Student("John", "Smith", "32", "aa@aa.pl"));
        grupa32.add(new Student("Super", "Gosc", "32", "aa@aa.pl"));
        grupa32.add(new Student("AA", "BB", "32", "aa@aa.pl"));
        grupa32.add(new Student("CC", "DD", "32", "aa@aa.pl"));
        grupa32.add(new Student("EE", "FF", "32", "aa@aa.pl"));

        List<Student> grupa33 = new ArrayList<>();
        grupa33.add(new Student("Jan", "Kowalski", "33", "aa@aa.pl"));
        grupa33.add(new Student("John", "Smith", "33", "aa@aa.pl"));
        grupa33.add(new Student("Super", "Gosc", "33", "aa@aa.pl"));
        grupa33.add(new Student("AA", "BB", "33", "aa@aa.pl"));
        grupa33.add(new Student("CC", "DD", "33", "aa@aa.pl"));
        grupa33.add(new Student("EE", "FF", "33", "aa@aa.pl"));

        Map<String, List<Student>> grupy = new HashMap<>();
        grupy.put("31", grupa31);
        grupy.put("32", grupa32);
        grupy.put("33", grupa33);

        System.out.println(grupy.get("32"));
        System.out.println();

        // ZADANIE 3
        List<Product> productList = new ArrayList<>();
        Map<Integer, Product> productMap1 = new HashMap<>();
        Set<String> kategorie = new HashSet<>();
        Map<String, List<Product>> productMap2 = new HashMap<>();
        
        try (BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

            String s = in.readLine();

            while (s != null) {
                String[] pola = s.split(";");
                Product prod = new Product(Integer.parseInt(pola[0]), pola[1], pola[2], Double.parseDouble(pola[3]));
                productList.add(prod);
                productMap1.put(Integer.parseInt(pola[0]), prod);
                productMap2.put(pola[2], productList);
                kategorie.add(pola[2]);
                s = in.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        for (String kat : kategorie) {
            List<Product> kategoria = new ArrayList<>();
            for (Product prod : productList) {
                if (kat.equals(prod.getCategory())) {
                    kategoria.add(prod);
                }
            }
            productMap2.put(kat, kategoria);
        }
        
        for(Integer id : productMap1.keySet()) {
            Product prod = productMap1.get(id);
            System.out.println(prod);
        }
        
        System.out.println();
        
        for(String kat : productMap2.keySet()) {
            List<Product> produkty = productMap2.get(kat);
            System.out.println(kat + " -- " + produkty);
        }
    }
}
