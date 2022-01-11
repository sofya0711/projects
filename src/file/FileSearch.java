package file;

import java.io.File;
import java.util.Scanner;

public class FileSearch {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input folder path");
        String pathStr = scanner.nextLine();
        File path = new File(pathStr);
        if (!path.exists() || path.isFile()) {
            System.err.println("Path does not exist or is not directory");
        } else {
            System.out.println("Please input file name");
            String fileName = scanner.nextLine();
            findFile(path, fileName);

        }
    }

    static void findFile(File parent, String fileName) {
        boolean isFound = false;
        for (File file : parent.listFiles()) {
            if (file.isDirectory()) {
                findFile(file, fileName);
            } else {
                if (file.getName().contains(fileName)) {
                    System.out.println(file.getAbsolutePath());
                    break;
                }
            }
        }
    }
}










