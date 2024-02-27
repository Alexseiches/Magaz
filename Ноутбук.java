import java.util.*;

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
