package br.com.gestao.tarefas.controller;

import br.com.gestao.tarefas.dto.TarefaDto.CadastroTarefaDto;
import br.com.gestao.tarefas.dto.TarefaDto.DetalhesTarefaDto;
import br.com.gestao.tarefas.model.Tarefa;
import br.com.gestao.tarefas.repository.TarefaRepository;
import br.com.gestao.tarefas.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;

@RestController
@RequestMapping("tasks")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //post
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesTarefaDto> post(@RequestBody @Valid CadastroTarefaDto tarefaDto,
                                                  UriComponentsBuilder uriBuilder){
        var tarefa = new Tarefa(tarefaDto);
        var usuario = usuarioRepository.getReferenceById(tarefaDto.idUsuario());

        tarefa.setUsuario(usuario);

        tarefa = tarefaRepository.save(tarefa);
        var uri = uriBuilder.path("tasks/{id}").buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesTarefaDto(tarefa));
    }

    //get
    @GetMapping
    public ResponseEntity<List<DetalhesTarefaDto>> get(Pageable pageable){
        var tarefa = tarefaRepository.findAll(pageable)
                .stream().map(DetalhesTarefaDto::new).toList();
        return ResponseEntity.ok(tarefa);
    }


    //get by id
    @GetMapping("{id}")
    public ResponseEntity<DetalhesTarefaDto> get(@PathVariable("id")Long id){
        var tarefa = tarefaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesTarefaDto(tarefa));
    }


    //put
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesTarefaDto> put(@PathVariable("id")Long id,
                                                  @RequestBody @Valid CadastroTarefaDto dto){
        var tarefa = tarefaRepository.getReferenceById(id);
        tarefa.atualizarInformacoesTarefa(dto);
        return ResponseEntity.ok(new DetalhesTarefaDto(tarefa));
    }


    //delete
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        tarefaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
