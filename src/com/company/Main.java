package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Запрашиваем у пользователя кол-во вводимых документов
        Scanner input = new Scanner(System.in);
        int totalDocumentsNumber = 0;

        do {
            System.out.print("Сколько документов будете вводить: ");
            if (input.hasNextInt()) {
                totalDocumentsNumber = input.nextInt();
            } else {
                System.out.println("Разрешено вводить только целые положительные числа");
                input.nextLine();
            }
        } while (totalDocumentsNumber<=0);

        // Выделяем место в памяти под указанное кол-во документов
        Document[] allDocuments = new Document[totalDocumentsNumber];

        System.out.println("Вводим " + totalDocumentsNumber + " документов");
        input.nextLine(); // Удаление лишнего перевода строки \n

        int i = 0;
        while (i<totalDocumentsNumber) {
            System.out.println("Документ #"+(i+1)+" Введите название:");
            String doctype = input.nextLine();
            System.out.println("Введите необходимую информацию:");
            String docinfo = input.nextLine();
            System.out.println("");
            allDocuments[i] = new Document(doctype, docinfo);
            i++;
        }

        System.out.println("Укажите номер документа для отображения, или 'exit' для выхода:");

        String cmd = "";
        boolean isBreak = false;
        while (!isBreak) {

            int docNum = 1;
            do {
                System.out.println("Какой номер документа интересует:");
                if (input.hasNextInt()) {
                    docNum = input.nextInt();
                } else if (input.hasNext()) {
                    cmd = input.next();
                    if (cmd.equals("exit"))
                    { isBreak = true; break; }
                } else {
                    System.out.println("Разрешено вводить только целые положительные числа от 1 до "+totalDocumentsNumber);
                    input.nextLine();
                }
            } while (docNum<=0 || docNum>totalDocumentsNumber);

            if (!isBreak)
                System.out.println(allDocuments[docNum-1].toString());

        }

        input.close();
    }
}
