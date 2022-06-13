/**
 *
 */
package businessLogic;

import GUI.EventForm;
import data.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * @author Felipe Páez González
 *
 */
public class NewEvent implements ActionListener {
    EventForm form;
    ArrayList<Event> eventList;

    public NewEvent(ArrayList<Event> eventList){
        form = new EventForm();
        this.form.loadButton.addActionListener(this);
        this.form.clearButton.addActionListener(this);}


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(form.clearButton)){
            form.limpiar();}
        if(e.getSource().equals(form.loadButton)){
            if(form.validar()) {
                form.newEventFile();
            }}}
}
