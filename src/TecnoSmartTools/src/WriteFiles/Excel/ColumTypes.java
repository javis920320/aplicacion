package WriteFiles.Excel;

public class ColumTypes {

    public static int TYPE_NUMBER = 0;
    public static int TYPE_TEXT = 1;
    public static int TYPE_DATE = 2;
    public static int TYPE_DATE_TIME = 3;
    public static int TYPE_DECIMAL = 4;

    public final int type;
    public final Object title;
    public final String formatDateExtra;
    public Class classType;

    public ColumTypes(Integer type, Object title, String formatDateExtra) {
        this.type = type;
        this.title = title;
        this.formatDateExtra = formatDateExtra;
        this.classType = null;
    }

    public ColumTypes(Integer type, Object title, String formatDateExtra, Class classType) {
        this.type = type;
        this.title = title;
        this.formatDateExtra = formatDateExtra;
        this.classType = classType;
    }

}
