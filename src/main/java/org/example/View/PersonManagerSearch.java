package org.example.View;

import org.example.entity.PersonEntity;
import org.example.service.PersonService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

import static org.example.View.CompanyManagerWindow.formatation;

public class PersonManagerSearch extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtSearch;
    private JTable table;

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PersonManagerSearch frame = new PersonManagerSearch("Vicente");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    public PersonManagerSearch(String name, String type, Integer bedroomNumber) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 128, 255));

        JComboBox comboBoxSearchByCompany = new JComboBox(PersonService.getAllCompanyNames(true));
        comboBoxSearchByCompany.setToolTipText("Empresa...");

        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
        txtSearch.setForeground(Color.GRAY);
        txtSearch.setText("Pesquisar...");
        txtSearch.setColumns(10);
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtSearch.getText().equals("Pesquisar...")) {
                    txtSearch.setText("");
                    txtSearch.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtSearch.getText().isEmpty()) {
                    txtSearch.setForeground(Color.GRAY); // Volta a cor cinza se o campo estiver vazio ao perder o foco
                    txtSearch.setText("Pesquisar...");
                }
            }
        });

        JButton btnSearch = new JButton("Ir");
        btnSearch.setBackground(new Color(0, 128, 255));
        btnSearch.setForeground(new Color(255, 255, 255));

        JButton btnNewGuest = new JButton("+ Novo Hospede");
        btnNewGuest.setForeground(Color.WHITE);
        btnNewGuest.setBackground(new Color(0, 128, 255));

        JButton btnAtualizate = new JButton("Atualizar...");
        btnAtualizate.setForeground(Color.WHITE);
        btnAtualizate.setBackground(new Color(0, 128, 255));

        JPanel panel = new JPanel();

        JPanel panel_1 = new JPanel();

        JButton btnDelete = new JButton("Excluir");
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(128, 0, 0));

        JButton btnEdit = new JButton("Editar");
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBackground(new Color(0, 128, 255));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(comboBoxSearchByCompany, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnSearch)
                                                .addGap(25))
                                        .addComponent(topPanel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewGuest)
                                                .addGap(18)
                                                .addComponent(btnAtualizate, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                .addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch)
                                        .addComponent(comboBoxSearchByCompany, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewGuest)
                                        .addComponent(btnAtualizate)
                                        .addComponent(btnDelete)
                                        .addComponent(btnEdit))
                                .addGap(12)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        );

        table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(table);

        List<PersonEntity> people = PersonService.getPeopleByNameOrCompanyName(name, type);
        DefaultTableModel model = PersonService.createPeopleTable(people);
        MaskFormatter phoneNumberFormatter = formatation("+55 (##) ##### ####");
        MaskFormatter cpfFormatter = formatation("###.###.###-##");

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Evita que as colunas sejam redimensionadas automaticamente

        // Define o tamanho preferencial das colunas
        table.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(230); // Nome
        table.getColumnModel().getColumn(2).setPreferredWidth(390); // Sobrenome
        table.getColumnModel().getColumn(3).setPreferredWidth(230); // Telefone
        table.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer(phoneNumberFormatter));
        table.getColumnModel().getColumn(4).setPreferredWidth(130); // Quarto
        table.getColumnModel().getColumn(5).setPreferredWidth(298); // Empresa
        table.getColumnModel().getColumn(6).setPreferredWidth(170); // Cpf
        table.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer(cpfFormatter)); // Cpf


        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(scrollPane)
                                .addGap(10))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(scrollPane))
        );
        panel.setLayout(gl_panel);

        JLabel lblRecord = new JLabel("Total de registros:");

        int total = people.size();
        JLabel lblTotalOfRecords = new JLabel(String.valueOf(total));

        JButton btnOk = new JButton("Ok");
        btnOk.setForeground(Color.WHITE);
        btnOk.setBackground(new Color(0, 128, 255));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblRecord)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblTotalOfRecords, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                                .addComponent(btnOk)
                                .addContainerGap())
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblRecord)
                                        .addComponent(lblTotalOfRecords)
                                        .addComponent(btnOk))
                                .addContainerGap())
        );
        panel_1.setLayout(gl_panel_1);

        JLabel lblTitle = new JLabel("Hospedes");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setFont(new Font("Verdana", Font.PLAIN, 23));
        GroupLayout gl_topPanel = new GroupLayout(topPanel);
        gl_topPanel.setHorizontalGroup(
                gl_topPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_topPanel.createSequentialGroup()
                                .addGap(18)
                                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(231, Short.MAX_VALUE))
        );
        gl_topPanel.setVerticalGroup(
                gl_topPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_topPanel.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTitle)
                                .addContainerGap())
        );
        topPanel.setLayout(gl_topPanel);
        contentPane.setLayout(gl_contentPane);

        btnNewGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonEntity personEntity = new PersonEntity();
                NewPersonWindow newGuestWindow = new NewPersonWindow(personEntity, btnAtualizate);
                newGuestWindow.setVisible(true);
            }
        });
        btnEdit.addActionListener(e -> {
            final int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                PersonEntity branch = PersonService.getById((int) model.getValueAt(selectedRow, 0));

                new NewPersonWindow(branch, btnAtualizate).setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
            }
        });

        btnAtualizate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                SwingUtilities.invokeLater(() -> {
                    new PersonManagerWindow(bedroomNumber).setVisible(true);
                });
            }
        });

        btnDelete.addActionListener(e -> {
            final int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                PersonService.delete((int) model.getValueAt(selectedRow, 0));
                btnAtualizate.doClick();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCompanyName = (String) comboBoxSearchByCompany.getSelectedItem();

                if (selectedCompanyName != null && selectedCompanyName.trim().equals("-- todos --")) {
                    PersonManagerSearch personManagerSearch = new PersonManagerSearch(txtSearch.getText(), "name", bedroomNumber);
                    personManagerSearch.setVisible(true);
                    dispose();
                }else{
                    PersonManagerSearch personManagerSearch = new PersonManagerSearch(selectedCompanyName, "companyName", bedroomNumber);
                    personManagerSearch.setVisible(true);
                    dispose();
                }
            }
        });
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    PersonService.updateBedroom((int) model.getValueAt(selectedRow, 0),bedroomNumber);
                    btnAtualizate.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
                }
            }
        });
    }
}

