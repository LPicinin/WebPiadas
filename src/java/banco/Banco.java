package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco
{
    private static Banco instance;
    private static int n;
    private boolean connected;
    private Connection connect = null;
    private String erro;

    private Banco(String local, String banco, String usuario, String senha)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = local + banco; //"jdbc:postgresql://localhost/"+banco;
            connect = DriverManager.getConnection(url, usuario, senha);
            connected = true;
        } 
        catch (SQLException sqlex)
        {
            erro = "Impossivel conectar com a base de dados: " + sqlex.toString();
            connected = false;
            System.out.println(erro);
        } 
        catch (Exception ex)
        {
            erro = "Outro erro: " + ex.toString();
            connected = false;
            System.out.println(erro);
        }
    }
    
    public static Banco getInstance()
    {
        return instance;
    }
    
    public Connection getConnection()
    {
        return connect;
    }
    
    public boolean isConnected()
    {
        return connected;
    }
    
    public static Banco conectar()
    {
        if (instance == null)
        {
            instance = new Banco("jdbc:postgresql://localhost:5433/", "dbpiadas", "postgres", "postgres123");
            
            n = instance.isConnected() ? 1 : 0;
        }
        else
            n++;
        
        return instance;
    }
    
    public static void desconectar()
    {
        n--;
        
        if(n == 0)
        {
            try
            {
                instance.getConnection().close();
                instance = null;
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    public boolean manipular(String sql) // inserir, alterar,excluir
    {
        if(connect != null)
        {
            boolean executou = false;
            try
            {
                Statement statement = connect.createStatement();
                int result = statement.executeUpdate(sql);
                statement.close();
                if (result >= 1)
                {
                    executou = true;
                }
            } catch (SQLException sqlex)
            {
                erro = "Erro: " + sqlex.toString();
                System.out.println(erro);
            }
            return executou;
        }
        else
            return false;
    }

    public ResultSet consultar(String sql)
    {
        if(connect != null)
        {
            ResultSet rs = null;
            try
            {
                Statement statement = connect.createStatement();
                //ResultSet.TYPE_SCROLL_INSENSITIVE,
                //ResultSet.CONCUR_READ_ONLY);
                rs = statement.executeQuery(sql);
                //statement.close();
            } catch (SQLException sqlex)
            {
                erro = "Erro: " + sqlex.toString();
                System.out.println(erro);
                rs = null;
            }
            return rs;
        }
        else
            return null;
    }

    public int getMaxPK(String tabela, String chave)
    {
        if(connect != null)
        {
            String sql = "select max(" + chave + ") from " + tabela;
            int max = 0;
            ResultSet rs = consultar(sql);
            try
            {
                if (rs.next())
                {
                    max = rs.getInt(1);
                }
            } catch (SQLException sqlex)
            {
                erro = "Erro: " + sqlex.toString();
                max = -1;
            }
            return max;
        }
        else
            return -1;
    }
}
