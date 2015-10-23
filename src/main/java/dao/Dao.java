package dao;

import classes.People;
import classes.PeopleLinkedListCollection;
import classes.Student;
import classes.Teacher;
import configuration.Conf;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 数据操作类
 * Created by CHester on 15/10/20.
 */
public class Dao {

    private static String path = Conf.getPath();//存储数据的文件路径

    /**
     * 向文件中添加一条学生信息
     * @param student 学生对象
     */
    public static void addAStudentIntoData(Student student) {
        PeopleLinkedListCollection peopleLinkedListCollection = new PeopleLinkedListCollection();
        peopleLinkedListCollection.peopleLinkedList = Dao.readFromStorage(path);
        peopleLinkedListCollection.peopleLinkedList.add(student);
        Dao.toStoreAsString(peopleLinkedListCollection.peopleLinkedList, path);
    }

    /**
     * 向文件中添加一条教师信息
     * @param teacher 教师对象
     */
    public static void addATeacherIntoData(Teacher teacher) {
        /**
         * 方法addATeacherIntoData的功能描述:
         * 向文件中添加一条教师信息
         * @param [teacher]
         * @return void
         * @throws 
         * 
         * <PRE>
         * @author CHester
         * @date 15/10/20
         * </PRE>
         */
        PeopleLinkedListCollection peopleLinkedListCollection = new PeopleLinkedListCollection();
        peopleLinkedListCollection.peopleLinkedList = Dao.readFromStorage(path);
        peopleLinkedListCollection.peopleLinkedList.add(teacher);
        Dao.toStoreAsString(peopleLinkedListCollection.peopleLinkedList, path);
    }

    /**
     * 在Console中展示全部人员信息
     * @param peopleLinkedList 人员链表
     */
    public static void displayPeopleInConsole(LinkedList<People> peopleLinkedList) {
        /**
         * 方法displayPeople的功能描述:
         * 展示全部人员信息
         * @param [peopleLinkedList]
         * @return void
         * @throws
         *
         * <PRE>
         * @author CHester
         * @date 15/10/15
         * </PRE>
         */

        System.out.println("----------------------------------------------");
        for (People p : peopleLinkedList) {
            p.displayInformationInConsole();
            System.out.println("----------------------------------------------");
        }
        System.out.println("END!");
    }

    /**
     * 从peopleLinkedList中删除工号(学号)为str的教师(学生)
     * @param peopleLinkedList 人员链表
     * @param str 工号(学号)
     * @return 删除的人员是学生则返回1,是老师返回2,链表中无此人返回-1
     */
    public static int removePeople(LinkedList<People> peopleLinkedList, String str) {
        /**
         * 方法removePeople的功能描述:
         * 从peopleLinkedList中删除工号(学号)为str的教师(学生)
         * @param [peopleLinkedList, str]
         * @return int
         * @throws
         *
         * <PRE>
         * @author CHester
         * @date 15/10/15
         * </PRE>
         */
        Iterator iterator = peopleLinkedList.iterator();
        while (iterator.hasNext()) {
            People people = (People) iterator.next();
            if (people instanceof Student) {
                if (((Student) people).getStudentNumber().equals(str)) {
                    iterator.remove();
                    return 1;//删除指定学生
                }
            } else if (people instanceof Teacher) {
                if (((Teacher) people).getTeacherNumber().equals(str)) {
                    iterator.remove();
                    return 2;//删除指定老师
                }
            }
        }
        return -1;//查无此人
    }

    /**
     * 将人员链表存储在path文件中
     * @param peopleLinkedList 人员链表
     * @param path 存储目标文件
     * @return 存储正常为1,存储出错为-1
     */
    public static int toStoreAsString(LinkedList<People> peopleLinkedList, String path) {
        /**
         * 方法toStoreAsString的功能描述:
         * 将人员链表存储在path文件中
         * @param [peopleLinkedList, path]
         * @return void
         * @throws
         *
         * <PRE>
         * @author CHester
         * @date 15/10/20
         * </PRE>
         */

        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String string;

            for (People p : peopleLinkedList) {
                if (p instanceof Student) {
                    string = "student" + ","
                            + ((Student) p).toStoreAsString();
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                } else if (p instanceof Teacher) {
                    string = "teacher" + ","
                            + ((Teacher) p).toStoreAsString();
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                } else {
                    string = null;
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    /**
     * 从存储文件中读取人员信息并存入链表
     * @param path 存储文件
     * @return 链表
     */
    public static LinkedList<People> readFromStorage(String path) {
        /**
         * 方法readFromStorage的功能描述:
         * 从存储文件中读取人员信息并存入链表
         * @param [path] 存储文件
         * @return java.util.LinkedList<Classes.People>
         * @throws
         *
         * <PRE>
         * @author CHester
         * @date 15/10/20
         * </PRE>
         */
        LinkedList<People> peopleLinkedList = new LinkedList<People>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            Student student;
            Teacher teacher;
            while ((string = bufferedReader.readLine()) != null) {
                if (string.substring(0, 3).equals("stu")) {
                    student = new Student();
                    String[] studentStr = string.split(",");
                    student.setNumber(studentStr[1]);
                    student.setSex(studentStr[2]);
                    student.setBirthday(studentStr[3]);
                    student.setId(studentStr[4]);
                    student.setStudentNumber(studentStr[5]);
                    student.setDiscipline(studentStr[6]);
                    student.setGrade(studentStr[7]);
                    peopleLinkedList.add(student);
                } else if (string.substring(0, 3).equals("tea")) {
                    teacher = new Teacher();
                    String[] teacherStr = string.split(",");
                    teacher.setNumber(teacherStr[1]);
                    teacher.setSex(teacherStr[2]);
                    teacher.setBirthday(teacherStr[3]);
                    teacher.setId(teacherStr[4]);
                    teacher.setDepartment(teacherStr[5]);
                    teacher.setTeacherNumber(teacherStr[6]);
                    teacher.setTitle(teacherStr[7]);
                    teacher.setTimeInJob(teacherStr[8]);
                    peopleLinkedList.add(teacher);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleLinkedList;
    }
}
