package classes;

/**
 * Created by CHester on 15/10/15.
 */
public enum EnumSex {
    male("male"),
    female("female");

    private final String sex;

    EnumSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public static EnumSex getEnumByValue(String value) {

            for (EnumSex e : EnumSex.values()) {
                if (e.sex.equals(value)) {
                    return e;
                }
            }
        return null;
    }
}
