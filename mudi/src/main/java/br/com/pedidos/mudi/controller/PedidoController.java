package br.com.pedidos.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pedidos.mudi.dto.RequisicaoNovoPedido;
import br.com.pedidos.mudi.model.Pedido;
import br.com.pedidos.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @RequestMapping(method = RequestMethod.GET, value="formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return "pedido/formulario";
    }

    @RequestMapping(method = RequestMethod.POST, value="novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
    	
    	if (result.hasErrors()) {
    		return "pedido/formulario";
		}
    	
        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }

}

