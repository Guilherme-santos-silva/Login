package Modelo;

public class Validacao
{
    String Mensagem = "";
    
    public void ValidarCadastroDAO(Dados dados)
    {
        if(!(dados.getLogin().matches("[A-Z]*[a-z]*")))
        {
            Mensagem = "caracteres invalidos no campo de Login !";
        }
        
        if(!(dados.getSenha().matches("[A-Z]*[a-z]*")))
        {
            Mensagem = "caracteres invalidos no campo de Senha !";
        }

    }

    public String getMensagem()
    {
        return Mensagem;
    }

}
