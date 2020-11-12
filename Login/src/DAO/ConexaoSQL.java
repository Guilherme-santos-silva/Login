package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoSQL
{
    //conexao com o driver que faz a ponte entre o sql e o java
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    //URL do banco, caminho que o programa ira seguir para acessar ao banco, com nome do banco, usuario e login
    //alterar caminho do driver e nome do banco, user e senha
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Aula; user=guilherme; password=123";
    
    //metodo para FAZER USO DAS CONEXOES 
    public static Connection getConnection()  
    {    
        try 
        {
            //classe do DRIVER
            Class.forName(DRIVER);
            //System.out.println("conectado");
            //usando o driver para acessar ao banco
            return DriverManager.getConnection(URL);
            
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            //caso nao ache o caminho do banco mensagem de errro
            throw new RuntimeException("erro de conexao: ",ex);
        }        
    }
    
    /*
    aque fazemos uma SOBRECARGA DE METODOS que é:
    DescriçãoSobrecarga de método permite a existência de vários métodos de mesmo nome, 
    porém com assinaturas levemente diferentes ou seja variando 
    no número, tipo de argumentos, no valor de retorno e até variáveis diferentes
    */
    
    /*
    con - recebe conexao
    stmt - trata as querys (inserts, deletes, updates etc)
    rs - trata os dados (selects)
    */
    
    /*
    NESSE METODOS TEMOS:
    O metodo para fechar a conexao depois da conexao ser efetuada "Connection" que recebe "con"
    Connection traduzido seria conexao.
    */
    
    public static void fecharConexao(Connection con /*recebendo a conexao "con"*/)
    {
        try 
        {
            //verificando a conexao "con"
            if(con!= null/*se con for diferente de null(nulo) quer dizer que ela esta aberta, entao deve ser fechado, para nao correr sobrecarga do pc*/)
            {
                //con.closse(); = conexao.fechar();
                con.close();
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAO.ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    NESSE METODOS TEMOS:
    O metodo para fechar a conexao depois da conexao ser efetuada "Connection" que recebe "con"
    Connection traduzido seria conexao.
    
    e tambem temos o metodo "PreparedStatement" que recebe "stmt", é responsalvel por tratar e organizar a sua query na hora de fazer inserts ou deletes etc. 
    no banco PreparedStatement traduziao seria Declaração preparada.
    */
    
    public static void fecharConexao(Connection con, PreparedStatement stmt /*recebendo a Declaração preparada  "stmt" e as demais ja por sobrecarga*/)
    {
        
        //primeiro chamos o metodo que fecha a conexao
        fecharConexao(con);
        
         
        try 
        {
            //depois verificamos a conexao "stmt"   
            if(stmt != null /*se for diferente de null que quer dizer que ela esta aberta, entao deve ser fechado,  para que depois do insert, update etc. nao ocorra insert, update etc. maliciosos ou outros problemas*/)
            {
                //stmt.close(); = Declaração preparada.fechar();
                stmt.close();
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAO.ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    /*
    NESSE METODOS TEMOS:
    O metodo para fechar a conexao depois da conexao ser efetuada "Connection" que recebe "con"
    Connection traduzido seria conexao.
    
    e tambem temos o metodo "PreparedStatement" que recebe "stmt", é responsalvel por tratar e organizar a sua query na hora de fazer inserts ou deletes etc. 
    no banco PreparedStatement traduziao seria Declaração preparada.
    
    e tambem o "ResultSet" que recebe a "rs", é responaslvel por guardar o resultado de uma pesquisa numa estrutura de dados que pode ser percorrida, de forma que você possa ler os dados do banco.
    sendo utilizado em selects que devem ser exibidos
    sua traducao seria Conjunto de resultados.
    */
    
    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs /*recebendo a Declaração preparada  "rs" e as demais ja por sobrecarga**/)
    {
         
        //primeiro chamos o metodo que fecha a conexao e o metodo que fecha o tratamento de query
        fecharConexao(con, stmt);
        
         
        try 
        {
            //depois verificamos a conexao "rs"  
            if(rs != null /*se for diferente de null que quer dizer que ela esta aberta, entao deve ser fechado, para depois do insert nao ocorra selects maliciosos ou outros problemas*/)
            {
                //rs.close(); =  Conjunto de resultados.fechar();
                rs.close();
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAO.ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

