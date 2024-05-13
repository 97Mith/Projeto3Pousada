package org.example.View;

import org.example.entity.CompanyEntity;
import org.example.service.CompanyService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class NewCompanyWindow extends JFrame {
    private CompanyEntity companyEntity;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCompanyName;
    private JTextField textFieldCorporateReason;
    private JTextField textFieldCnpj;
    private JTextField textFieldTel;
    private JTextField textFieldStateInscription;
    private JTextField textFieldEmail;
    private List<CompanyEntity> companies = CompanyService.getAll();

    // Classe para filtrar entrada para aceitar apenas números
    static class NumberOnlyFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) return;
            if (string.matches("[0-9]+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null) return;
            if (text.matches("[0-9]+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
    public NewCompanyWindow(JButton update, CompanyEntity company) {
        companyEntity = company;

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 843, 529);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(197, 197, 226));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBounds(23, 75, 769, 292);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));

        JLabel lblEmpresa = new JLabel("Empresa");
        lblEmpresa.setBounds(326, 20, 170, 45);
        lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmpresa.setFont(new Font("Verdana", Font.PLAIN, 36));

        JLabel lblName = new JLabel("Nome");
        lblName.setBounds(91, 32, 66, 33);
        lblName.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldCompanyName = new JTextField();

        textFieldCompanyName.setBounds(167, 32, 551, 28);
        if(company != null) textFieldCompanyName.setText(company.getName());
        textFieldCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldCompanyName.setColumns(10);

        JLabel lblRazoSocial = new JLabel("Razão social");
        lblRazoSocial.setBounds(30, 99, 116, 33);
        lblRazoSocial.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldCorporateReason = new JTextField();
        if(company != null) textFieldCorporateReason.setText(company.getCorporateReason());
        textFieldCorporateReason.setBounds(164, 96, 554, 28);
        textFieldCorporateReason.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldCorporateReason.setColumns(10);

        JLabel lblCnpj = new JLabel("CNPJ");
        lblCnpj.setBounds(91, 164, 53, 33);
        lblCnpj.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldCnpj = new JTextField();
        if(company != null) textFieldCnpj.setText(company.getCnpj());
        textFieldCnpj.setBounds(167, 161, 174, 28);
        textFieldCnpj.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldCnpj.setColumns(10);

        JLabel lblTel = new JLabel("Telefone");
        lblTel.setBounds(62, 232, 82, 33);
        lblTel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldTel = new JTextField();
        if(company != null) textFieldTel.setText(company.getPhoneNumber());
        textFieldTel.setBounds(167, 229, 174, 28);
        textFieldTel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldTel.setColumns(10);

        JLabel lblStateInscription = new JLabel("I.E");
        lblStateInscription.setBounds(488, 164, 32, 33);
        lblStateInscription.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldStateInscription = new JTextField();
        if(company != null) textFieldStateInscription.setText(company.getStateInscription());
        textFieldStateInscription.setBounds(544, 161, 174, 28);
        textFieldStateInscription.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldStateInscription.setColumns(10);
        panel.setLayout(null);
        panel.add(lblName);
        panel.add(textFieldCompanyName);
        panel.add(lblTel);
        panel.add(textFieldTel);
        panel.add(lblCnpj);
        panel.add(lblStateInscription);
        panel.add(textFieldStateInscription);
        panel.add(lblRazoSocial);
        panel.add(textFieldCnpj);
        panel.add(textFieldCorporateReason);

        JLabel lblEmail = new JLabel("E-Mail");
        lblEmail.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
        lblEmail.setBounds(364, 232, 66, 33);
        panel.add(lblEmail);

        textFieldEmail = new JTextField();
        if(company != null) textFieldEmail.setText(company.getEmail());
        textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(440, 229, 278, 28);
        panel.add(textFieldEmail);
        contentPane.setLayout(null);
        contentPane.add(lblEmpresa);
        contentPane.add(panel);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCancel.setBackground(new Color(255, 128, 128));
        btnCancel.setBounds(23, 428, 239, 41);
        contentPane.add(btnCancel);

        JButton btnOk = new JButton("Ok");
        btnOk.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnOk.setBackground(new Color(128, 255, 128));
        btnOk.setBounds(553, 428, 239, 41);
        contentPane.add(btnOk);

        PlainDocument docCnpj = (PlainDocument) textFieldCnpj.getDocument();
        docCnpj.setDocumentFilter(new NumberOnlyFilter());

        PlainDocument docStateInscription = (PlainDocument) textFieldStateInscription.getDocument();
        docStateInscription.setDocumentFilter(new NumberOnlyFilter());

        PlainDocument docTel = (PlainDocument) textFieldTel.getDocument();
        docTel.setDocumentFilter(new NumberOnlyFilter());

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(companyEntity.getId() == null) {
                    //boolean ok = CompanyService.isCompanyUnique(companies, textFieldCorporateReason.getText(), textFieldCnpj.getText());
                    boolean ok = CompanyService.createCompany(
                            textFieldCompanyName, textFieldCorporateReason,
                            textFieldCnpj, textFieldStateInscription,
                            textFieldTel, textFieldEmail
                    );


                    if(ok){
                        update.doClick(); dispose();
                    }else{
                        System.out.println("Campos inválidos");
                    }


                }else {
                    boolean ok = CompanyService.updateCompany(companyEntity,
                            textFieldCompanyName, textFieldCorporateReason,
                            textFieldCnpj, textFieldStateInscription,
                            textFieldTel, textFieldEmail
                    );
                    if(ok){
                        update.doClick(); dispose();
                    }else{
                        System.out.println("Campos inválidos");
                    }
                }
            }
        });
    }

}
