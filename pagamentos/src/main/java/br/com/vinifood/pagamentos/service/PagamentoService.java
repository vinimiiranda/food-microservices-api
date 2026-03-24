package br.com.vinifood.pagamentos.service;

import br.com.vinifood.pagamentos.dto.PagamentoDto;
import br.com.vinifood.pagamentos.client.PedidoClient;
import br.com.vinifood.pagamentos.model.Pagamento;
import br.com.vinifood.pagamentos.model.Status;
import br.com.vinifood.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PedidoClient pedidoClient;

    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(p -> modelMapper.map(p, PagamentoDto.class));
    }

    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    @Transactional
    public PagamentoDto criarPagamento(PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    @Transactional
    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        modelMapper.map(dto, pagamento);
        pagamento = repository.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    @Transactional
    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void confirmaPagamento(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        pagamento.setStatus(Status.CONFIRMADO);
        repository.save(pagamento);
        pedidoClient.atualizaPagamento(pagamento.getId());
    }

    @Transactional
    public void alteraStatus(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        pagamento.setStatus(Status.CONFIRMADO_SEM_INTEGRACAO);
        repository.save(pagamento);
    }
}
