package br.com.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import br.com.spring.data.orm.Funcionario;
import br.com.spring.data.orm.FuncionarioProjecao;
import br.com.spring.data.repository.FuncionarioRepository;

@Repository
public class RelatoriosService {

	private Boolean system = true;
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY"); 
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scan) {
		while(system){
			System.out.println("Qual ação de cargo deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario nome, data contratacao, salario maior");
			System.out.println("3 - Busca funcionario nome, data contratacao");
			System.out.println("4 - Pesquisa funcionario salario");
			
			int acao = scan.nextInt();
			
			switch (acao) {
			case 1:
				buscaFuncionarioNome(scan);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scan);
				break;
			case 3:
				buscaFuncionarioDataContratacao(scan);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void buscaFuncionarioNome(Scanner scan) {
		System.out.println("Qual o nome deseja pesquisar");
		String nome = scan.next();
		
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	public void buscaFuncionarioNomeSalarioMaiorData(Scanner scan) {
		System.out.println("Qual noem deseja pesquisar");
		String nome = scan.next();
		
		System.out.println("Qual data contratacao deseja pesquisar");
		String data = scan.next();
		LocalDate dataContratacao = LocalDate.parse(data, formatter);
		
		System.out.println("Qual salario deseja pesquisar");
		Double salario = scan.nextDouble();
		
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, dataContratacao);
		list.forEach(System.out::println);
	}
	
	public void buscaFuncionarioDataContratacao(Scanner scan) {
		System.out.println("Qual data contratacao deseja pesquisar");
		String data = scan.next();
		LocalDate dataContratacao = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(dataContratacao);
		list.forEach(System.out::println);
	}
	
	public void pesquisaFuncionarioSalario() {
			List<FuncionarioProjecao> list = funcionarioRepository.findIdFuncionarioSalario();
			list.forEach(f -> System.out.println("Funcionario:\nId: " + f.getId()
					+ ", Nome: " + f.getNome()
					+ ", Salario: " + f.getSalario()));
	}

}
