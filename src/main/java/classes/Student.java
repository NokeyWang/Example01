package classes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CHester on 15/10/15.
 */
public class Student extends People implements Serializable {
    private String studentNumber;//学号
    private String discipline;//专业
    private String grade;//年级

    public Student() {
    }

    public Student(String studentNumber, String discipline, String grade) {
        this.studentNumber = studentNumber;
        this.discipline = discipline;
        this.grade = grade;
    }

    public Student(String number, EnumSex sex, Date birthday, String id,
                   String studentNumber, String discipline, String grade) {
        super(number, sex, birthday, id);
        this.studentNumber = studentNumber;
        this.discipline = discipline;
        this.grade = grade;
    }

    /**
     * 根据字符串格式的输入进行构造
     *
     * @param number   编号
     * @param sex      性别(男性为"male",女性为"female")
     * @param birthday 生日(格式为:yyyy-MM-dd)
     * @param id       身份证号(18位数字)
     * @param studentNumber 学号
     * @param discipline 专业
     * @param grade 年级
     */
    public Student(String number, String sex, String birthday, String id, String studentNumber, String discipline, String grade) {
        super(number, sex, birthday, id);
        this.studentNumber = studentNumber;
        this.discipline = discipline;
        this.grade = grade;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 展示学生信息
     */
    @Override
    public void displayInformationInConsole() {
        super.displayInformationInConsole();
        System.out.println("学号:" + this.getStudentNumber());
        System.out.println("专业:" + this.getDiscipline());
        System.out.println("年级:" + this.getGrade());
    }

    /**
     * 将学生对象转化为一条用于存储的String,字符串中以","作为分隔
     * @return 转化后生成的字符串
     */
    @Override
    public String toStoreAsString() {
        String string;
        string = super.toStoreAsString() + ","
                + this.getStudentNumber() + ","
                + this.getDiscipline() + ","
                + this.getGrade();
        return string;
    }
}
