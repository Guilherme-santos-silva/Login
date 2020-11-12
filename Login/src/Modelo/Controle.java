package Modelo;


import javax.swing.JOptionPane;

public class Controle
{
    public boolean Login = false;
    String Mensagem = "";
    
    public void ControleCadastroDAO(Dados dados)
    {
        Validacao validacao = new Validacao();
        validacao.ValidarCadastroDAO(dados);
        if(validacao.getMensagem().equals(""))
        {
            DAO.SenhaDAO senha = new DAO.SenhaDAO();
            dados.setLogin(dados.getLogin());
            dados.setSenha(dados.getSenha());
            senha.CadastroDAO(dados);
            JOptionPane.showMessageDialog(null, "login realizado com sucesso, feche a tela e insira novamente o login e a senha nos respectivos campos !");
        }
        else 
        {
            Mensagem = validacao.getMensagem();
        }
    }
    
    public boolean controleBuscarLoginDAO(Dados dados)
    {
        
        Validacao validacao = new Validacao();
        validacao.ValidarCadastroDAO(dados);
        if(validacao.getMensagem().equals(""))
        {
            dados.setLogin(dados.getLogin());
            dados.setSenha(dados.getSenha());
            DAO.SenhaDAO senha = new DAO.SenhaDAO();
            senha.LoginDAO(dados);
            if(senha.isLogin() == true)
            {
                this.Login= true;
            }

        }
        else
        {
            Mensagem = validacao.getMensagem();
        }
        return Login;
    }

    public boolean isLogin()
    {
        return Login;
    }
    
    public String getMensagem()
    {
        return Mensagem;
    }
    
    
    
}
