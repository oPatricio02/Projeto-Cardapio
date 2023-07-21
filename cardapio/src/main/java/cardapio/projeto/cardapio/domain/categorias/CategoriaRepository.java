package cardapio.projeto.cardapio.domain.categorias;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    List<Categoria> findAllByAtivoTrue();
}
