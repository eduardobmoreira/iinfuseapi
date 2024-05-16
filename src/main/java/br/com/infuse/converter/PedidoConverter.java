package br.com.infuse.converter;

import org.springframework.stereotype.Component;

import br.com.infuse.dto.PedidoDto;
import br.com.infuse.entity.Pedido;

@Component
public class PedidoConverter extends Converter<PedidoDto, Pedido>{
	
	public PedidoConverter() {
		super(PedidoConverter::converterModel, PedidoConverter::converterDto);
	}

	private static Pedido converterModel(PedidoDto dto) {
		if (dto == null)
			return null;

		return new Pedido(dto.numeroControle(), dto.dataCadastro(), dto.nome(), dto.valor(),
				dto.quantidade(), dto.codigoCliente(), dto.valorTotal());
	}

	private static PedidoDto converterDto(Pedido model) {
		if (model == null)
			return null;

		return new PedidoDto(model.getNumeroControle(), model.getDataCadastro(), model.getNome(), model.getValor(),
				model.getQuantidade(), model.getCodigoCliente(), model.getValorTotal());
	}

}
