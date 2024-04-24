package org.example.View;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PersonManagerWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtSearch;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PersonManagerWindow frame = new PersonManagerWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PersonManagerWindow() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 128, 255));

        JComboBox comboBoxSearchByCompany = new JComboBox();
        comboBoxSearchByCompany.setToolTipText("Empresa...");

        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
        txtSearch.setForeground(Color.GRAY); // Define a cor cinza para o texto inicial
        txtSearch.setText("Pesquisar...");
        txtSearch.setColumns(10);
        // Adiciona um FocusListener para tratar o comportamento do texto
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtSearch.getText().equals("Pesquisar...")) {
                    txtSearch.setText("");
                    txtSearch.setForeground(Color.BLACK); // Muda a cor para preto quando o campo está em foco
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

        JButton btnPrint = new JButton("Imprimir...");
        btnPrint.setForeground(Color.WHITE);
        btnPrint.setBackground(new Color(0, 128, 255));

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
                                                .addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(btnPrint)
                                        .addComponent(btnDelete)
                                        .addComponent(btnEdit))
                                .addGap(12)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        );

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Telefone");
        model.addColumn("Empresa");
        model.addColumn("Hospedado");


        // Exemplo de dados
        Object[] row1 = {"15","João", "123.456.789-00", "+55 (99) 99999-9999", "Empresa A", "Quarto 2"};
        Object[] row2 = {"17", "Maria", "987.654.321-00", "+55 (88) 88888-8888", "Empresa B", "Quarto 3"};
        model.addRow(row1);
        model.addRow(row2);



        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Evita que as colunas sejam redimensionadas automaticamente

        // Define o tamanho preferencial das colunas
        table.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(350); // Nome
        table.getColumnModel().getColumn(2).setPreferredWidth(250); // CPF
        table.getColumnModel().getColumn(3).setPreferredWidth(250); // Telefone
        table.getColumnModel().getColumn(4).setPreferredWidth(350); // Empresa
        table.getColumnModel().getColumn(5).setPreferredWidth(228); // Hospedado


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

        JLabel lblTotalOfRecords = new JLabel("0");

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
                NewPersonWindow newGuestWindow = new NewPersonWindow();
                newGuestWindow.setVisible(true);
            }
        });
    }
}
