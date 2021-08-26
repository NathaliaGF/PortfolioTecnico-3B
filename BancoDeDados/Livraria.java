package livraria;
public class Livraria {
    public static void main(String[] args) {
        Banco.cria_tabela("Livro", "ISBN int primary key", "Qtde int", "Assunto varchar", "Autor varchar");
        
        Livro l = new Livro();
        l.setISPN(25);
        l.setQtde(100);
        l.setAutor("Gabriel");
        l.setAssunto("Banco de dados");
        Banco.salvar(l);
        
        Banco.visualizar_tabela("Livro", "ISBN", "Qtde", "Autor", "Assunto");
        
        Banco.cria_tabela("Editora", "Codigo int primary key", "Endereco varchar", "Gerente varchar", "Telefone int");
        
        Editora e = new Editora();
        e.setCodigo(10);
        e.setEndereco("Rua desconhecida");
        e.setGerente("Gustavo");
        e.setTelefone(3321-4567);
        Banco.salvar(e);
        
        Banco.visualizar_tabela("Editora", "Codigo", "Endereco", "Gerente", "Telefone");
        
        Banco.cria_tabela("Cliente", "Codigo int primary key", "CPF float", "CNPJ float", "Endereco varchar", "Telefone int");
        
        Cliente c = new Cliente();
        c.setCodigo(20);
        c.setCPF(1202143215);
        c.setCNPJ(1201432);
        c.setEndereco("Rua da Silva");
        c.setTelefone(3112-5313);
        Banco.salvar(c);
        
        Banco.visualizar_tabela("Cliente", "Codigo", "CPF", "CNPJ", "Endereco", "Telefone");
    }
  }
