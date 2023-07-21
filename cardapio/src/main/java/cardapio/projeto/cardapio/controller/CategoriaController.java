package cardapio.projeto.cardapio.controller;

import cardapio.projeto.cardapio.domain.categorias.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody DadosCadastroCategoria dados)
    {
        Categoria categoria = new Categoria(dados);
        repository.save(categoria);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity read()
    {
        var lista = repository.findAllByAtivoTrue();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity readId(@PathVariable Long id)
    {
        var categoria = repository.getReferenceById(id);
        if(categoria.isAtivo())
            return ResponseEntity.ok(new DadosDetalhamento(categoria));
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody DadosAtualizacao dados)
    {
        var categoria = repository.getReferenceById(dados.id());
        categoria.atualizarInformacoes(dados);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id)
    {
        var categoria = repository.getReferenceById(id);
        categoria.excluir();
        return ResponseEntity.noContent().build();
    }

}
