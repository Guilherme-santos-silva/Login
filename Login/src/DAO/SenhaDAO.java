package DAO;

import Modelo.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SenhaDAO
{
    boolean Login = false;
    
    public void CadastroDAO(Dados dados)
    {
        Connection con = ConexaoSQL.getConnection();        
        PreparedStatement stmt = null;
    
        try 
        {
            stmt = con.prepareStatement("insert into senha (login, senha) values (?,?)");            
            stmt.setString(1, dados.getLogin());            
            stmt.setString(2, dados.getSenha());            
            stmt.executeUpdate();            
                       
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Esse cadastro ja existe !");
        }        
        finally
        {
            ConexaoSQL.fecharConexao(con, stmt);
        }
    }
    
    public boolean LoginDAO(Dados dados)
    {

        Connection con = ConexaoSQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

            try 
            {
                stmt = con.prepareStatement("select * from senha where login = ? and senha = ?");
                stmt.setString(1, dados.getLogin());            
                stmt.setString(2, dados.getSenha()); 
                rs = stmt.executeQuery();

                if(rs.next())
                {
                    Login = true;
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "seu nome ou cpf esta errado ou seu cadastro não existe \n");
                }
                System.out.println(Login);
            } 
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "erro BD \n");
            } 
            finally
            {
                ConexaoSQL.fecharConexao(con, stmt, rs);
                
            }

            return Login;  
    }

    public boolean isLogin()
    {
        return Login;
    }
    
    
}
