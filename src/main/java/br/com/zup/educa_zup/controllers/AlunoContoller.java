package br.com.zup.educa_zup.controllers;

import br.com.zup.educa_zup.controllers.dtos.AlunoRegisterDTO;
import br.com.zup.educa_zup.controllers.dtos.AlunoUpdateDTO;
import br.com.zup.educa_zup.models.Aluno;
import br.com.zup.educa_zup.service.AlunoService;
import br.com.zup.educa_zup.service.mappers.AlunoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoContoller {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno registerAluno(@RequestBody @Valid AlunoRegisterDTO alunoRegisterDTO) {
        return alunoService.saveAluno(AlunoMapper.fromAlunoRegisterDTO(alunoRegisterDTO));
    }

    @GetMapping
    public List<Aluno> showAllAlunos(){
        return alunoService.showAllAlunos();
    }

    @GetMapping("/{alunoId}")
    public Aluno findAlunoById(@PathVariable Long alunoId){
        return alunoService.findAluno(alunoId);
    }

    @PutMapping
    public Aluno updateAluno(@RequestBody @Valid AlunoUpdateDTO alunoUpdateDTO){
        return alunoService.updateAluno(AlunoMapper.fromAlunoUpdateDTO(alunoUpdateDTO));
    }

    @DeleteMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable Long alunoId){
        alunoService.deleteAluno(alunoId);
    }
}
