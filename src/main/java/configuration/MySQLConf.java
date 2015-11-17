package configuration;

/**
 * Created by CHester on 15/11/17.
 */
public class MySQLConf {
    private static String MySQLDriver = "com.mysql.jdbc.Driver";
    private static String MySQLUrl = "jdbc:mysql://localhost:3306/test";
    private static String MySQLUsername = "";
    private static String MySQLPassword = "";

    public static String getMySQLDriver() {
        return MySQLDriver;
    }

    public static void setMySQLDriver(String mySQLDriver) {
        MySQLDriver = mySQLDriver;
    }

    public static String getMySQLUrl() {
        return MySQLUrl;
    }

    public static void setMySQLUrl(String mySQLUrl) {
        MySQLUrl = mySQLUrl;
    }

    public static String getMySQLUsername() {
        return MySQLUsername;
    }

    public static void setMySQLUsername(String mySQLUsername) {
        MySQLUsername = mySQLUsername;
    }

    public static String getMySQLPassword() {
        return MySQLPassword;
    }

    public static void setMySQLPassword(String mySQLPassword) {
        MySQLPassword = mySQLPassword;
    }
}
