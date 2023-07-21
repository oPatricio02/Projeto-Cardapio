package cardapio.projeto.cardapio.domain.produtos;

import cardapio.projeto.cardapio.domain.categorias.Categoria;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        String nome,
        String descricao,
        Long idCategoria,
        double preco) {
}
