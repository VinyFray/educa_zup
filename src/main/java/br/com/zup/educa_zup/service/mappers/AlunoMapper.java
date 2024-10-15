package br.com.zup.educa_zup.service.mappers;

import br.com.zup.educa_zup.controllers.dtos.AlunoRegisterDTO;
import br.com.zup.educa_zup.controllers.dtos.AlunoUpdateDTO;
import br.com.zup.educa_zup.models.Aluno;

public class AlunoMapper {

    public static Aluno fromAlunoRegisterDTO(AlunoRegisterDTO alunoRegisterDTO){
        Aluno aluno = new Aluno();
        aluno.setName(alunoRegisterDTO.getName());
        aluno.setCpf(alunoRegisterDTO.getCpf());
        aluno.setEmail(alunoRegisterDTO.getEmail());
        aluno.setIdade(alunoRegisterDTO.getIdade());

        return aluno;
    }

    public static Aluno fromAlunoUpdateDTO(AlunoUpdateDTO alunoUpdateDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoUpdateDTO.getId());
        aluno.setName(alunoUpdateDTO.getName());
        aluno.setCpf(alunoUpdateDTO.getCpf());
        aluno.setEmail(alunoUpdateDTO.getEmail());
        aluno.setIdade(alunoUpdateDTO.getIdade());

        return aluno;
    }
}
