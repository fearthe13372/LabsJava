package lesson02.part01;

/**
 * Создать 5 зергов, 3 протосса и 4 террана.
 * Дать им всем уникальные имена.
 * <p>
 * <p>
 * Требования:
 * 1.	Нельзя изменять классы Zerg, Protoss и Terran.
 * 2.	Нужно создать 5 объектов типа Zerg и каждому из них дать свое имя.
 * 3.	Нужно создать 3 объекта типа Protoss и каждому из них дать свое имя.
 * 4.	Нужно создать 4 объекта типа Terran и каждому из них дать свое имя.
 */

public class Task07 {
    public static void main(String[] args) {
        Zerg zerg = new Zerg();
        zerg.name = "Soka";
        Zerg zerg1 = new Zerg();
        zerg1.name = "Soka1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Soka2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Soka3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Soka4";
        Protoss prot = new Protoss();
        prot.name = "1";
        Protoss prot1 = new Protoss();
        prot1.name = "2";
        Protoss prot2 = new Protoss();
        prot2.name = "3";
        Terran ter = new Terran ();
        ter.name = "1";
        Terran ter1 = new Terran ();
        ter1.name = "2";
        Terran ter2 = new Terran ();
        ter2.name = "3";
        Terran ter3 = new Terran ();
        ter3.name = "4";

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
