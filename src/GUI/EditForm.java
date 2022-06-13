/**
 *
 */
package GUI;

import com.toedter.calendar.JDateChooser;
import data.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
/**
 * @author Felipe Páez González
 *
 */
public class EditForm {
    public JFrame frame;
    JLabel labelName;
    JLabel labelCategory;
    JLabel labelDate;
    JLabel labelDescription;
    JLabel labelPrice;
    JLabel labelLink;
    JTextField txtName;
    String[] categorys = {"Seleccionar","Entretenimiento","Deportes","Cultura","Conciertos","Infantil"};
    JComboBox<String> boxCategory;
    JDateChooser jdDate;
    JTextArea txtDescription;
    JTextField txtPrice;
    JTextField txtLink;
    public JButton loadButton;
    public JButton clearButton;
    Event event;

    public EditForm(Event event){
        this.event = event;

        this.frame = new JFrame("Agora_EditarEvento");
        frame.getContentPane().setBackground(new Color(143, 188, 143));
        frame.setResizable(false);
        frame.setType(Window.Type.UTILITY);
        frame.setSize(390,370);
        frame.getContentPane().setLayout(null);

        this.labelName = new JLabel("Nombre");
        labelName.setForeground(new Color(255, 255, 255));
        labelName.setFont(new Font("Roboto", Font.BOLD, 12));
        labelName.setBounds(35,30,84,30);
        frame.getContentPane().add(labelName);

        this.labelCategory = new JLabel("Categoría");
        labelCategory.setForeground(new Color(255, 255, 255));
        labelCategory.setFont(new Font("Roboto", Font.BOLD, 12));
        labelCategory.setBounds(35,70,84,30);
        frame.add(labelCategory);

        this.labelDate = new JLabel("Fecha");
        labelDate.setForeground(new Color(255, 255, 255));
        labelDate.setFont(new Font("Roboto", Font.BOLD, 12));
        labelDate.setBounds(35,110,84,30);
        frame.add(labelDate);

        this.labelDescription = new JLabel("Descripción");
        labelDescription.setForeground(new Color(255, 255, 255));
        labelDescription.setFont(new Font("Roboto", Font.BOLD, 12));
        labelDescription.setBounds(35,150,84,30);
        frame.add(labelDescription);

        this.labelPrice = new JLabel("Precio");
        labelPrice.setForeground(new Color(255, 255, 255));
        labelPrice.setFont(new Font("Roboto", Font.BOLD, 12));
        labelPrice.setBounds(35,190,84,30);
        frame.add(labelPrice);

        this.labelLink = new JLabel("Enlace");
        labelLink.setForeground(new Color(255, 255, 255));
        labelLink.setFont(new Font("Roboto", Font.BOLD, 12));
        labelLink.setBounds(35,230,84,30);
        frame.add(labelLink);

        this.txtName = new JTextField();
        txtName.setBorder(null);
        txtName.setFont(new Font("Roboto", Font.BOLD, 12));
        txtName.setForeground(new Color(255, 255, 255));
        txtName.setCaretColor(new Color(143, 188, 143));
        txtName.setBackground(new Color(153, 204, 153));
        txtName.setBounds(135,30,200,30);
        txtName.setText(event.getEventName());
        frame.add(txtName);

        this.boxCategory = new JComboBox<String>(categorys);
        boxCategory.setBorder(null);
        boxCategory.setBackground(new Color(153, 204, 153));
        boxCategory.setFont(new Font("Roboto", Font.BOLD, 12));
        boxCategory.setForeground(new Color(255, 255, 255));
        boxCategory.setBounds(135,70,200,30);
        switch (event.getEventCategory()) {
            case "Entretenimiento":
                boxCategory.setSelectedIndex(1);
                break;
            case "Deportes":
                boxCategory.setSelectedIndex(2);
                break;
            case "Cultura":
                boxCategory.setSelectedIndex(3);
                break;
            case "Conciertos":
                boxCategory.setSelectedIndex(4);
                break;
            case "Infantil":
                boxCategory.setSelectedIndex(5);
                break;
            default:
                boxCategory.setSelectedIndex(0);
                break;
        }
        boxCategory.setBounds(135,70,200,30);
        frame.add(boxCategory);

        this.jdDate = new JDateChooser();
        jdDate.setBounds(135,110,200,30);
        jdDate.setDate(event.getEventDate());
        frame.add(jdDate);

        this.txtDescription = new JTextArea();
        txtDescription.setFont(new Font("Roboto", Font.BOLD, 12));
        txtDescription.setForeground(new Color(255, 255, 255));
        txtDescription.setCaretColor(new Color(143, 188, 143));
        txtDescription.setBackground(new Color(153, 204, 153));
        txtDescription.setBounds(135,150,200,30);
        txtDescription.setText(event.getEventDescription());
        frame.add(txtDescription);

        this.txtPrice = new JTextField();
        txtPrice.setBorder(null);
        txtPrice.setFont(new Font("Roboto", Font.BOLD, 12));
        txtPrice.setForeground(new Color(255, 255, 255));
        txtPrice.setCaretColor(new Color(143, 188, 143));
        txtPrice.setBackground(new Color(153, 204, 153));
        txtPrice.setBounds(135,190,200,30);
        txtPriceKeyTyped(txtPrice);
        txtPrice.setText(event.getTicketPrice());
        frame.add(txtPrice);

        this.txtLink = new JTextField();
        txtLink.setBorder(null);
        txtLink.setFont(new Font("Roboto", Font.BOLD, 12));
        txtLink.setForeground(new Color(255, 255, 255));
        txtLink.setCaretColor(new Color(143, 188, 143));
        txtLink.setBackground(new Color(153, 204, 153));
        txtLink.setBounds(135,230,200,30);
        txtLink.setText(event.getTicketLink());
        frame.add(txtLink);

        this.loadButton = new JButton("Guardar");
        loadButton.setForeground(new Color(0, 100, 0));
        loadButton.setFont(new Font("Roboto", Font.BOLD, 12));
        loadButton.setBorderPainted(false);
        loadButton.setBorder(null);
        loadButton.setBackground(new Color(255, 255, 255));
        loadButton.setBounds(135,270,95,30);
        frame.add(loadButton);

        this.clearButton = new JButton("Limpiar");
        clearButton.setForeground(new Color(0, 100, 0));
        clearButton.setFont(new Font("Roboto", Font.BOLD, 12));
        clearButton.setBorderPainted(false);
        clearButton.setBorder(null);
        clearButton.setBackground(new Color(255, 255, 255));
        clearButton.setBounds(240,270,95,30);
        frame.add(clearButton);

        frame.setVisible(true);
    }
    public void limpiar(){
        txtName.setText("");
        boxCategory.setSelectedIndex(0);
        jdDate.setDate(null);
        txtDescription.setText("");
        txtPrice.setText("");
        txtLink.setText("");
    }

    public boolean validar() {
        if (Objects.equals(txtName.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del evento", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Objects.equals(boxCategory.getSelectedIndex(), 0)) {
            JOptionPane.showMessageDialog(null, "Seleccione la categoría del evento","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Objects.equals(String.valueOf(jdDate.getDate()), "")) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha del evento","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Objects.equals(txtDescription.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Ingrese la descripción del evento","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Objects.equals(txtPrice.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Ingrese el precio del evento","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Objects.equals(txtLink.getText(), "")) {
            JOptionPane.showMessageDialog(null,"Ingrese el link del evento","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else
            return true;
    }

    private void txtPriceKeyTyped(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }

    public void updateClass(){
        this.event.setEventName(txtName.getText());
        this.event.setEventDate(jdDate.getDate());
        this.event.setEventCategory(categorys[boxCategory.getSelectedIndex()]);
        this.event.setEventDescription(txtDescription.getText());
        this.event.setTicketPrice(txtPrice.getText());
        this.event.setTicketLink(txtLink.getText());
    }
}

