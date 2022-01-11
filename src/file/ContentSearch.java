package file;

import java.io.*;
import java.util.Scanner;

public class ContentSearch {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input folder path");
        String pathStr = scanner.nextLine();
        File path = new File(pathStr);
        if (!path.exists() || path.isFile()) {
            System.err.println("Path does not exist or is not directory");
        } else {
            System.out.println("Please input keyword");
            String keyword = scanner.nextLine();
            findFile(path, keyword);

        }
    }

    static void findFile(File parent, String keyword) {
        for (File file : parent.listFiles()) {
            if (file.isDirectory()) {
                findFile(file, keyword);
            } else {
                if (file.getName().endsWith(".txt")) {
                    searchKeyword(file, keyword);
                }
            }
        }
    }

    private static void searchKeyword(File file, String keyword) {
        try ( BufferedReader br = new BufferedReader(new FileReader(file))){
           String line = " ";
           int lineNumber = 1;
           while ((line = br.readLine()) != null){
             if( line.contains(keyword)){
                 System.out.println(file.getAbsolutePath() +"in line: "+ lineNumber);
                 break;
             }
             lineNumber++;
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}













