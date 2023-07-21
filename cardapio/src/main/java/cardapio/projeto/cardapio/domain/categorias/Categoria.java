package cardapio.projeto.cardapio.domain.categorias;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static cardapio.projeto.cardapio.domain.categorias.Valor.VALOR;

@Entity(name = "Categoria")
@Table(name = "categorias")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Valor valor;
    private boolean ativo;

    public Categoria(DadosCadastroCategoria dados)
    {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.valor = VALOR;
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacao dados)
    {
        if(dados.nome() != null)
            this.nome = dados.nome();
        if(dados.descricao() != null)
            this.descricao = dados.descricao();
    }


    public void excluir()
    {
        this.ativo = false;
    }


}
