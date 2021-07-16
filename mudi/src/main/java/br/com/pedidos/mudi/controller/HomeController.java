package br.com.pedidos.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pedidos.mudi.model.Pedido;
import br.com.pedidos.mudi.model.StatusPedido;
import br.com.pedidos.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model) {
		List<Pedido> listaPedido = pedidoRepository.findAll();
		model.addAttribute("pedidos", listaPedido);
		return "home";
	}
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model) {
		List<Pedido> listaPedido = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", listaPedido);
		model.addAttribute("status", status);
		return "home";
	}
	
	@ExceptionHandler
	public String onErros() {
		return "redirect:/home";
	}
	
}
