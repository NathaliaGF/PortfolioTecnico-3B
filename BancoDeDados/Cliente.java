package livraria;
public class Cliente {
    private float CPF;
    private float CNPJ;
    private String Endereco;
    private int Codigo;
    private int Telefone;

    public float getCPF() {
        return CPF;
    }

    public void setCPF(float CPF) {
        this.CPF = CPF;
    }

    public float getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(float CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }
    
    
}
