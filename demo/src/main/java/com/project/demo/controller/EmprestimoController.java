package com.project.demo.controller;


import com.project.demo.classes.Emprestimo;
import com.project.demo.classes.Usuario;
import com.project.demo.classes.Exemplar;
import com.project.demo.repositories.EmprestimoRepo;
import com.project.demo.repositories.UsuarioRepo;
import com.project.demo.repositories.ExemplarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepo emprestimoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ExemplarRepo exemplarRepo;


    // Listar todos os empréstimos
    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoRepo.findAll();
    }

    // Registrar um novo empréstimo (POST)
    @PostMapping("/registrar")
    public Emprestimo criarEmprestimo(@RequestParam int registroUsuario, @RequestParam int codigoExemplar) {
        Usuario usuario = usuarioRepo.findById(registroUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Exemplar exemplar = exemplarRepo.findById(codigoExemplar)
                .orElseThrow(() -> new RuntimeException("Exemplar não encontrado."));

        Emprestimo novoEmprestimo = new Emprestimo(usuario, exemplar);

        // Salvar as alterações no exemplar e no usuário
        exemplarRepo.save(exemplar);
        usuarioRepo.save(usuario);

        return emprestimoRepo.save(novoEmprestimo);
    }

    // Registrar uma devolução (PUT)
    @PutMapping("/devolver/{id}")
    public Emprestimo devolverLivro(@PathVariable int id) {
        Emprestimo emprestimo = emprestimoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado."));

        emprestimo.registrarDevolucao();

        // Atualiza o status no banco de dados para o exemplar e usuário
        exemplarRepo.save(emprestimo.getExemplar());
        usuarioRepo.save(emprestimo.getUsuario());

        return emprestimoRepo.save(emprestimo);
    }
}