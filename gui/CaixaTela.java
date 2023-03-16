package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Caixa;

public class CaixaTela extends JFrame implements ActionListener {
    protected Dimension dFrame, dLabel, dTextField, dButton, dTextArea;
    protected Label lblValor, lblSaldo;
    protected TextField txtValor, txtSaldo;
    protected Button cmdEntrada, cmdRetirada, cmdConsulta, cmdSair;
    protected TextArea txtMsg;

    private Caixa caixa;

    public CaixaTela(){
        caixa = new Caixa();
        //Aparência e comportamento da janela
        dFrame = new Dimension(350, 420);
        dLabel = new Dimension(40, 20);
        dTextField = new Dimension(150, 20);
        dButton = new Dimension(95, 20);
        dTextArea = new Dimension(300, 140);
        setTitle("Controle de Caixa");
        setLayout(null);
        setSize(dFrame);
        setLocationRelativeTo(null);
        setResizable(false);

        //Primeiro rótulo
        lblValor = new Label("Valor: ");
        lblValor.setSize(dLabel);
        lblValor.setLocation(25, 50);
        this.add(lblValor);

        //Segundo rótulo
        lblSaldo = new Label("Saldo: ");
        lblSaldo.setSize(dLabel);
        lblSaldo.setLocation(25, 80);
        this.add(lblSaldo);

        //Primeiro text
        txtValor = new TextField();
        txtValor.setSize(dTextField);
        txtValor.setLocation(75, 50);
        this.add(txtValor);

        //Segundo text
        txtSaldo = new TextField();
        txtSaldo.setSize(dTextField);
        txtSaldo.setLocation(75, 80);
        this.add(txtSaldo);

        //Primeiro botão
        cmdEntrada = new Button("Entrada");
        cmdEntrada.setSize(dButton);
        cmdEntrada.setLocation(25, 150);
        cmdEntrada.addActionListener(this);
        this.add(cmdEntrada);

        //Segundo botão
        cmdConsulta = new Button("Consulta");
        cmdConsulta.setSize(dButton);
        cmdConsulta.setLocation(25, 185);
        cmdConsulta.addActionListener(this);
        this.add(cmdConsulta);

        //Terceiro botão
        cmdRetirada = new Button("Retirada");
        cmdRetirada.setSize(dButton);
        cmdRetirada.setLocation(180, 150);
        cmdRetirada.addActionListener(this);
        this.add(cmdRetirada);

        //Quarto botão
        cmdSair = new Button("Sair");
        cmdSair.setSize(dButton);
        cmdSair.setLocation(180, 185);
        cmdSair.addActionListener(this);
        this.add(cmdSair);

        //Textarea
        txtMsg = new TextArea();
        txtMsg.setSize(dTextArea);
        txtMsg.setLocation(25, 220);
        this.add(txtMsg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmdEntrada){
            double valor = Double.parseDouble(txtValor.getText());
            caixa.depositar(valor);
            txtValor.setText(null);
            txtValor.requestFocus();
            txtMsg.append("Depósito de "+valor+" efetuado com sucesso\n");
            return;
        }
        if (e.getSource() == cmdRetirada){
            double valor = Double.parseDouble(txtValor.getText());
            caixa.sacar(valor);
            txtValor.setText(null);
            txtValor.requestFocus();
            txtMsg.append("Retirada de "+valor+" efetuada com sucesso\n");
            return;
        }
        if (e.getSource() == cmdConsulta){
            txtSaldo.setText(Double.toString(caixa.getSaldo()));
            txtMsg.append("Saldo consultado com sucesso\n");
            return;
        }
        if (e.getSource() == cmdSair){
            System.exit(0);
        }
    }
}