package GUI;

import data.Event;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class EventsTableModel extends AbstractTableModel {
    protected ArrayList<Event> eventList;
    protected String [] columnNames = new String[]{"Nombre","Categoría","Fecha","Precio"};
    protected Class[] columnClasses = new Class[]{String.class,String.class, Date.class, int.class};

    public EventsTableModel(ArrayList<Event> eventList){
        this.eventList = eventList;
    }

    @Override
    public int getRowCount() {
        return this.eventList.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Event e = (Event) this.eventList.get(rowIndex);
        switch (columnIndex){
            case 0: return e.getEventName();
            case 1: return e.getEventCategory();
            case 2: return e.getEventDate();
            case 3: return Integer.parseInt(e.getTicketPrice());
            default: return null;
        }}

    public String getColumnName(int col) {
        return columnNames[col];
    }
}
