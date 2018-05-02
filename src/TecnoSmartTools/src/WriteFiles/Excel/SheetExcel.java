package WriteFiles.Excel;

import java.util.ArrayList;
import java.util.List;

public class SheetExcel {

    public String sheetName;
    public List<TableExcel> tables;

    public SheetExcel(String sheetName, List<TableExcel> tables) {
        this.sheetName = sheetName;
        this.tables = tables;
    }

    public SheetExcel(String sheetName, TableExcel table) {
        this.sheetName = sheetName;
        this.tables = new ArrayList<>();
        tables.add(table);
    }
}
