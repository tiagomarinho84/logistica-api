package com.marinho.logistica.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.marinho.logistica.domain.model.Entrega;
import com.marinho.logistica.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;

	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);

		entrega.finalizar();

		entregaRepository.save(entrega);
	}

}
