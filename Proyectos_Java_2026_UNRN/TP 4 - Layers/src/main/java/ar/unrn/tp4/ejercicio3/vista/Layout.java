package ar.unrn.tp4.ejercicio3.vista;

import ar.unrn.tp4.ejercicio3.modelo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Layout {

    private final JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JButton btnOk;
    private JLabel lblCompetition;
    private JComboBox<Concurso> comboBox;

    CompetitionManagement competitionManagement;
    InscriptionManagement inscripcionConcurso;

    public Layout(CompetitionManagement competitionManagement, InscriptionManagement formaDeInscripcionExterna) {
        this.competitionManagement = competitionManagement;
        this.inscripcionConcurso = formaDeInscripcionExterna;

        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        frame.setVisible(true);


        inicializar();
    }


    private void inicializar() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        //  Component comboBox = null;
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtEmail, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtPhone, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtId, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtLastName, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtName, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));

        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLastName).addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(lblId).addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPhone)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblEmail))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCompetition))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnOk)
                        .addContainerGap(67, Short.MAX_VALUE)));

        contentPane.setLayout(gl_contentPane);
    }

    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        btnOk = new JButton("Ok");
        btnOk.addActionListener(e -> {
            btnOk.setEnabled(false);
            /*
            Acá debería traer una interfaz que implemente al LectorArchivo
             */
            Concurso seleccionado = (Concurso) comboBox.getSelectedItem();
            String nombre = txtName.getText();
            String apellido = txtLastName.getText();
            //  String dni = txtId.getText(); No se usa realmente
            String telefono = txtPhone.getText();
            String email = txtEmail.getText();
            try {
                // Acá durante la creación puede saltar una excepción si hubo un error. No es necesario un METHOD exclusivo para validaciones.
                inscripcionConcurso.inscribirCandidato(new Candidato(apellido, nombre, new Telefono(telefono), new eMail(email), seleccionado));
                System.out.println("Inscripcion exitosa");
                SwingUtilities.getWindowAncestor(btnOk).dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                btnOk.setEnabled(true);
            }
        });
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<Concurso>();
        inicializarComboBox();
    }

    void inicializarComboBox() {
        this.competitionManagement.todosLosConcursos().forEach(concurso -> comboBox.addItem(concurso));
    }
}
