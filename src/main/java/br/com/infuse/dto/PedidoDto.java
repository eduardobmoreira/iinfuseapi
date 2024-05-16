package br.com.infuse.dto;

import org.springframework.lang.Nullable;

import jakarta.validation.constraints.NotBlank;

public record PedidoDto(
		@NotBlank Integer numeroControle,
		@Nullable String dataCadastro,
		@Nullable String nome,
		@Nullable Double valor,
		@Nullable Integer quantidade,
		@Nullable String codigoCliente,
		@Nullable Double valorTotal
) {

}
