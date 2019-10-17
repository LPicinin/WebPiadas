package trabalhofxferro2.banco;

public class Banco // padrão Singleton
{
    private static Conexao con;
    public static boolean conectar()
    {   con=new Conexao();
        return con.conectar(
                "jdbc:postgresql://localhost:5432/", 
                "Banco", "postgres", "postgres123");
    }
    private Banco() {  } // impede a instância da classe Banco 

    public static Conexao getCon() { return con; }
    
}
