package dao;

import classes.People;
import classes.Student;
import classes.Teacher;
import configuration.Conf;

/**
 * Created by CHester on 15/10/20.
 */
public class Dao {

    private static String path = Conf.getPath();//数据文件路径

    /**
     * 向文件中添加一条学生信息
     * @param student 学生对象
     */
    public static void addAStudentIntoData(Student student) {
        PeopleLinkedListCollection peopleLinkedListCollection = new PeopleLinkedListCollection();
        peopleLinkedListCollection.peopleLinkedList = peopleLinkedListCollection.readFromStorage(path);
        peopleLinkedListCollection.peopleLinkedList.add(student);
        peopleLinkedListCollection.toStoreAsString(peopleLinkedListCollection.peopleLinkedList, path);
    }

    /**
     * 向文件中添加一条教师信息
     * @param teacher 教师对象
     */
    public static void addATeacherIntoData(Teacher teacher) {
        PeopleLinkedListCollection peopleLinkedListCollection = new PeopleLinkedListCollection();
        peopleLinkedListCollection.peopleLinkedList = peopleLinkedListCollection.readFromStorage(path);
        peopleLinkedListCollection.peopleLinkedList.add(teacher);
        peopleLinkedListCollection.toStoreAsString(peopleLinkedListCollection.peopleLinkedList, path);
    }
}
