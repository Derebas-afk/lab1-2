import java.util.Scanner;

public class main {

    public static chelovek [] setRiverArr(int k) { 
        Scanner sc=new Scanner(System.in,"cp1251");
        chelovek[] cheloveks = new chelovek[k];
        System.out.println("Введите информацию о каждом человеке: ");
        for (int i = 0; i < cheloveks.length; i++) {
            cheloveks[i] = new chelovek();
            System.out.print("Введите имя " + (i + 1) + " человека => ");
            cheloveks[i].im = sc.nextLine();
            System.out.print("Введите фамилию => ");
            cheloveks[i].fam = sc.nextLine();
            System.out.print("Введите год рождения => ");
            cheloveks[i].god = sc.nextInt();
            System.out.print("Введите месяц рождения => ");
            cheloveks[i].mesyac = sc.nextInt();
            sc.nextLine();
        }
        return cheloveks;
    }

    public static void showTitle() {
        System.out.format("%15s%25s%10s\n", "Фамилия", "Имя", "Год", "Месяц");
    }

    public static void showchelovek(chelovek r) {
        System.out.format("%15s%25s%10d\n", r.fam, r.im, r.god, r.mesyac);
    }

    public static void showArray(chelovek [] cheloveks) {
        for (chelovek r : cheloveks) {
            showchelovek(r);
        }
    }

    public static int numMin(chelovek [] cheloveks) {
        int p = 0;
        for (int i = 1; i < cheloveks.length; i++) {
            if (cheloveks[i].god < cheloveks[p].god) {
                p = i;
            }
        }
        return p;
    }

    public static double avggod(chelovek [] cheloveks) {
        double s = 0;
        for (int i = 0; i < cheloveks.length; i++) {
            s += s + (2021 - cheloveks[i].god);
        }
        s /= cheloveks.length;
        return s;
    }

    public static chelovek [] Bigger(chelovek [] cheloveks) {
        double s = avggod(cheloveks);
        int k = 0;
        for (int i = 0; i < cheloveks.length; i++) {
            if (cheloveks[i].god > s) {
                k++;
            }
        }
        if (k != 0) {
            chelovek [] rs = new chelovek[k];
            int n = -1;
            for (int i = 0; i < cheloveks.length; i++) {
                if (cheloveks[i].god > s) {
                    rs[++n] = cheloveks[i];
                }
            }
            return rs;
        } else return null;
    }

    public static void sortName(chelovek [] cheloveks) {
        for (int i = 0; i < cheloveks.length - 1; i++) {
            for (int j = i + 1; j < cheloveks.length; j++) {
                if (cheloveks[i].fam.compareTo(cheloveks[j].fam) > 0) {
                    chelovek r = cheloveks[i];
                    cheloveks[i] = cheloveks[j];
                    cheloveks[j] = r;
                }
            }
        }
    }

    public static chelovek findForName(chelovek cheloveks[], String fam) {
        int n = -1;  // -1 –
        for (int i = 0; i < cheloveks.length; i++) {
            if (fam.equals(cheloveks[i].fam)) {
                n = i;
            }
        }
        if (n != -1) {
            return cheloveks[n];
        } else return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введите количество людей => ");
        int n = sc.nextInt();
        sc.nextLine();
        chelovek[] cheloveks = setRiverArr(n);

        System.out.println("\nЛюди:");
        showTitle();
        showArray(cheloveks);

        System.out.println("\nСамый старший человек:");
        showTitle();
        showchelovek(cheloveks[numMin(cheloveks)]);

        System.out.println("\nСредний возраст: " + avggod(cheloveks));
        System.out.println("\nЛюди возраст которых больше средней:");
        showTitle();
        showArray(Bigger(cheloveks));

        sortName(cheloveks);
        System.out.println("\nЛюди по списку:");
        showTitle();
        showArray(cheloveks);

        System.out.print("Введите название искомой человека => ");
        String name = sc.nextLine();
        chelovek r = findForName(cheloveks, name);
        if (r != null) {
            System.out.println("\nТакой человек есть в списке:");
            showTitle();
            showchelovek(r);
        }
        else {
            System.out.println("Такого человека нет в списке");
        }
    }
}
