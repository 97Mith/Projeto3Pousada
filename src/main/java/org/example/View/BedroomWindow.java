package org.example.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class BedroomWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableGuests;
    private JTable tableProducts;
    private JTable tableLaundry;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BedroomWindow frame = new BedroomWindow(1);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BedroomWindow(Integer bedroomNumber) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 255));

        JPanel panel_1 = new JPanel();

        JDateChooser dateCheckIn = new JDateChooser();
        dateCheckIn.setDateFormatString("d '/' MM '/' y");
        JDateChooser dateCheckOut = new JDateChooser();
        dateCheckOut.setDateFormatString("d '/' MM '/' y");

        panel_1.add(dateCheckIn);
        panel_1.add(dateCheckOut);

        JPanel panel_1_1 = new JPanel();

        JPanel panel_1_1_1 = new JPanel();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                                .addGap(1))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                .addGap(10)
                                .addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(20)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                                .addContainerGap())))
        );

        JLabel lblLavanderia = new JLabel("Lavanderia");
        lblLavanderia.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JScrollPane scrollPane_1_1_1_1 = new JScrollPane();

        JPanel panel_2_2 = new JPanel();
        panel_2_2.setBackground(new Color(215, 179, 11));

        JLabel lblNewLabel_1_3 = new JLabel("Total:  R$");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));

        JLabel lblLaundryValue = new JLabel("150,00");
        lblLaundryValue.setFont(new Font("Tahoma", Font.PLAIN, 22));
        GroupLayout gl_panel_2_2 = new GroupLayout(panel_2_2);
        gl_panel_2_2.setHorizontalGroup(
                gl_panel_2_2.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(Alignment.TRAILING, gl_panel_2_2.createSequentialGroup()
                                .addGap(30)
                                .addComponent(lblNewLabel_1_3)
                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(lblLaundryValue, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(20))
        );
        gl_panel_2_2.setVerticalGroup(
                gl_panel_2_2.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addGroup(gl_panel_2_2.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_2_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblLaundryValue, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1_3))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        panel_2_2.setLayout(gl_panel_2_2);

        JButton btnAddCloath = new JButton("+  Roupa");
        btnAddCloath.setForeground(Color.WHITE);
        btnAddCloath.setBackground(new Color(0, 128, 192));

        JButton btnRemoveCloath = new JButton("-  Remover");
        btnRemoveCloath.setForeground(Color.WHITE);
        btnRemoveCloath.setBackground(new Color(128, 0, 0));
        GroupLayout gl_panel_1_1_1 = new GroupLayout(panel_1_1_1);
        gl_panel_1_1_1.setHorizontalGroup(
                gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1_1_1.createSequentialGroup()
                                .addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1_1_1.createSequentialGroup()
                                                .addGap(100)
                                                .addComponent(lblLavanderia, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane_1_1_1_1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(panel_2_2, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addGroup(gl_panel_1_1_1.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnAddCloath, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                                .addGap(18)
                                                .addComponent(btnRemoveCloath, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        gl_panel_1_1_1.setVerticalGroup(
                gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1_1_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblLavanderia, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(6)
                                .addComponent(scrollPane_1_1_1_1, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addGap(65)
                                .addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(29)
                                .addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnAddCloath)
                                        .addComponent(btnRemoveCloath))
                                .addGap(44))
        );

        tableLaundry = new JTable();
        scrollPane_1_1_1_1.setViewportView(tableLaundry);
        panel_1_1_1.setLayout(gl_panel_1_1_1);

        JLabel lblConsumo = new JLabel("Consumo");
        lblConsumo.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JScrollPane scrollPane_1_1_1 = new JScrollPane();

        JButton btnAddProduct = new JButton("+  Produto");
        btnAddProduct.setForeground(new Color(255, 255, 255));
        btnAddProduct.setBackground(new Color(0, 128, 192));

        JButton btnRemoveProduct = new JButton("-  Remover");
        btnRemoveProduct.setForeground(Color.WHITE);
        btnRemoveProduct.setBackground(new Color(128, 0, 0));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(215, 179, 11));
        GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
        gl_panel_1_1.setHorizontalGroup(
                gl_panel_1_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane_1_1_1, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(gl_panel_1_1.createSequentialGroup()
                                .addGap(110)
                                .addComponent(lblConsumo, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addGap(94))
                        .addGroup(gl_panel_1_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAddProduct, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addGap(48)
                                .addComponent(btnRemoveProduct, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(gl_panel_1_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addGap(12))
        );
        gl_panel_1_1.setVerticalGroup(
                gl_panel_1_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane_1_1_1, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addGap(69)
                                .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(26)
                                .addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnAddProduct)
                                        .addComponent(btnRemoveProduct))
                                .addGap(43))
        );

        tableProducts = new JTable();
        scrollPane_1_1_1.setViewportView(tableProducts);

        JLabel lblNewLabel_1 = new JLabel("Total:  R$");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));

        JLabel lblProductValue = new JLabel("150,00");
        lblProductValue.setFont(new Font("Tahoma", Font.PLAIN, 22));
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
                                .addGap(30)
                                .addComponent(lblNewLabel_1)
                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(lblProductValue, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(20))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblProductValue, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        panel_2.setLayout(gl_panel_2);
        panel_1_1.setLayout(gl_panel_1_1);

        JScrollPane scrollPane_1_1 = new JScrollPane();

        JLabel lblCheckIn = new JLabel("Check In");

        JLabel lblCheckOut = new JLabel("Check Out");

        JLabel lblNewLabel = new JLabel("Hospedes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JButton btnDoneStay = new JButton("Encerrar Estada");
        btnDoneStay.setForeground(Color.WHITE);
        btnDoneStay.setBackground(new Color(0, 128, 192));

        JCheckBox isPaid = new JCheckBox("Diarias já foram pagas na reserva");


        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(215, 179, 11));

        JLabel lblNewLabel_1_2 = new JLabel("Total:  R$");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));

        JLabel lblStayValue = new JLabel("150,00");
        lblStayValue.setFont(new Font("Tahoma", Font.PLAIN, 22));
        GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
        gl_panel_2_1.setHorizontalGroup(
                gl_panel_2_1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addGroup(Alignment.TRAILING, gl_panel_2_1.createSequentialGroup()
                                .addGap(30)
                                .addComponent(lblNewLabel_1_2)
                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(lblStayValue, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(20))
        );
        gl_panel_2_1.setVerticalGroup(
                gl_panel_2_1.createParallelGroup(Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addGroup(gl_panel_2_1.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblStayValue, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1_2))
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        isChecked(isPaid, lblStayValue);

        panel_2_1.setLayout(gl_panel_2_1);

        JButton btnAdd = new JButton("+  Adicionar");
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(new Color(0, 128, 192));

        JButton btnRemoveProduct_1 = new JButton("-  Remover");
        btnRemoveProduct_1.setForeground(Color.WHITE);
        btnRemoveProduct_1.setBackground(new Color(128, 0, 0));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(34)
                                .addComponent(lblCheckIn, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addComponent(lblCheckOut, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addGap(30))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(127)
                                .addComponent(lblNewLabel)
                                .addContainerGap(88, Short.MAX_VALUE))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(85)
                                .addComponent(btnDoneStay, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addGap(87))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(scrollPane_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                        .addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
                                                .addComponent(dateCheckIn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(dateCheckOut, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(isPaid, Alignment.LEADING))
                                .addContainerGap())
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnRemoveProduct_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel)
                                .addGap(8)
                                .addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(btnRemoveProduct_1))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCheckIn)
                                        .addComponent(lblCheckOut))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(dateCheckOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateCheckIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(isPaid)
                                .addGap(18)
                                .addComponent(btnDoneStay)
                                .addContainerGap())
        );

        tableGuests = new JTable();
        scrollPane_1_1.setViewportView(tableGuests);
        panel_1.setLayout(gl_panel_1);

        JLabel lbl = new JLabel("Quarto");
        lbl.setForeground(new Color(255, 255, 255));
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lbl_1 = new JLabel("1");
        lbl_1.setForeground(Color.WHITE);
        lbl_1.setFont(new Font("Verdana", Font.PLAIN, 20));

        JLabel lblCompany = new JLabel("Empresa");
        lblCompany.setForeground(Color.WHITE);
        lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(21)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(73)
                                                .addComponent(lbl_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lbl, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                                .addComponent(lblCompany, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(23)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lbl_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCompany))
                                        .addComponent(lbl)))
        );
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
    public void isChecked(JCheckBox checkBox, JLabel label) {
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setText("0,00");
                }
            }
        });
    }
}
