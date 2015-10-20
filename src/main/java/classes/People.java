package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CHester on 15/10/15.
 */

public abstract class People {

    private String number;//编号
    private EnumSex sex;//性别
    private Date birthday;//生日
    private String id;//身份证号

    public People() {
    }

    public People(String number, EnumSex sex, Date birthday, String id) {
        this.number = number;
        this.sex = sex;
        this.birthday = birthday;
        this.id = id;
    }

    /**
     * 根据字符串格式的输入进行构造
     * @param number 编号
     * @param sex 性别(男性为"male",女性为"female")
     * @param birthday 生日(格式为:yyyy-MM-dd)
     * @param id 身份证号(18位数字)
     */
    public People(String number, String sex, String birthday, String id) {
        String[] birthStr = birthday.split("-");
        int[] birthInt = new int[3];
        for (int i = 0; i < birthStr.length; i++) {
            birthInt[i] = Integer.parseInt(birthStr[i]);
        }
        Date date = new Date(birthInt[0] - 1900, birthInt[1] - 1, birthInt[2]);
        this.number = number;
        this.sex = EnumSex.getEnumByValue(sex);
        this.birthday = date;
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public EnumSex getSex() {
        return sex;
    }

    /**
     * 设置性别
     * @param string 性别代码:男性为1,女性为2
     * @return 设置正确返回1,设置错误返回-1
     */
    public int setSex(String string) {
        if (string.equals("male") || string.equals("female")) {
            this.sex = EnumSex.getEnumByValue(string);
            return 1;//输入正确
        } else {
            return -1;//输入错误
        }
    }

    /**
     * 获取生日
     * @return 以"yyyy-MM-dd"的格式返回生日
     */
    public String getBirthday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 根据输入的String设置生日
     * @param birthday 格式为"年-月-日"(例如:1990-03-05)
     * @return 1为设置成功,-1为设置失败
     */
    public int setBirthday(String birthday) {
        String[] strArr = birthday.split("-");
        if (strArr.length != 3) {
            return -1;
        }
        int year = Integer.parseInt(strArr[0]);
        int month = Integer.parseInt(strArr[1]);
        int day = Integer.parseInt(strArr[2]);
        this.birthday = new Date(year - 1900, month - 1, day);
        return 1;
    }
    public String getId() {
        return id;
    }

    /**
     * 设置身份证号码,必须为18位
     * @param id 身份证号码
     * @return 设置正确返回1,设置错误返回-1
     */
    public int setId(String id) {
        if (id.length() == 18) {
                this.id = id;
                return 1;
        } else {
                return -1;
        }
    }

    /**
     * 在Console中展示人员信息
     */
    public void displayInformationInConsole() {
        System.out.println("编号:" + this.getNumber());
        System.out.println("性别:" + this.getSex());
        System.out.println("出生日期:" + this.getBirthday());
        System.out.println("身份证号:" + this.getId());
    }

    /**
     * 将人员转化为一条用于存储的String,字符串中以","作为分隔
     * @return 转化后生成的字符串
     */
    public String toStoreAsString() {
        String string;
        string = this.getNumber() + ","
                + this.getSex() + ","
                + this.getBirthday() + ","
                + this.getId();
        return string;
    }
}

