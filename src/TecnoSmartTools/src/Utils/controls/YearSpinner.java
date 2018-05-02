package Utils.controls;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class YearSpinner extends JSpinner {

    public YearSpinner() {
        super(new SpinnerDateModel(new Date(), null, null, Calendar.YEAR));
        setEditor(new JSpinner.DateEditor(this, "yyyy"));
    }

    public int getYear() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime((Date) getValue());
        return gc.get(GregorianCalendar.YEAR);
    }

    public int getSelectedYear() {
        return getYear();
    }
}
