package cardapio.projeto.cardapio.domain.produtos;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(
        Long id,
        String nome,
        String descricao,
        double preco
) {
}
