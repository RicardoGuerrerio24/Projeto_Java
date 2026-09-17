package matriculas;

public class Main {

    public static void main(String[] args) {

        Matricula m1 = new Matricula(
                "AA-00-AA",
                "Branca",
                "Portugal",
                2025,
                "520x110 mm",
                "Retangular"
        );

        Matricula m2 = new Matricula(
                "12-AB-34",
                "Branca",
                "Portugal",
                2024,
                "520x110 mm",
                "Retangular"
        );

        System.out.println(m1);
        System.out.println(m2);
    }
}