/**
 *
 */
package businessLogic;

import GUI.EditForm;
import data.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * @author Felipe Páez González
 *
 */
public class EditEvent implements ActionListener {
    EditForm form;
    ArrayList<Event> eventList;
        public EditEvent(Event event, ArrayList<Event> eventList){
            this.eventList = eventList;
            form = new EditForm(event);
            this.form.loadButton.addActionListener(this);
            this.form.clearButton.addActionListener(this);}


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(form.clearButton)){
                form.limpiar();}
            if(e.getSource().equals(form.loadButton)){
                if(form.validar()) {
                    form.updateClass();
                    EventManager.updateFile(eventList);
                    form.frame.setVisible(false);
                }}}
}
