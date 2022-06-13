/**
 *
 */
package GUI;

import businessLogic.EventManager;
import businessLogic.Runner;
import data.Event;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 * @author Felipe Páez González
 *
 */
public class MainFrame {
    private JFrame frmAgora;
    private JTable eventsTable;
    private JPanel tailPanel;
    private JPanel tablePanel;
    private JLabel labelTable;
    private JScrollPane scrollPanel;
    private boolean admin;
    private ArrayList<Event> eventList;

    public MainFrame(EventManager manager, boolean admin) {
        this.admin = admin;
        this.eventList = manager.getEventList();

        this.frmAgora = new JFrame();
        frmAgora.getContentPane().setBackground(new Color(143, 188, 143));
        frmAgora.setFont(new Font("Roboto", Font.PLAIN, 12));
        frmAgora.setType(Window.Type.UTILITY);
        frmAgora.getContentPane().setFont(new Font("Roboto", Font.PLAIN, 11));
        frmAgora.setResizable(false);
        frmAgora.setTitle("Agora");
        frmAgora.setBounds(100, 100, 500, 400);
        frmAgora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.labelTable = new JLabel("Eventos Bogotá");
        labelTable.setBounds(new Rectangle(0, 0, 5, 5));
        labelTable.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        labelTable.setForeground(new Color(255, 255, 255));
        labelTable.setBackground(new Color(143, 188, 143));
        labelTable.setFont(new Font("Roboto", Font.BOLD, 12));
        labelTable.setHorizontalAlignment(SwingConstants.CENTER);
        frmAgora.getContentPane().add(labelTable, BorderLayout.NORTH);

        this.tablePanel = new JPanel();
        tablePanel.setBackground(new Color(153, 204, 153));
        tablePanel.setBorder(null);
        tablePanel.setLayout(new BorderLayout(0, 0));
        frmAgora.getContentPane().add(tablePanel, BorderLayout.CENTER);

        EventsTableModel tableModel = new EventsTableModel(eventList);
        TableRowSorter tableRowSorter = new TableRowSorter(tableModel);
        this.eventsTable = new JTable(tableModel);
        eventsTable.setRowSorter(tableRowSorter);
        eventsTable.setSelectionBackground(new Color(240, 255, 240));
        eventsTable.setBorder(null);
        eventsTable.setForeground(new Color(0, 100, 0));
        eventsTable.setGridColor(new Color(0, 100, 0));
        eventsTable.setFont(new Font("Roboto", Font.BOLD, 12));
        eventsTable.setBackground(new Color(255, 255, 255));

        this.scrollPanel = new JScrollPane(eventsTable);
        scrollPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        scrollPanel.setBackground(new Color(143, 188, 143));
        scrollPanel.setFont(new Font("Roboto", Font.PLAIN, 12));
        tablePanel.removeAll();
        tablePanel.add(scrollPanel, "Center");
        tablePanel.repaint();
        tablePanel.setVisible(true);

        eventsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indexEvent = eventsTable.getSelectedRow();
                System.out.println(indexEvent);
                new ViewEvent(eventList.get(indexEvent), admin, eventList);
            }
        });

        this.tailPanel = new JPanel();
        tailPanel.setBackground(new Color(143, 188, 143));
        tailPanel.setBorder(null);
        frmAgora.getContentPane().add(tailPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Inicio");
        startButton.setBorder(new MatteBorder(4, 17, 4, 17, (Color) new Color(255, 255, 255)));
        startButton.setForeground(new Color(0, 100, 0));
        startButton.setBorderPainted(false);
        startButton.setBackground(new Color(255, 255, 255));
        startButton.setFont(new Font("Roboto", Font.BOLD, 12));
        tailPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runner.run();
                frmAgora.setVisible(false);
            }
        });

        if(admin){
            JButton NewButton = new JButton("Nuevo");
            NewButton.setBorder(new MatteBorder(4, 15, 4, 15, (Color) new Color(255, 255, 255)));
            NewButton.setBackground(new Color(255, 255, 255));
            NewButton.setForeground(new Color(0, 100, 0));
            NewButton.setFont(new Font("Roboto", Font.BOLD, 12));
            NewButton.setBorderPainted(false);
            tailPanel.add(NewButton);
            NewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    manager.createEvent();
                }
            });
        }

        tailPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        frmAgora.setVisible(true);
    }
}

