package ar.unrn.observer.ejercicio4.ui;



import ar.unrn.observer.ejercicio4.dominio.CrearParticipante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/// Dependencia con el dominio

public class AgregarParticipanteUI extends JFrame {

    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email;

    private final CrearParticipante casoUso;

    public AgregarParticipanteUI(CrearParticipante casoUso) {
        this.casoUso = casoUso;
        setupUI();
    }

    private void setupUI() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nombre = new JTextField(10);
        email = new JTextField(10);
        telefono = new JTextField(10);
        region = new JTextField("China", 10);

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(new JLabel("Nombre: "));
        panel.add(nombre);

        panel.add(new JLabel("Telefono: "));
        panel.add(telefono);


        panel.add(new JLabel("Email: "));
        panel.add(email);


        panel.add(new JLabel("Region: "));
        panel.add(region);

        JButton boton = new JButton("Cargar");
        boton.addActionListener(this::onCargar);

        panel.add(boton);

        setContentPane(panel);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        pack();
        setVisible(true);
    }

    private void onCargar(ActionEvent e) {
        try {
            casoUso.ejecutar(
                    nombre.getText(),
                    telefono.getText(),
                    region.getText(),
                    email.getText()
            );

            JOptionPane.showMessageDialog(this, "Participante guardado");
            dispose();

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}