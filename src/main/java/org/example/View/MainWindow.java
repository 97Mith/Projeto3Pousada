package org.example.View;

import org.example.entity.PersonEntity;
import org.example.service.BedroomService;
import org.example.service.MainService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {
    private LocalDateTime checkoutDateTime;
    private static final int SIDE_PANEL_WIDTH = 400;
    private JPanel lateralPanel;
    private JPanel content;
    private boolean visiblePanel = true;
    private JPanel bedroomPane;
    private int bedroomCount = 0;

    public MainWindow() {

        setTitle("Painel Lateral Retrátil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setResizable(false);
        //setSize(996, 739);


        lateralPanel = new JPanel();
        lateralPanel.setBackground(new Color(0, 128, 192));
        lateralPanel.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, getHeight()));


        JButton btnManageGuests = new JButton("Consultar hospede");
        btnManageGuests.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnManageGuests.setForeground(new Color(255, 255, 255));
        btnManageGuests.setBackground(new Color(0, 128, 192));
        btnManageGuests.setMargin(new Insets(0, 20, 0, 150));


        content = new JPanel();
        content.setBackground(Color.WHITE);


        getContentPane().add(lateralPanel, BorderLayout.WEST);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_1.setBackground(new Color(0, 128, 192));

        JLabel lblNewLabel = new JLabel("MENU PRINCIPAL");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));

        JButton btnManageCompany = new JButton("Gerenciar empresa");
        btnManageCompany.setMargin(new Insets(0, 20, 0, 150));
        btnManageCompany.setForeground(Color.WHITE);
        btnManageCompany.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnManageCompany.setBackground(new Color(0, 128, 192));

        JButton btnManageBedroons = new JButton("Gerenciar quartos");
        btnManageBedroons.setMargin(new Insets(0, 20, 0, 150));
        btnManageBedroons.setForeground(Color.WHITE);
        btnManageBedroons.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnManageBedroons.setBackground(new Color(0, 128, 192));

        JButton btnManageFinances = new JButton("Gerenciar finanças");
        btnManageFinances.setMargin(new Insets(0, 20, 0, 150));
        btnManageFinances.setForeground(Color.WHITE);
        btnManageFinances.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnManageFinances.setBackground(new Color(0, 128, 192));

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_1_1.setBackground(new Color(200, 200, 200));
        GroupLayout gl_painelLateral = new GroupLayout(lateralPanel);
        gl_painelLateral.setHorizontalGroup(
                gl_painelLateral.createParallelGroup(Alignment.TRAILING)
                        .addComponent(btnManageGuests, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addGroup(gl_painelLateral.createSequentialGroup()
                                .addGap(37)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(206, Short.MAX_VALUE))
                        .addGroup(Alignment.LEADING, gl_painelLateral.createSequentialGroup()
                                .addComponent(btnManageCompany, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(Alignment.LEADING, gl_painelLateral.createSequentialGroup()
                                .addComponent(btnManageBedroons, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(Alignment.LEADING, gl_painelLateral.createSequentialGroup()
                                .addComponent(btnManageFinances, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(Alignment.LEADING, gl_painelLateral.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                .addGap(39))
                        .addGroup(Alignment.LEADING, gl_painelLateral.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addGap(30))
        );
        gl_painelLateral.setVerticalGroup(
                gl_painelLateral.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_painelLateral.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addComponent(lblNewLabel)
                                .addGap(27)
                                .addComponent(btnManageGuests, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnManageCompany, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnManageBedroons, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnManageFinances, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addContainerGap())
        );

        JLabel lblNewLabel_1 = new JLabel("Informações");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        panel_1_1.add(lblNewLabel_1);

        JLabel lblNameIomarInn = new JLabel("Iomar Inn");
        lblNameIomarInn.setForeground(new Color(255, 255, 255));
        lblNameIomarInn.setFont(new Font("Segoe UI Black", Font.PLAIN, 34));
        panel_1.add(lblNameIomarInn);
        lateralPanel.setLayout(gl_painelLateral);
        getContentPane().add(content, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBackground(new Color(255, 255, 255));


        bedroomPane = new JPanel();
        GroupLayout gl_conteudo = new GroupLayout(content);
        gl_conteudo.setHorizontalGroup(
                gl_conteudo.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_conteudo.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_conteudo.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                                        .addGroup(gl_conteudo.createSequentialGroup()
                                                .addComponent(bedroomPane, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        gl_conteudo.setVerticalGroup(
                gl_conteudo.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_conteudo.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(bedroomPane, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                                .addContainerGap())
        );
        bedroomPane.setLayout(new GridLayout(0, 1)); // Configuração do layout do bedroomPane

        JButton btnShowLateralPane = new JButton("Abrir");
        btnShowLateralPane.setBackground(new Color(255, 255, 255));
        btnShowLateralPane.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLateralPanel();
            }
        });

        for (int i = 0; i < 6; i++) {
            addBedroom();
        }

        JButton btnUpdate = new JButton("Atualizar");
        btnUpdate.setBackground(Color.WHITE);


        JButton btnOption = new JButton("opção");
        btnOption.setBackground(Color.WHITE);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(btnShowLateralPane, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                                .addComponent(btnOption, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(24))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                .addComponent(btnShowLateralPane, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnOption, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
        );
        panel.setLayout(gl_panel);
        content.setLayout(gl_conteudo);


        //TODO botões do painel lateral
        btnManageGuests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new PersonManagerWindow(0, btnManageGuests).setVisible(true);
            }
        });

        btnManageCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompanyManagerWindow newCompanyWindow = new CompanyManagerWindow();
                newCompanyWindow.setVisible(true);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                SwingUtilities.invokeLater(() -> {
                    new MainWindow().setVisible(true);
                });
            }
        });
    }

    private void showLateralPanel() {
        if (visiblePanel) {
            lateralPanel.setVisible(false);
            visiblePanel = false;
        } else {
            lateralPanel.setVisible(true);
            visiblePanel = true;
        }
    }
    private void addBedroom() {
        JPanel bedroomLabel = new JPanel();
        bedroomLabel.setLayout(new BorderLayout());

        int panelWidth = bedroomPane.getWidth() / 3;
        int panelHeight = bedroomPane.getHeight() / 3;

        Integer num = bedroomCount + 1;

        bedroomLabel.setPreferredSize(new Dimension(panelWidth, panelHeight));

        List<PersonEntity> data = BedroomService.loadAllInBedroom(num);

        // Verificar se há dados de hóspedes e telefone na tabela
        boolean hasGuests = isSomebodyinBedroom(data);

        Color backgroundColor;
        if (!hasGuests) {
            backgroundColor = new Color(170,245,245);
        } else {
            backgroundColor = new Color(245, 245, 200);
        }

        // Criação do painel para a tabela e a label de checkout
        JPanel tablePanel = new JPanel(new BorderLayout());

        DefaultTableModel model = MainService.createMainTable(data);
        JTable table = new JTable(model);
        table.setFont(table.getFont().deriveFont(table.getFont().getSize()));
        table.setRowHeight(table.getRowHeight() * 2);
        table.setBackground(backgroundColor);
        JScrollPane tableScrollPane = new JScrollPane(table);

        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Atribuindo a data de checkout à variável
        LocalDateTime checkoutDateTime = LocalDateTime.of(2024, 6, 29, 12, 0); // Exemplo: 31 de março de 2024, 12:00

        // Formatação da data para exibição
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedCheckoutDateTime = checkoutDateTime.format(formatter);

        // Adicionando a label de checkout
        JLabel checkoutLabel = new JLabel("Data de Checkout: " + formattedCheckoutDateTime);
        checkoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tablePanel.add(checkoutLabel, BorderLayout.SOUTH);

        // Adicionando o painel da tabela e da label de checkout ao bedroomLabel
        bedroomLabel.add(tablePanel, BorderLayout.CENTER);

        //TODO substituir o texto nome da empresa, check in e check out pelas variáveis respectivamente

        JLabel roomLabel = new JLabel("Quarto " + (num) + "  " +"Nome da empresa");
        roomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bedroomLabel.add(roomLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 0, 20));

        JButton editButton = new JButton("Gerenciar quarto");
        editButton.setBackground(backgroundColor);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BedroomWindow bedroomWindow = new BedroomWindow(num);
                bedroomWindow.setVisible(true);
                System.out.println(num);
            }
        });
        buttonPanel.add(editButton);

        bedroomLabel.add(buttonPanel, BorderLayout.SOUTH);

        // Atualizar a cor do painel com base na data de checkout
        updatePanelColor(bedroomLabel, checkoutDateTime);

        bedroomPane.setLayout(new GridLayout(0, 3)); // Alterado para 3 colunas
        bedroomPane.add(bedroomLabel);

        bedroomPane.revalidate();
        bedroomPane.repaint();
        bedroomCount += 1;
    }

    // Método para atualizar a cor do painel com base na data de checkout
    private void updatePanelColor(JPanel panel, LocalDateTime checkoutDateTime) {
        Color backgroundColor;
        LocalDateTime currentDate = LocalDateTime.now();

        if (currentDate.isAfter(checkoutDateTime)) {
            backgroundColor = new Color(255, 120, 120); // Vermelho claro
        } else if (currentDate.plusDays(1).isAfter(checkoutDateTime)) {
            backgroundColor = new Color(255, 100, 0); // Laranja claro
        } else {
            backgroundColor = new Color(255, 255, 255); // Bege
        }

        panel.setBackground(backgroundColor);
    }

    // Método para acessar a variável de data de checkout
    public LocalDateTime getCheckoutDateTime() {
        return checkoutDateTime;
    }

    public boolean isSomebodyinBedroom(List<PersonEntity> data){
        boolean hasGuests = false;
        if(!data.isEmpty()){
            hasGuests = true;
        }

        return hasGuests;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}