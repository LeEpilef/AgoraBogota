/**
 *
 */
package businessLogic;

import data.Event;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Felipe Páez González
 *
 */
public class EventManager{
    private ArrayList<Event> eventList;
    private String eventsFileName;

    public EventManager(String eventsFileName){
        this.eventList = new ArrayList<Event>();
        this.eventsFileName = eventsFileName;
    }

    public void createEvent(){
        NewEvent event = new NewEvent(this.eventList);
    }

    public void loadRegisters(){
        File inFile = new File(this.eventsFileName);
        try {
            Scanner sc = new Scanner(inFile);
            processEventData(sc);}
        catch (FileNotFoundException e) {
            System.out.println("Archivo inexistente -- " + this.eventsFileName);
            System.exit(0);}
    }

    private void processEventData(Scanner sc) {
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner scLine  = new Scanner(line);
            scLine.useDelimiter(",");

            String eventName = scLine.next().trim();
            String eventCategory = scLine.next().trim();
            Date eventDate = processDate(scLine.next().trim());
            String eventDescription = scLine.next().trim();
            String ticketPrice = scLine.next().trim();
            String ticketLink = scLine.next().trim();

            scLine.close();
            this.eventList.add(new Event(eventName,eventCategory,eventDate,eventDescription,ticketPrice,ticketLink));
        }}

    private Date processDate(String date){
        Scanner dSc = new Scanner(date);
        dSc.useDelimiter("/");

        int day = Integer.parseInt(dSc.next());
        int month = Integer.parseInt(dSc.next());
        month -=1; //Los meses empiezan desde el 0.
        int year = Integer.parseInt(dSc.next());
        year -= 1900; //La cuenta empieza en 1900.

        Date eventDate = new Date(year,month,day);
        return eventDate;
    }

    public static void updateFile(ArrayList<Event> eventList){
        String rute ="data/events.csv";
        try {
            File file = new File(rute);

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for(Event evt : eventList) {
                bw.write(evt.getEventName());
                bw.write(',' + evt.getEventCategory());
                java.util.Date date = evt.getEventDate();
                bw.write(',' + DateFormat.getDateInstance().format(date));
                bw.write(',' + evt.getEventDescription());
                bw.write(',' + evt.getTicketPrice());
                bw.write(',' + evt.ticketLink + '\n');
            }
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "El registro de eventos fue actualizado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    public ArrayList getEventList(){
        return eventList;
    }
}


