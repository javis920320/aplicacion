package WriteFiles.Excel;

import jxl.format.Colour;

public class TableExcel {

    public ColumTypes[] headers;
    public Object[][] data;
    public Colour colourHeader;
    public SuperHeader[] sHeader;

    public TableExcel(ColumTypes[] headers, Object[][] data) {
        this.headers = headers;
        this.data = data;
        this.colourHeader = Colour.ICE_BLUE;
    }

    public TableExcel(ColumTypes[] headers, Object[][] data, Colour colourHeader) {
        this.headers = headers;
        this.data = data;
        this.colourHeader = colourHeader;
    }

    public void setSuperHeaders(SuperHeader[] sHeader) {
        this.sHeader = sHeader;
    }

}
