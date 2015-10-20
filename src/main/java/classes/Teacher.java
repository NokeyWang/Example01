package classes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CHester on 15/10/15.
 */

public class Teacher extends People implements Serializable {
    private String department;//院系
    private String teacherNumber;//工号
    private String title;//职称
    private String timeInJob;//任职时间

    public Teacher() {
    }


    public Teacher(String department, String teacherNumber, String title, String timeInJob) {
        this.department = department;
        this.teacherNumber = teacherNumber;
        this.title = title;
        this.timeInJob = timeInJob;
    }

    /**
     * Teacher的构造函数
     * @param number 编号
     * @param sex 性别
     * @param birthday 生日
     * @param id 身份证号
     * @param department 院系
     * @param teacherNumber 工号
     * @param title 职称
     * @param timeInJob 任职时间
     */
    public Teacher(String number, EnumSex sex, Date birthday, String id,
                   String department, String teacherNumber, String title, String timeInJob) {
        super(number, sex, birthday, id);
        this.department = department;
        this.teacherNumber = teacherNumber;
        this.title = title;
        this.timeInJob = timeInJob;
    }

    /**
     * 根据字符串格式的输入进行构造
     *
     * @param number 编号
     * @param sex 性别(男性为"male",女性为"female")
     * @param birthday 生日(格式为:yyyy-MM-dd)
     * @param id 身份证号(18位数字)
     * @param department 院系
     * @param teacherNumber 工号
     * @param title 职称
     * @param timeInJob 任职时长(例如:"18年")
     */
    public Teacher(String number, String sex, String birthday, String id, String department, String teacherNumber, String title, String timeInJob) {
        super(number, sex, birthday, id);
        this.department = department;
        this.teacherNumber = teacherNumber;
        this.title = title;
        this.timeInJob = timeInJob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeInJob() {
        return timeInJob;
    }

    public void setTimeInJob(String timeInJob) {
        this.timeInJob = timeInJob;
    }

    /**
     * 展示教师信息
     */
    @Override
    public void displayInformationInConsole() {
        super.displayInformationInConsole();
        System.out.println("部门:" + this.getDepartment());
        System.out.println("工号:" + this.getTeacherNumber());
        System.out.println("职称:" + this.getTitle());
        System.out.println("任职时长:" + this.getTimeInJob() + "年");
    }

    /**
     * 将教师对象转化为一条用于存储的String,字符串中以","作为分隔
     * @return 转化后生成的字符串
     */
    @Override
    public String toStoreAsString() {
        String string;
        string = super.toStoreAsString() + ","
                + this.getDepartment() + ","
                + this.getTeacherNumber() + ","
                + this.getTitle() + ","
                + this.getTimeInJob();
        return string;
    }
}
