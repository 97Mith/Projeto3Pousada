package org.example.View;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import org.example.entity.BedroomEntity;
import org.example.entity.CompanyEntity;
import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;
import org.example.repository.CompanyRepository;
import org.example.repository.PersonRepository;
import org.example.service.BedroomService;
import org.example.service.CompanyService;
import org.example.service.PersonService;
import org.example.service.ProductService;

import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class BedroomWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableGuests;
    private JTable tableProducts;
    private JTable tableLaundry;
    private JTextField textFieldDiscount;

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

        BedroomEntity bedroomEntity = BedroomService.getById(bedroomNumber);
        Integer capacity = bedroomEntity.getCapacity();

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

        List<ProductEntity> laundry = ProductService.getProductsInRoom(bedroomNumber, true);
        DefaultTableModel modelLaundry = ProductService.createProductTable(laundry);
        tableLaundry = new JTable(modelLaundry);
        scrollPane_1_1_1_1.setViewportView(tableLaundry);
        tableLaundry.getColumnModel().getColumn(0).setPreferredWidth(1);
        tableLaundry.getColumnModel().getColumn(1).setPreferredWidth(50);
        tableLaundry.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableLaundry.getColumnModel().getColumn(3).setPreferredWidth(350);
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

        List<ProductEntity> products = ProductService.getProductsInRoom(bedroomNumber, false);
        DefaultTableModel modelProducts = ProductService.createProductTable(products);
        tableProducts = new JTable(modelProducts);
        scrollPane_1_1_1.setViewportView(tableProducts);
        tableProducts.getColumnModel().getColumn(0).setPreferredWidth(1);
        tableProducts.getColumnModel().getColumn(1).setPreferredWidth(50);
        tableProducts.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableProducts.getColumnModel().getColumn(3).setPreferredWidth(350);

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

        JScrollPane scrollPaneGuests = new JScrollPane();

        JLabel lblCheckIn = new JLabel("Check In");

        JLabel lblCheckOut = new JLabel("Check Out");

        JLabel lblNewLabel = new JLabel("Hospedes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JButton btnDoneStay = new JButton("Encerrar Estada");
        btnDoneStay.setForeground(Color.WHITE);
        btnDoneStay.setBackground(new Color(0, 128, 192));

        JCheckBox cbDiscount = new JCheckBox("Aplicar descontos");


        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(215, 179, 11));

        JLabel lblTotalRs = new JLabel("Total:  R$");
        lblTotalRs.setFont(new Font("Tahoma", Font.PLAIN, 22));

        JLabel lblStayValue = new JLabel("150,00");
        lblStayValue.setFont(new Font("Tahoma", Font.PLAIN, 22));

        JLabel lblNightValue = new JLabel("Valor diária                R$");

        JLabel lblNightV = new JLabel("0,00");
        GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
        gl_panel_2_1.setHorizontalGroup(
                gl_panel_2_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_2_1.createSequentialGroup()
                                .addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_2_1.createSequentialGroup()
                                                .addGap(19)
                                                .addComponent(lblTotalRs)
                                                .addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addComponent(lblStayValue, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.TRAILING, gl_panel_2_1.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblNightValue, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNightV, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        gl_panel_2_1.setVerticalGroup(
                gl_panel_2_1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_2_1.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNightV)
                                        .addComponent(lblNightValue))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblTotalRs)
                                        .addComponent(lblStayValue, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
        );

        isChecked(cbDiscount, lblStayValue);

        panel_2_1.setLayout(gl_panel_2_1);

        JButton btnUpdate = new JButton();

        JButton btnAdd = new JButton("+  Adicionar");
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(new Color(0, 128, 192));

        JButton btnRemoveGuest = new JButton("-  Remover");
        btnRemoveGuest.setForeground(Color.WHITE);
        btnRemoveGuest.setBackground(new Color(128, 0, 0));

        textFieldDiscount = new JTextField();
        textFieldDiscount.setColumns(10);

        JLabel lblRs = new JLabel("R$");

        JLabel lblDesconto_1 = new JLabel("Desconto");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.TRAILING)
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
                                .addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnRemoveGuest, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPaneGuests, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(dateCheckIn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addComponent(dateCheckOut, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(cbDiscount)
                                                .addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                                .addComponent(lblRs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(textFieldDiscount, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addContainerGap(179, Short.MAX_VALUE))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap(207, Short.MAX_VALUE)
                                .addComponent(lblDesconto_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel)
                                .addGap(8)
                                .addComponent(scrollPaneGuests, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(btnRemoveGuest))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCheckIn)
                                        .addComponent(lblCheckOut))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(dateCheckOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateCheckIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblDesconto_1)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(cbDiscount)
                                        .addComponent(textFieldDiscount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRs))
                                .addGap(18)
                                .addComponent(btnDoneStay)
                                .addContainerGap())
        );

        List<PersonEntity> guests = BedroomService.loadAllInBedroom(bedroomNumber);
        DefaultTableModel modelGuests = PersonService.createPeopleTable(guests);
        tableGuests = new JTable();
        scrollPaneGuests.setViewportView(tableGuests);
        panel_1.setLayout(gl_panel_1);
        tableGuests.setModel(modelGuests);
        formatTableStandard(tableGuests);

        JLabel lbl = new JLabel("Quarto");
        lbl.setForeground(new Color(255, 255, 255));
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lbl_1 = new JLabel(String.valueOf(bedroomNumber));
        lbl_1.setForeground(Color.WHITE);
        lbl_1.setFont(new Font("Verdana", Font.PLAIN, 20));

        JLabel lblCompany = new JLabel("Sem empresa");
        if(!guests.isEmpty()){String companyName = guests.get(0).getCompanyName(); lblCompany.setText(companyName);}

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

        CompanyEntity company = CompanyRepository.findOneByName(lblCompany.getText());

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                SwingUtilities.invokeLater(() -> {
                    new BedroomWindow(bedroomNumber).setVisible(true);
                });
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO fazer ele ler o atributo capacity
                if(guests.size() > capacity - 1 ){
                    JOptionPane.showMessageDialog(
                            null, "O quarto está lotado.",
                            "Aviso", JOptionPane.INFORMATION_MESSAGE
                    );
                }else{
                    new PersonManagerWindow(bedroomNumber, btnUpdate).setVisible(true);
                }

            }
        });

        btnRemoveGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int selectedRow = tableGuests.getSelectedRow();
                if (selectedRow != -1) {
                    PersonService.updateBedroom((int) modelGuests.getValueAt(selectedRow, 0),0);
                    btnUpdate.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
                }
            }
        });

        btnRemoveProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int selectedRow = tableProducts.getSelectedRow();
                if (selectedRow != -1) {
                    ProductEntity p = ProductService.getByRegister((int) modelProducts.getValueAt(selectedRow, 0));
                    ProductService.delete(p);
                    btnUpdate.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
                }
            }
        });

        btnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer companyId = company.getId();
                new AddItemsWindow(companyId, guests, false, btnUpdate).setVisible(true);
            }
        });

        btnAddCloath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer companyId = company.getId();
                new AddItemsWindow(companyId, guests, true, btnUpdate).setVisible(true);
            }
        });

        btnRemoveCloath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int selectedRow = tableLaundry.getSelectedRow();
                if (selectedRow != -1) {
                    ProductEntity p = ProductService.getByRegister((int) modelLaundry.getValueAt(selectedRow, 0));
                    ProductService.delete(p);
                    btnUpdate.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
                }
            }
        });
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
    public static void formatTableStandard(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(230); // Nome
        table.getColumnModel().getColumn(2).setPreferredWidth(230); // Sobrenome
        table.getColumnModel().getColumn(3).setPreferredWidth(230); // Telefone
        //table.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer(phoneNumberFormatter));
        table.getColumnModel().getColumn(4).setPreferredWidth(0); // Quarto
        table.getColumnModel().getColumn(5).setPreferredWidth(298); // Empresa
        table.getColumnModel().getColumn(6).setPreferredWidth(170); // Cpf
        //table.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer(cpfFormatter)); // Cpf
    }
}
