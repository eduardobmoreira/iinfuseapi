package br.com.infuse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infuse.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Optional<Pedido> findAllByNumeroControle(Integer numeroControle);

    List<Pedido> findAllByDataCadastro(String dataCadastro);
}
