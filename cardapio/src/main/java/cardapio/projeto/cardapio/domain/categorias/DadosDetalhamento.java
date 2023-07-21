package cardapio.projeto.cardapio.domain.categorias;

public record DadosDetalhamento(
        long id,
        String nome,
        String descricao
) {
    public DadosDetalhamento(Categoria categoria)
    {
        this(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

}
