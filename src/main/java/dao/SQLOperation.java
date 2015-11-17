package dao;

import classes.PeopleLinkedListCollection;
import classes.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StreamingNotifiable;
import com.mysql.jdbc.StringUtils;
import configuration.MySQLConf;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by CHester on 15/11/17.
 */
public class SQLOperation {

    /**
     * 连接数据库,获取数据库连接
     * @return com.mysql.jdbc.Connection
     */
    private static Connection getConn() {
        /**
         * 方法getConn的功能描述:
         * 连接数据库,获取数据库连接
         * @param []
         * @return com.mysql.jdbc.Connection
         * @throws
         *
         * <PRE>
         * @author CHester
         * @date 15/11/17
         * </PRE>
         */
        String driver = MySQLConf.getMySQLDriver();
        String url = MySQLConf.getMySQLUrl();
        String username = MySQLConf.getMySQLUsername();
        String password = MySQLConf.getMySQLPassword();
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 向数据库中的students表中插入一名学生
     * @param student 学生
     * @return 插入是否成功.1为成功
     */
    public static int insertAStudent(Student student) {
        Connection connection = getConn();
        int i = 0;
        String insertAStudentSql = "insert into test.students (number, sex, birthday, id, studentnumber, discipline, grade) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(insertAStudentSql);
            preparedStatement.setString(1, student.getNumber());
            preparedStatement.setString(2, student.getSex().getSex());
            preparedStatement.setString(3, student.getBirthday());
            preparedStatement.setString(4, student.getId());
            preparedStatement.setString(5, student.getStudentNumber());
            preparedStatement.setString(6, student.getDiscipline());
            preparedStatement.setString(7, student.getGrade());
            i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 读取数据库students表中所有学生信息,存入学生链表
     * @return 学生链表
     */
    public static LinkedList<Student> getAllStudents() {
        LinkedList<Student> studentLinkedList = new LinkedList<Student>();
        Connection conn = getConn();
        String sql = "select * from students";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setNumber(rs.getString("number"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getString("birthday"));
                student.setId(rs.getString("id"));
                student.setStudentNumber(rs.getString("studentnumber"));
                student.setDiscipline(rs.getString("discipline"));
                student.setGrade(rs.getString("grade"));
                studentLinkedList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentLinkedList;
    }

    /**
     * 根据编号删除数据库中students表中的数据
     * @param number 编号
     * @return 是否成功.0为不成功
     */
    public static int deleteAStudent(String number) {
        Connection connection = getConn();
        int i = 0;
        String deleteAStudentSQL = "delete from students WHERE number='" + number + "'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(deleteAStudentSQL);
            i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
