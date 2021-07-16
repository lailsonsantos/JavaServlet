package br.com.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.data.orm.Funcionario;
import br.com.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
	JpaSpecificationExecutor<Funcionario>{
	
	// Pesquisa por nome
	// Derived Queries
	List<Funcionario> findByNome(String nome);
	
	//novo método com paginação
    List<Funcionario> findByNome(String nome, Pageable pageable);
	
	// JPQL
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome"
			+ "AND f.salario >= :salario AND f.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
	
	// Native Query
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	// Native Query
	@Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f", nativeQuery = true)
	List<FuncionarioProjecao> findIdFuncionarioSalario();
	
	// Para executar um Like String nome = "%maria%";
	List<Funcionario> findByNomeLike(String nome);
	
	// Starting - prefixo
	List<Funcionario> findByNomeEndingWith(String nome);
	
	// Ending - sufixo
	List<Funcionario> findByNomeStartingWith(String nome);
	
	// Null
	List<Funcionario> findByNomeIsNull();
	
	// not Null
	List<Funcionario> findByNomeIsNotNull();
	
	// Ordenação
	List<Funcionario> findByNomeOrderByNomeAsc(String nome);
	
	// Usando JPQL
	@Query("SELECT f FROM Funcionario f JOIN f.unidadeTrabalhos u WHERE u.descricao = :descricao")
	List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
}
