package Lab6;//Разработать консольное приложение, позволяющее просматривать файлы и каталоги файловой системы,
// а также создавать и удалять текстовые файлы.
// Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Lab6 {

    private String text = "";

    public String getText() {
        return text;
    }

    public File currentFolder = new File("C:\\Users\\Ayazani\\Desktop\\kurs");

    public void work() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        try {
            while (!(input = scanner.nextLine()).isEmpty()) {
                String[] inputTokens = input.split(" ");
                switch (inputTokens[0]) {
                    case "ls":
                        ls();
                        break;
                    case "cd":
                        cd(inputTokens[1]);
                        break;
                    case "touch":
                        touch(inputTokens[1]);
                        break;
                    case "rm":
                        rm(inputTokens[1]);
                        break;
                    case "cat":
                        cat(inputTokens[1]);
                        break;
                    case "echo":
                        if (inputTokens[2].equals("-a")) {
                            echo(inputTokens[1], connectText(inputTokens, 3), true);
                        } else {
                            echo(inputTokens[1], connectText(inputTokens, 2), false);
                        }
                }
            }
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Некорректные аргументы команды");
        } catch(Exception ex) {
            System.out.println(ex);
        }
        scanner.close();
    }

    public void ls() {
        text = "";
        for (File file : currentFolder.listFiles()) {
            text += file.getName() + "\n";
        }
    }

    public void cd(String path) {
        if(path.toCharArray()[0] == '/') {
            currentFolder = new File(currentFolder.getAbsolutePath(), path);
        } else if(path.equals("..")) {
            currentFolder = currentFolder.getParentFile();
        } else {
            currentFolder = new File(path);
        }
    }

    public String touch(String filename) {
        boolean check = false;

        try {
            check = (new File(currentFolder.getAbsolutePath(), filename)).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (check)
            return "File has been created";
        else
            return "File exists!";
    }

    public String rm(String filename)  {
        boolean check = (new File(currentFolder.getAbsolutePath(), filename)).delete();
        if (check)
            return "File has been deleted";
        else
            return "File not found";
    }

    public void cat(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(currentFolder.getAbsolutePath(), filename));
        text = "";
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            text += input + "\n";
        }
    }

    public void echo(String filename, String text, boolean shouldAppend) throws IOException {
        FileWriter writer = new FileWriter(new File(currentFolder.getAbsolutePath(), filename), shouldAppend);
        writer.write(text);
        writer.close();
    }

    public String connectText(String[] text, int startingFrom) {
        String result = "";
        for (int i = startingFrom; i < text.length; i += 1) {
            result += text[i] + " ";
        }
        return result;
    }
}