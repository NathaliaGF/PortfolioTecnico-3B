package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Banco {
    private static Connection connection;
   
    public static Connection getConnection(){
        if(connection == null){
            try{
                //Class.forName("com.mysql.jdbc.Driver"); //para mysql
                Class.forName("org.postgresql.Driver");//para postgresql
                String host = "localhost";
                String port = "5432";
                String database = "postgres";
                String user = "postgres";
                String pass = "0227";//digitar a senha do seu banco
                //String url = "jdbc:mysql://"+host+":"+port+"/"+database; //para mysql
                String url = "jdbc:postgresql://"+host+":"+port+"/"+database;//para postgresql
                connection = DriverManager.getConnection(url, user, pass);                
               
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void close(){
        if (connection == null){
            throw new RuntimeException("Nenhuma conexão aberta!");
        }
        else{
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
 
    public static void salvar (Cliente cliente){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cliente (CPF, CNPJ, Endereco, Codigo, Telefone) values(?, ?, ?, ?, ?)");
            ps.setFloat(1, cliente.getCPF());
            ps.setFloat(2, cliente.getCNPJ());
            ps.setString(3, cliente.getEndereco());
            ps.setInt(4, cliente.getCodigo());
            ps.setInt(5, cliente.getTelefone());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void salvar (Livro livro){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Livro (Assunto, Qtde, Autor, ISPN) values(?, ?, ?, ?)");
            ps.setString(1, livro.getAssunto());
            ps.setInt(2, livro.getQtde());
            ps.setString(3, livro.getAutor());
            ps.setInt(4, livro.getISPN());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void salvar (Editora editora){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Cliente (Gerente, Endereco, Codigo, Telefone) values(?, ?, ?, ?, ?)");
            ps.setString(1, editora.getGerente());
            ps.setString(2, editora.getEndereco());
            ps.setInt(3, editora.getCodigo());
            ps.setInt(4, editora.getTelefone());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        


    public static void deleta_cliente(int Codigo){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete FROM Cliente WHERE Codigo = ?");
            ps.setInt(1, Codigo);
            ps.executeUpdate();


            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public static void deleta_livro(int ISPN){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete FROM Livro WHERE ISPN = ?");
            ps.setInt(1, ISPN);
            ps.executeUpdate();


            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        public static void deleta_editora(int Telefone){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete FROM editora WHERE Telefone = ?");
            ps.setInt(1, Telefone);
            ps.executeUpdate();


            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        public static void atualizaBanco(Cliente cliente){
            deleta_cliente(cliente.getCodigo());
            salvar(cliente);
        }
        
        public static void atualizaBanco(Livro livro){
            deleta_livro(livro.getISPN());
            salvar(livro);
        }
        
        public static void atualizaBanco(Editora editora){
            deleta_editora(editora.getTelefone());
            salvar(editora);
        }
        
        
        public static void visualizar_tabela(String tabela, String... atributo){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM "+ tabela);
            ResultSet rs = ps.executeQuery();
            
            String s = "";
            while(rs.next()){
                for(String i : atributo){
                    s = s + " | " +rs.getString(i);
                }
            }


            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        public static void cria_tabela(String tabela, String... atributo){
          try{
                Connection con = Banco.getConnection();
                String comando = "CREATE TABLE " + tabela + "";
                
                for(String i : atributo){
                    
                }
            }
        }

