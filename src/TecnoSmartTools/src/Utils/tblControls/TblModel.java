package Utils.tblControls;

import WriteFiles.Excel.ColumTypes;
import javax.swing.table.AbstractTableModel;

public class TblModel extends AbstractTableModel {

    private Object[][] data;
    private ColumTypes[] headers;
    private int colums;

    public TblModel(Object[][] data, ColumTypes[] headers) {
        this.data = data;
        this.headers = headers;
        this.colums = headers.length;
    }

    public void update(ColumTypes[] headers, Object[][] data) throws Exception {
        this.headers = headers;
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return headers != null ? headers[column].title.toString() : "";
    }

    @Override
    public int getRowCount() {
        return data != null ? data.length : 0;
    }

    @Override
    public int getColumnCount() {
        return colums;
    }

    public void setColums(int colums) {
        this.colums = colums;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data != null && data.length > 0) {
            return data[rowIndex][columnIndex];
        }
        return null;
    }

    public Object[] getSelectedRow(int row) {
        if (data != null && data.length > 0) {
            return data[row];
        }
        return null;
    }

    public Object[][] getData() {
        return data;
    }

    public ColumTypes[] getColumns() {
        return headers;
    }
}
