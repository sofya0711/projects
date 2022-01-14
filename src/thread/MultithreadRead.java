package thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadRead extends Thread {

    List<String> str;
    public String keyword;
    public static AtomicInteger countOfKeyword = new AtomicInteger();
    Thread t;

    public MultithreadRead(String keyword, List<String> str) {

        this.keyword = keyword;
        this.str = str;
        t = new Thread(this);
        t.start();
    }


    public void run() {
        for (String sting : str) {
            if (sting.contains(keyword)) {
                countOfKeyword.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String path = "C:\\Users\\Hp\\Desktop\\Folder\\sample.txt";
        int count = (int) Files.lines(Paths.get(path)).count();
        String keyword = ";";

        System.out.println("All lines: " + count);

        List<String> str = Files.readAllLines(Paths.get(path));

        List<String> subStr1 = str.subList(1, (count / 4));
        List<String> subStr2 = str.subList((count / 4) + 1, 2 * (count / 4));
        List<String> subStr3 = str.subList((2 * (count / 4)) + 1, 3 * (count / 4));
        List<String> subStr4 = str.subList((3 * (count / 4)) + 1, count);

        List[] listsOfThread = {subStr1, subStr2, subStr3, subStr4};

        long currentTime = System.currentTimeMillis();
        try {
            new MultithreadRead(keyword, subStr1).t.join();
            new MultithreadRead(keyword, subStr2).t.join();
            new MultithreadRead(keyword, subStr3).t.join();
            new MultithreadRead(keyword, subStr4).t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("found lines :" + countOfKeyword);
        long finishTime = System.currentTimeMillis();
        System.out.println("time: " + (finishTime - currentTime));
    }
}