package br.com.zup.educa_zup.controllers.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class AlunoRegisterDTO {
    @Size(min = 5, message = "name not valid")
    private String name;
    @Min(11)
    private int idade;
    private String email;
    @CPF(message = "cpf not valid")
    private String cpf;

    public AlunoRegisterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
