package chamados.dto;

import java.util.Date;


public class ChamadoDTO {
	
	private Long id;
	private Long clienteId;
	private String nomeCliente;
	private String assunto;
	private String status;
	private String complemento;
	private Date cadastradoEm;

	public ChamadoDTO() {

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

	public void setCadastradoEm(Date cadastradoEm) {
		this.cadastradoEm = cadastradoEm;
	}

}
