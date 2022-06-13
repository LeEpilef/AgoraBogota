/**
 *
 */
package data;

import java.util.Date;
/**
 * @author Felipe Páez González
 *
 */
public class Event {
    public String eventName;
    public String eventCategory;
    public Date eventDate;
    public String eventDescription;
    public String ticketPrice;
    public String ticketLink;

    public Event(String eventName, String eventCategory, Date eventDate, String eventDescription, String ticketPrice, String ticketLink) {
        this.eventName = eventName;
        this.eventCategory = eventCategory;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.ticketPrice = ticketPrice;
        this.ticketLink = ticketLink;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketLink() {
        return ticketLink;
    }

    public void setTicketLink(String ticketLink) {
        this.ticketLink = ticketLink;
    }
}
