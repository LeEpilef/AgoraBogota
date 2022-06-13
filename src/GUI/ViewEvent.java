/**
 * @author Felipe Páez González
 *
 */
package GUI;

import businessLogic.EditEvent;
import data.Event;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * @author Felipe Páez González
 *
 */
public class ViewEvent extends JFrame {
    private JPanel contentPane;
    private JLabel eventNameTxt;
    private JLabel eventCategoryTxt;
    private JLabel eventDateTxt;
    private JLabel ticketPriceTxt;
    private JLabel ticketLinkTxt;
    private JButton editButton;
    private JTextArea eventDescriptionTxt;
    private ArrayList<Event> listEvents;

    public ViewEvent(Event event, boolean admin, ArrayList<Event> listEvents) {
        this.setType(Type.UTILITY);
        this.listEvents = listEvents;

        this.setResizable(false);
        this.setBounds(100, 100, 650, 340);
        this.setTitle("Agora: " + event.getEventName());

        this.contentPane = new JPanel();
        contentPane.setBackground(new Color(143, 188, 143));
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        this.eventNameTxt = new JLabel();
        eventNameTxt.setForeground(new Color(255, 255, 255));
        eventNameTxt.setFont(new Font("Roboto", Font.BOLD, 20));
        eventNameTxt.setText(event.getEventName());
        eventNameTxt.setBounds(10, 11, 616, 29);
        contentPane.add(eventNameTxt);

        this.eventCategoryTxt = new JLabel();
        eventCategoryTxt.setForeground(new Color(255, 255, 255));
        eventCategoryTxt.setFont(new Font("Roboto", Font.BOLD, 12));
        eventCategoryTxt.setText(event.getEventCategory());
        eventCategoryTxt.setBounds(20, 38, 616, 20);
        contentPane.add(eventCategoryTxt);

        this.eventDateTxt = new JLabel();
        eventDateTxt.setForeground(new Color(255, 255, 255));
        eventDateTxt.setFont(new Font("Roboto", Font.PLAIN, 12));
        eventDateTxt.setText(String.valueOf(event.getEventDate()));
        eventDateTxt.setBounds(55, 210, 305, 20);
        contentPane.add(eventDateTxt);

        this.ticketPriceTxt = new JLabel();
        ticketPriceTxt.setForeground(new Color(255, 255, 255));
        ticketPriceTxt.setFont(new Font("Roboto", Font.PLAIN, 12));
        ticketPriceTxt.setText("$"+event.getTicketPrice());
        ticketPriceTxt.setBounds(55, 235, 305, 20);
        contentPane.add(ticketPriceTxt);

        this.eventDescriptionTxt = new JTextArea();
        eventDescriptionTxt.setForeground(new Color(255, 255, 255));
        eventDescriptionTxt.setBackground(new Color(153, 204, 153));
        eventDescriptionTxt.setFont(new Font("Roboto", Font.PLAIN, 14));
        eventDescriptionTxt.setText(event.getEventDescription());
        eventDescriptionTxt.setEditable(false);
        eventDescriptionTxt.setBounds(10, 70, 615, 120);
        contentPane.add(eventDescriptionTxt);

        this.ticketLinkTxt = new JLabel();
        ticketLinkTxt.setForeground(new Color(255, 255, 255));
        ticketLinkTxt.setFont(new Font("Roboto", Font.PLAIN, 12));
        ticketLinkTxt.setText(event.getTicketLink());
        ticketLinkTxt.setBounds(55, 260, 305, 20);
        contentPane.add(ticketLinkTxt);

        JLabel dateLabel = new JLabel("Fecha:");
        dateLabel.setForeground(new Color(255, 255, 255));
        dateLabel.setFont(new Font("Roboto", Font.BOLD, 12));
        dateLabel.setBounds(10, 210, 46, 20);
        contentPane.add(dateLabel);

        JLabel priceLabel = new JLabel("Precio:");
        priceLabel.setFont(new Font("Roboto", Font.BOLD, 12));
        priceLabel.setForeground(new Color(255, 255, 255));
        priceLabel.setBounds(10, 235, 46, 20);
        contentPane.add(priceLabel);

        JLabel linkLabel = new JLabel("Link:");
        linkLabel.setForeground(new Color(255, 255, 255));
        linkLabel.setFont(new Font("Roboto", Font.BOLD, 12));
        linkLabel.setBounds(10, 260, 46, 20);
        contentPane.add(linkLabel);

        if(admin) {
            editButton = new JButton("Editar");
            editButton.setForeground(new Color(0, 100, 0));
            editButton.setFont(new Font("Roboto", Font.BOLD, 12));
            editButton.setBackground(new Color(255, 255, 255));
            editButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
            editButton.setBorderPainted(false);
            editButton.setBounds(523, 231, 90, 30);
            contentPane.add(editButton);
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new EditEvent(event, listEvents);
                }
            });
        }

        this.setVisible(true);
    }
}
