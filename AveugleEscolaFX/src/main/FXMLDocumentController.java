/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bean.Aluno;
import dao.AlunoDAO;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author paste
 */
public class FXMLDocumentController implements Initializable {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtIdade;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Label lblData;

    @FXML
    private Label lblHora;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Aluno a = new Aluno();
        AlunoDAO dao = new AlunoDAO();

        a.setNomeAluno(txtNome.getText().toUpperCase());
        a.setIdadeAluno(txtIdade.getText());

        dao.insert(a);
    }
        public void CurrentDate() {

        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Date now = new Date();

                    SimpleDateFormat sdfdata = new SimpleDateFormat("dd/MM/yyyy");
                    lblData.setText(sdfdata.format(now));

                    SimpleDateFormat sdfhora = new SimpleDateFormat("HH:mm:ss");
                    lblHora.setText(sdfhora.format(now));

                    try {
                        sleep(1000);

                    } catch (InterruptedException ex) {
                        System.out.println("deu errado");
                    }
                }
            }
        };

        clock.start();

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CurrentDate();               

    }

}
