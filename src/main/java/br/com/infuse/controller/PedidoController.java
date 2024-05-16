package br.com.infuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infuse.dto.PedidoDto;
import br.com.infuse.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/transacao", consumes ="application/json", produces = "application/json")
public class PedidoController {
	
	private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/")
    public ResponseEntity<String> helloWord() {
        return ResponseEntity.ok("Bem vindo!");
    }

    @PostMapping(value = "/pedido")
    public ResponseEntity<PedidoDto> processarPagamento(@Valid @RequestBody PedidoDto pedido) {
        return pedido == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(pedido);
    }

    @GetMapping(value = "/todosPedidos")
    public ResponseEntity<List<PedidoDto>> getAllPagamento() {
    	List<PedidoDto> pedidoList = pedidoService.buscarTodosOsRegistros();
    	return pedidoList.isEmpty() ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(pedidoList);
    }
    
    @GetMapping(value = "/pedido/{id}")
    public ResponseEntity<PedidoDto> getPedidoByNumeroControle(@PathVariable String id) {
        PedidoDto pedidoDto = pedidoService.buscarPedidoPorNumeroControle(id);
        return pedidoDto == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(pedidoDto);
    }

    @GetMapping(value = "/pedido-por-data/{data}")
    public ResponseEntity<List<PedidoDto>> getPedidoByDataCadastro(@PathVariable String data) {
        List<PedidoDto> pedidoList = pedidoService.buscarPedidoPorDataCadastro(data);
        return pedidoList.isEmpty() ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(pedidoList);
    }

}
