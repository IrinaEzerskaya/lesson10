package com.company;

// Класс, описывающий вводимые документы
public class Document {

    public String type;
    public String info;

    // Конструктор класса
    public Document(String type, String info) {
        this.type = type;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Документ "+type+", доп инфо: "+info;
    }
}
