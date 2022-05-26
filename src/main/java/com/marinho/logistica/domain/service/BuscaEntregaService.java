package com.marinho.logistica.domain.service;

import org.springframework.stereotype.Service;

import com.marinho.logistica.domain.exception.EntidadeNaoEncontradaException;
import com.marinho.logistica.domain.model.Entrega;
import com.marinho.logistica.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
