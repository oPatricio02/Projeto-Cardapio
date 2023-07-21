package cardapio.projeto.cardapio.controller;

import cardapio.projeto.cardapio.domain.categorias.Categoria;
import cardapio.projeto.cardapio.domain.categorias.CategoriaRepository;
import cardapio.projeto.cardapio.domain.produtos.DadosAtualizacaoProduto;
import cardapio.projeto.cardapio.domain.produtos.DadosCadastroProduto;
import cardapio.projeto.cardapio.domain.produtos.Produto;
import cardapio.projeto.cardapio.domain.produtos.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody DadosCadastroProduto dados)
    {
        Produto p = new Produto(dados);
        repository.save(p);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity read()
    {
        var lista = repository.findByAtivoTrue();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody DadosAtualizacaoProduto dados)
    {
        Produto produto = repository.getReferenceById(dados.id());
        produto.atualizar(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id)
    {
        var produto = repository.getReferenceById(id);
        produto.excluir();
        return ResponseEntity.noContent().build();
    }



}
