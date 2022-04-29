package domain;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String modeloDesejado;

    public Cliente(String cpf, String nome, String telefone, String endereco, String modeloDesejado) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.modeloDesejado = modeloDesejado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getModeloDesejado() {
        return modeloDesejado;
    }

    public void setModeloDesejado(String modeloDesejado) {
        this.modeloDesejado = modeloDesejado;
    }

    @Override
    public String toString() {
        return "\nCliente\n" +
                "cpf=" + cpf +
                ", nome=" + nome +
                ", telefone=" + telefone +
                ", endereco=" + endereco +
                ", modeloDesejado=" + modeloDesejado  +
                '\n';
    }
}
