package br.com.zup.educa_zup.service;

import br.com.zup.educa_zup.models.Aluno;
import br.com.zup.educa_zup.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno saveAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> showAllAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno findAluno(Long id){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        return alunoOptional.orElseThrow(() -> new RuntimeException("Aluno not found"));
    }

    @Transactional
    public Aluno updateAluno(Aluno aluno){
        Aluno alunoDB = findAluno(aluno.getId());

        if(!alunoDB.getName().equals(aluno.getName())){
            alunoDB.setName(aluno.getName());
        }
        if (alunoDB.getIdade() != aluno.getIdade()){
            alunoDB.setIdade(aluno.getIdade());
        }
        if (!alunoDB.getEmail().equals(aluno.getEmail())){
            alunoDB.setEmail(aluno.getEmail());
        }
        if (!alunoDB.getCpf().equals(aluno.getCpf())){
            alunoDB.setCpf(aluno.getCpf());
        }

        return saveAluno(alunoDB);
    }

    public void deleteAluno(Long id){
        alunoRepository.deleteById(id);
    }
}
