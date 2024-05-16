package br.com.infuse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infuse.converter.PedidoConverter;
import br.com.infuse.dto.PedidoDto;
import br.com.infuse.entity.Pedido;
import br.com.infuse.repository.PedidoRepository;

@Service
public class PedidoService {
	private PedidoRepository pedidoRepository;
	private PedidoConverter pedidoConverter;

	@Autowired
	public PedidoService(PedidoRepository pedidoRepository, PedidoConverter pedidoConverter) {
		this.pedidoRepository = pedidoRepository;
		this.pedidoConverter = pedidoConverter;
	}

	public List<PedidoDto> buscarTodosOsRegistros() {
		List<Pedido> pedidoList = pedidoRepository
				.findAll();
		return pedidoConverter.converterModelList(pedidoList);
	}

	public PedidoDto buscarPedidoPorNumeroControle(final String numeroConrole) {
		try {
			Pedido pedido = pedidoRepository.findAllByNumeroControle(Integer.parseInt(numeroConrole)).orElseThrow(() -> null);
			return pedidoConverter.converterModel(pedido);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<PedidoDto> buscarPedidoPorDataCadastro(final String dataCadastro) {
		List<Pedido> pedidoList = pedidoRepository
				.findAllByDataCadastro(dataCadastro);
		return pedidoConverter.converterModelList(pedidoList);
	}
}