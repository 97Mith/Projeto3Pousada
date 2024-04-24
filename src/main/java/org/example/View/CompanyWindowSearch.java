package org.example.View;

import org.example.entity.CompanyEntity;
import org.example.repository.CompanyRepository;
import org.example.service.CompanyService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.List;

public class CompanyWindowSearch extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtSearch;
    private JTable table;
    private List<CompanyEntity> companiesSearched;
    private static DefaultTableModel model;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CompanyWindowSearch frame = new CompanyWindowSearch("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CompanyWindowSearch(String search) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(128, 0, 255));

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
        btnSearch.setBackground(new Color(128, 0, 255));
        btnSearch.setForeground(new Color(255, 255, 255));

        JButton btnNewCompany = new JButton("+ Novo Empresa");
        btnNewCompany.setForeground(Color.WHITE);
        btnNewCompany.setBackground(new Color(128, 0, 255));

        JButton btnAtualizate = new JButton("Atualizar...");
        btnAtualizate.setForeground(Color.WHITE);
        btnAtualizate.setBackground(new Color(128, 0, 255));

        JPanel panel = new JPanel();

        JPanel panel_1 = new JPanel();

        JButton btnDelete = new JButton("Excluir");
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(128, 0, 0));

        JButton btnEdit = new JButton("Editar");
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBackground(new Color(128, 0, 255));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnSearch)
                                                .addGap(25))
                                        .addComponent(topPanel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewCompany)
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
                                        .addComponent(btnSearch))
                                .addGap(18)
                                .addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewCompany)
                                        .addComponent(btnAtualizate)
                                        .addComponent(btnDelete)
                                        .addComponent(btnEdit))
                                .addGap(12)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        );
        JButton update = new JButton("");

        table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(table);

        MaskFormatter cnpjFormatter = formatation("##.###.###/####-##");
        MaskFormatter phoneNumberFormatter = formatation("+55 (##) ##### ####");

        List<CompanyEntity> allCompanies = CompanyService.getByName(search);
        DefaultTableModel model = CompanyService.createCompanyTable(allCompanies);

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Evita que as colunas sejam redimensionadas automaticamente

        // Define o tamanho preferencial das colunas
        table.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(170); // Nome
        table.getColumnModel().getColumn(2).setPreferredWidth(400); // Razão Social
        table.getColumnModel().getColumn(3).setPreferredWidth(150); // Telefone
        table.getColumnModel().getColumn(4).setPreferredWidth(160); // Cnpj
        table.getColumnModel().getColumn(5).setPreferredWidth(130); // I.E
        table.getColumnModel().getColumn(6).setPreferredWidth(430); // Email
        table.getColumnModel().getColumn(3).setCellRenderer(new CNPJCellRenderer(phoneNumberFormatter));
        table.getColumnModel().getColumn(4).setCellRenderer(new CNPJCellRenderer(cnpjFormatter));

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
        int total = allCompanies.size();
        JLabel lblTotalOfRecords = new JLabel(String.valueOf(total));

        JButton btnOk = new JButton("Ok");
        btnOk.setForeground(Color.WHITE);
        btnOk.setBackground(new Color(128, 0, 255));
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

        JLabel lblTitle = new JLabel("Empresa");
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

        btnNewCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompanyEntity company = new CompanyEntity();
                NewCompanyWindow newCompanyWindow = new NewCompanyWindow(update, company);
                newCompanyWindow.setVisible(true);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                SwingUtilities.invokeLater(() -> {
                    new CompanyManagerWindow().setVisible(true);
                });
            }
        });

        btnEdit.addActionListener(e -> {
            final int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                CompanyEntity branch = CompanyRepository.findById((int) model.getValueAt(selectedRow, 0));

                new NewCompanyWindow(update, branch).setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
            }
        });

        btnDelete.addActionListener(e -> {
            final int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                CompanyRepository.delete((int) model.getValueAt(selectedRow, 0));
                btnAtualizate.doClick();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum campo selecionado");
            }
        });
        btnAtualizate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                SwingUtilities.invokeLater(() -> {
                    new CompanyManagerWindow().setVisible(true);
                });
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompanyWindowSearch companyWindowSearch = new CompanyWindowSearch(txtSearch.getText());
                companyWindowSearch.setVisible(true);
                dispose();
            }
        });
    }
    private static MaskFormatter formatation(String format){
        MaskFormatter shape = null;
        try{
            shape = new MaskFormatter(format);
            shape.setValueContainsLiteralCharacters(false);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return shape;
    }
}


