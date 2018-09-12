package dao;

import bean.Aluno;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlunoDAO {
    Connection con;
    public AlunoDAO (){
        con = ConnectionFactory.getConnection();
    }
    
    public void insert(Aluno a) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO `banco`.`aluno` (`nome_aluno`, `idade_aluno`) VALUES (?, ?);");
            //nome_aluno , idade_aluno
            stmt.setString(1, a.getNomeAluno());
            stmt.setString(2,a.getIdadeAluno());
 

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
