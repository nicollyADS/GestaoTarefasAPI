package br.com.gestao.tarefas.controller;

import br.com.gestao.tarefas.model.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/public")
public class StatusController {

    @GetMapping("/status")
    public ResponseEntity<List<String>> getStatuses() {
        List<String> statuses = Arrays.stream(Status.values())
                .map(Status::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(statuses);
    }

}