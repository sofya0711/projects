package education.storage;

import education.model.Lesson;
import education.util.ArrayUtil;
import education.util.FileUtil;

import java.util.LinkedList;
import java.util.List;

public class LessonStorage {

    private List<Lesson> lessons = new LinkedList<>();


    public void add(Lesson lesson) {
        lessons.add(lesson);
        serialize();
    }


    public void print() {
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
    }


    public Lesson getByName(String name) {
        for (Lesson lesson : lessons) {
            if (lesson.getName().contains(name)) {
                return lesson;
            }
        }
        return null;
    }


    public Lesson deleteByName(String name) {
        for (Lesson lesson : lessons) {
            if (lesson.getName().equals(name)) {
                lessons.remove(lesson);
            }
        }
        serialize();
        return null;
    }

    private void serialize() {
        FileUtil.serializeLessons(lessons);
    }
}
