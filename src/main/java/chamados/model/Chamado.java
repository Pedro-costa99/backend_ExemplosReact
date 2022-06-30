package chamados.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "chamados")
public class Chamado {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "cliente_id")
	private Long clienteId;
	@Size(min=3, max=100)
	@Column(name = "nome_cliente")
	private String nomeCliente;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "assunto")
	private String assunto;
	@NotNull
	@Column(name = "status_chamado")
	private String status;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "complemento")
	private String complemento;
	@NotNull
	@Column(name = "cadastrado_em")
	private Date cadastradoEm;

	public Chamado(@NotNull Long clienteId,
			@NotNull @Size(min = 3, max = 100) String nomeCliente, @NotNull String assunto,
			@NotNull String complemento, String status) {
		this.clienteId = clienteId;
		this.nomeCliente = nomeCliente;
		this.assunto = assunto;
		this.status = status;
		this.complemento = complemento;
		this.cadastradoEm = setCadastradoEm();
	}

	public Chamado() {

	}

	public Long getId() {
		return id;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
			this.status = status;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String endereco) {
		this.complemento = endereco;
	}
	public Date getCadastradoEm() {
		return cadastradoEm;
	}
	public Date setCadastradoEm() {
		return new Date();
	}

}
