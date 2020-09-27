package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

public class TableText {
    public static void main(String[] args) {
        // TextTable tt = new TextTable(columnNames, data);
        // tt.printTable();
        // System.out.format("%32s%10d%16s","abc", 1, "ced");

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 5);
        System.out.println(calendar.getTimeInMillis() / 1000);

    }
}
