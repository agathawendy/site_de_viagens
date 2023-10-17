package modelos;

public class Compras {
	
	private int id;
	private String dataCompra;
	
	Usuario usuario;
	Passagem passagem;
	
	
	
	public Compras() {
	}



	public Compras(int id, String dataCompra, Usuario usuario, Passagem passagem) {
		this.id = id;
		this.dataCompra = dataCompra;
		this.usuario = usuario;
		this.passagem = passagem;
	}



	public Compras(String dataCompra, Usuario usuario, Passagem passagem) {
		this.dataCompra = dataCompra;
		this.usuario = usuario;
		this.passagem = passagem;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDataCompra() {
		return dataCompra;
	}



	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Passagem getPassagem() {
		return passagem;
	}



	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}



	@Override
	public String toString() {
		return "Compras [id=" + id + ", dataCompra=" + dataCompra + ", usuario=" + usuario + ", passagem=" + passagem
				+ "]";
	}
	
	
	

}
