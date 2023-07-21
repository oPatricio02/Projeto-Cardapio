package cardapio.projeto.cardapio.domain.produtos;

import cardapio.projeto.cardapio.domain.categorias.Categoria;
import cardapio.projeto.cardapio.domain.categorias.DadosAtualizacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Entity(name = "Produto")
@Table(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private long categoria;

    private String nome;
    private String descricao;

    private double valor;
    private boolean ativo;

  public Produto(DadosCadastroProduto dados)
  {
      this.categoria = dados.idCategoria();
      this.nome = dados.nome();
      this.descricao = dados.descricao();
      this.valor = dados.preco();
      this.ativo = true;
  }


    public void atualizar(DadosAtualizacaoProduto dados)
    {
        if(dados.nome() != null)
            this.nome = dados.nome();
        if(dados.descricao() != null)
            this.descricao = dados.descricao();
        if(dados.preco() != 0)
            this.valor = dados.preco();
    }


    public void excluir()
    {
        this.ativo = false;
    }

}
