package com.marinho.logistica.domain.repository;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marinho.logistica.domain.model.Cliente;
import com.marinho.logistica.domain.model.Entrega;
import com.marinho.logistica.domain.model.StatusEntrega;
import com.marinho.logistica.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());

		return entregaRepository.save(entrega);
	}
}
