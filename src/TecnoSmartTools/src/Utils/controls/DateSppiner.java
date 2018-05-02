package Utils.controls;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class DateSppiner extends JSpinner {

    public DateSppiner() {
        setModel(new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE));
        setEditor(new JSpinner.DateEditor(this, "dd/MM/yyyy"));
    }

    public void setDate(Date d) {
        this.setValue(d);
    }

    public Date getDate() {
        return (Date) this.getValue();
    }
}
