import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Set<Ноутбук> ноутбуки = new HashSet<>();
        ноутбуки.add(new Ноутбук("Модель1", 8, 512, "Windows", "Черный"));
        ноутбуки.add(new Ноутбук("Модель2", 16, 1024, "macOS", "Серый"));
        ноутбуки.add(new Ноутбук("Модель3", 4, 256, "Linux", "Белый"));
        Map<String, Object> критерии = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите критерии фильтрации:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.print("Введите номер критерия: ");
            int номерКритерия = scanner.nextInt();
            switch (номерКритерия) {
                case 1:
                    System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                    int минимальныйОбъемОЗУ = scanner.nextInt();
                    критерии.put("ОЗУ", минимальныйОбъемОЗУ);
                    break;
                case 2:
                    System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                    int минимальныйОбъемЖД = scanner.nextInt();
                    критерии.put("ОбъемЖД", минимальныйОбъемЖД);
                    break;
                case 3:
                    System.out.print("Введите операционную систему: ");
                    scanner.nextLine(); 
                    String операционнаяСистема = scanner.nextLine();
                    критерии.put("ОперационнаяСистема", операционнаяСистема);
                    break;
                case 4:
                    System.out.print("Введите цвет: ");
                    scanner.nextLine(); 
                    String цвет = scanner.nextLine();
                    критерии.put("Цвет", цвет);
                    break;
                default:
                    System.out.println("Некорректный номер критерия.");
            }
        }

        System.out.println("Подходящие ноутбуки:");
        for (Ноутбук ноутбук : ноутбуки) {
            boolean подходит = true;
            for (Map.Entry<String, Object> entry : критерии.entrySet()) {
                String критерий = entry.getKey();
                Object значение = entry.getValue();
                switch (критерий) {
                    case "ОЗУ":
                        if (ноутбук.getОбъемОЗУ() < (int) значение) {
                            подходит = false;
                        }
                        break;
                    case "ОбъемЖД":
                        if (ноутбук.getОбъемЖД() < (int) значение) {
                            подходит = false;
                        }
                        break;
                    case "ОперационнаяСистема":
                        if (!ноутбук.getОперационнаяСистема().equalsIgnoreCase((String) значение)) {
                            подходит = false;
                        }
                        break;
                    case "Цвет":
                        if (!ноутбук.getЦвет().equalsIgnoreCase((String) значение)) {
                            подходит = false;
                        }
                        break;
                    default:
                        System.out.println("Неизвестный критерий: " + критерий);
                }
            }
            if (подходит) {
                System.out.println("Модель: " + ноутбук.getМодель());
            }
        }
    }
}

class Ноутбук {
    private String модель;
    private int объемОЗУ; 
    private int объемЖД; 
    private String операционнаяСистема;
    private String цвет;

    public Ноутбук(String модель, int объемОЗУ, int объемЖД, String операционнаяСистема, String цвет) {
        this.модель = модель;
        this.объемОЗУ = объемОЗУ;
        this.объемЖД = объемЖД;
        this.операционнаяСистема = операционнаяСистема;
        this.цвет = цвет;
    }

    public String getМодель() {
        return модель;
    }

    public int getОбъемОЗУ() {
        return объемОЗУ;
    }

    public int getОбъемЖД() {
        return объемЖД;
    }

    public String getОперационнаяСистема() {
        return операционнаяСистема;
    }

    public String getЦвет() {
        return цвет;
    }
}
