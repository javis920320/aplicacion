package Utils.controls;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class DateTimeField extends JSpinner {

    public DateTimeField() {
        setModel(new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE));
        setEditor(new JSpinner.DateEditor(this, "dd/MM/yyyy hh:mm a"));
    }

    public void setDate(Date d) {
        this.setValue(d);
    }

    public Date getDate() {
        return (Date) this.getValue();
    }
}
