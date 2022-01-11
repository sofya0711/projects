//package file;
//
//import java.io.File;
//import java.util.Scanner;
//
//public class FileUtilTest {
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Please input text file path /ends with .txt/");
//        String pathStr = scanner.nextLine();
//        File txtPath = new File(pathStr);
//        if (!txtPath.exists() || txtPath.isFile()){
//            System.out.println("Please input keyword");
//            String keyword = scanner.nextLine();
//            FileUtil.findLines(pathStr, keyword);
//        }else {
//            System.err.println("Error");
//        }
//
//        System.out.println("please input path name");
//        String path1 = scanner.nextLine();
//    }
//}
