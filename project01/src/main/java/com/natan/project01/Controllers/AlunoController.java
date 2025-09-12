package com.natan.project01.Controllers;

import com.natan.project01.Models.Aluno;
import com.natan.project01.Repositories.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping("/getall")
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Long id) {
        return alunoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @PostMapping
    public String save(@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
        return "Aluno created succesfully";
    }

    @PutMapping
    public Aluno update(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping
    public void delete(@RequestBody Aluno aluno) {
        alunoRepository.delete(aluno);
    }
}
