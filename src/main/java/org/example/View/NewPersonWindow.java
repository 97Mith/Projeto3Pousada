package org.example.View;

import org.example.entity.PersonEntity;
import org.example.service.PersonService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPersonWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldCpf;
    private JTextField textFieldTel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewPersonWindow frame = new NewPersonWindow();
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
    public NewPersonWindow() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 791, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));

        JLabel lblTitle = new JLabel("Hospede");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Verdana", Font.PLAIN, 36));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 746, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(296)
                                                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
                                .addGap(26))
        );

        JLabel lblComany = new JLabel("Empresa");
        lblComany.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        JComboBox comboBoxCompanies = new JComboBox();

        JLabel lblName = new JLabel("Nome");
        lblName.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldName = new JTextField();
        textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldName.setColumns(10);

        JLabel lblSurname = new JLabel("Sobrenome");
        lblSurname.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldSurname = new JTextField();
        textFieldSurname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldSurname.setColumns(10);

        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldCpf = new JTextField();
        textFieldCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldCpf.setColumns(10);

        JLabel lblTel = new JLabel("Telefone");
        lblTel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));

        textFieldTel = new JTextField();
        textFieldTel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldTel.setColumns(10);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCancel.setBackground(new Color(255, 128, 128));

        JButton btnOk = new JButton("Ok");
        btnOk.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnOk.setBackground(new Color(128, 255, 128));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(34)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGap(26)
                                                                .addComponent(lblComany, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10)
                                                                .addComponent(comboBoxCompanies, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGap(61)
                                                                .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGap(9)
                                                                .addComponent(lblSurname, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4)
                                                                .addComponent(textFieldSurname, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGap(78)
                                                                .addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10)
                                                                .addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(47)
                                                                .addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10)
                                                                .addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(51, Short.MAX_VALUE))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                                .addGap(37))))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(53, Short.MAX_VALUE)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblComany, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBoxCompanies, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(39)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblSurname, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldSurname, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGap(39)
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGap(43)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(53))
        );
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);

        // Adicionando DocumentFilter aos campos textFieldCpf e textFieldTel
        ((AbstractDocument) textFieldCpf.getDocument()).setDocumentFilter(new DocumentFilter() {
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
        });

        ((AbstractDocument) textFieldTel.getDocument()).setDocumentFilter(new DocumentFilter() {
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
        });

        //ação dos botões
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonService.persistPerson(textFieldName, textFieldSurname, textFieldCpf, textFieldTel);
            }

        });
    }
}
