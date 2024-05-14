package org.example.View;

import org.example.View.NewCompanyWindow.NumberOnlyFilter;
import org.example.entity.CompanyEntity;
import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;
import org.example.repository.ProductRepository;
import org.example.service.Methods;
import org.example.service.PersonService;
import org.example.service.ProductService;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.text.PlainDocument;

public class AddItemsWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldQuantity;
    private JTextField textFieldDescription;
    private JTextField textFieldValue;
    private JTextField textFieldObservation;

    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddItemsWindow frame = new AddItemsWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    /**
     * Create the frame.
     */
    public AddItemsWindow(Integer companyId, List<PersonEntity> guests, boolean isLaundry, JButton btnAtualizate) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 666, 309);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.setBackground(new Color(128, 0, 0));
        btnCancel.setForeground(new Color(255, 255, 255));

        JButton btnOk = new JButton("Ok");
        btnOk.setForeground(new Color(255, 255, 255));
        btnOk.setBackground(new Color(0, 128, 192));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 192));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(13, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(118)
                                .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                .addGap(69)
                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(109, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnCancel)
                                        .addComponent(btnOk))
                                .addContainerGap())
        );

        JLabel lblNewLabel = new JLabel("Adicionar item");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(242)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(254, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JLabel lblNewLabel_1 = new JLabel("Quantidade");

        textFieldQuantity = new JTextField();
        textFieldQuantity.setColumns(10);

        JLabel lblDescription = new JLabel("Descrição");

        textFieldDescription = new JTextField();
        textFieldDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textFieldDescription.setColumns(10);

        JLabel lblValorUni = new JLabel("Valor Un");

        textFieldValue = new JFormattedTextField();
        textFieldValue.setColumns(10);

        List<String> peopleNames = guests.stream()
                .map(PersonEntity::getName)
                .collect(Collectors.toList());
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(peopleNames.toArray(new String[0]));
        JComboBox comboBoxName = new JComboBox(comboBoxModel);

        JLabel lblObs = new JLabel("Observação");

        textFieldObservation = new JTextField();
        textFieldObservation.setColumns(10);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                                                                                .addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(199))
                                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                                .addComponent(textFieldQuantity, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(textFieldDescription, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(textFieldValue, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblValorUni, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addComponent(comboBoxName, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29)
                                                                .addComponent(textFieldObservation, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                                .addComponent(lblObs, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addGap(196))))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addComponent(lblValorUni)
                                                .addGap(6)
                                                .addComponent(textFieldValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addComponent(lblNewLabel_1)
                                                .addGap(6)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(textFieldQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textFieldDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(lblDescription))
                                .addGap(8)
                                .addComponent(lblObs)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(comboBoxName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldObservation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);

        //filtros
        PlainDocument dosQuantiy = (PlainDocument) textFieldQuantity.getDocument();
        dosQuantiy.setDocumentFilter(new NewCompanyWindow.NumberOnlyFilter());

        PlainDocument dosValue = (PlainDocument) textFieldValue.getDocument();
        dosValue.setDocumentFilter(new NewCompanyWindow.NumberOnlyFilter());

        // ações de botão
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ok = true;
                ok = Methods.isNullOrEmpty(textFieldQuantity.getText(), "campo 'Quantidade'");
                ok = Methods.isNullOrEmpty(textFieldDescription.getText(), "campo 'Descrição'");
                ok = Methods.isNullOrEmpty(textFieldValue.getText(), "valor unitário");

                if(!ok){return;}

                ok = Methods.maximumStringSize(2,textFieldQuantity.getText(),"campo 'Quantidade'");
                ok = Methods.maximumStringSize(20,textFieldDescription.getText(), "campo 'Descrição'");
                ok = Methods.minimumStringSize(3, textFieldDescription.getText(), "campo 'Descrição");
                ok = Methods.maximumStringSize(6,textFieldValue.getText(), "campo 'Valor'");
                ok = Methods.maximumStringSize(50,textFieldObservation.getText(), "campo 'Observação'");

                if(!ok){return;}

                ProductEntity productEntity = new ProductEntity();
                productEntity.setQnt(Integer.parseInt(textFieldQuantity.getText()));
                productEntity.setDescription(textFieldDescription.getText());
                productEntity.setUnValue(Double.parseDouble(textFieldValue.getText()));
                productEntity.setBedroomNumber(guests.get(0).getBedroomNumber());
                productEntity.setCompanyId(companyId);
                productEntity.setObs(textFieldObservation.getText());
                productEntity.setLaundry(isLaundry);
                String nameSelected = (String) comboBoxName.getSelectedItem();
                List<PersonEntity> nameSelectedForId = PersonService.getPeopleByNameOrCompanyName(nameSelected, "name");
                productEntity.setGuestId(nameSelectedForId.get(0).getId());


                ProductService.insertProduct(productEntity, btnAtualizate);
                dispose();
            }
        });
    }
}

