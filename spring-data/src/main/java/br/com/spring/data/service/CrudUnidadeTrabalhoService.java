package br.com.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.data.orm.UnidadeTrabalho;
import br.com.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {
	
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	private Boolean system = true;
	
	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public void inicial(Scanner scan) {
		while(system){
			System.out.println("Qual ação de cargo deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int acao = scan.nextInt();
			
			switch (acao) {
			case 1:
				salvar(scan);
				break;
			case 2:
				atualizar(scan);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scan);
				break;
			default:
				system = false;
				break;
			}
		}
		
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome da unidade");
        String nome = scanner.next();

        System.out.println("Digite o endereco");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(nome);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id");
        Integer id = scanner.nextInt();

        System.out.println("Digite o nome da unidade");
        String nome = scanner.next();

        System.out.println("Digite o endereco");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescricao(nome);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Alterado");
	}
	
	private void visualizar() {
		Iterable<UnidadeTrabalho> unidadetrabalhoIterable = unidadeTrabalhoRepository.findAll();
		unidadetrabalhoIterable.forEach(unidadetrabalho -> System.out.println(unidadetrabalho));
	}
	
	private void deletar(Scanner scan) {
		System.out.println("Id");
		Integer id = scan.nextInt();
		
		unidadeTrabalhoRepository.deleteById(id);
		
		System.out.println("Deletado");
	}
	
}
