package br.com.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.data.orm.Cargo;
import br.com.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository cargoRepository;
	private Boolean system = true;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
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
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Descricao do Cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scan) {
		System.out.println("Id");
		Integer id = scan.nextInt();
		
		cargoRepository.deleteById(id);
		
		System.out.println("Deletado");
	}
	
}
