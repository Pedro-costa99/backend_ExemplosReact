package chamados.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;


@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=3, max=100)
	private String nome;
	@NotNull
	@Pattern(regexp="\\d{14}", message = "14 dígitos é o máximo.")
	@CNPJ
	@Column(name = "cnpj", unique=true)
	private String cnpj;
	@NotNull
	@Size(min=3, max=140)
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "chamados")
	@OneToMany
	private List<Chamado> chamados;
	
	public Cliente() {
		
	}

	public Cliente(@NotNull @Size(min = 3, max = 100) String nome,
			@NotNull @Pattern(regexp = "\\d{14}", message = "14 dígitos é o máximo.") @CNPJ String cnpj,
			@NotNull @Size(min = 3, max = 140) String endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.chamados = new ArrayList<>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void adicionarChamado(Chamado chamado) {
		this.chamados.add(chamado);
	}

}
