package br.com.vinifood.pagamentos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("pedidos-ms")
public interface PedidoClient {

    @PutMapping("/pedidos/{id}/pago")
    void atualizaPagamento(@PathVariable("id") Long id);


}
