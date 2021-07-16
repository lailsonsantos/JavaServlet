package br.com.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.spring.data.service.CrudCargoService;
import br.com.spring.data.service.CrudFuncionarioService;
import br.com.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private Boolean system = true;
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	public SpringDataApplication(CrudCargoService cargoService, 
			CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService, 
			RelatoriosService relatoriosService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao voce quer excutar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade de trabalho");
			System.out.println("4 - Relatorio");
			System.out.println("5 - Relatorio dinamico");
			
			Integer acao = scan.nextInt();
			
			switch (acao) {
			case 1:
				cargoService.inicial(scan);
				break;
			case 2:
				funcionarioService.inicial(scan);
				break;
			case 3:
				unidadeTrabalhoService.inicial(scan);
				break;
			case 4:
				relatoriosService.inicial(scan);
				break;
			case 5:
				relatorioFuncionarioDinamico.inicial(scan);
				break;
			default:
				system = false;
				break;
			}
		}

	}

}
