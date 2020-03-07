package web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private static List<Produto> lista;

	private DataModel<Produto> produtos;
	
	@PostConstruct
	public void init() {
		lista = new ArrayList<Produto>();
		lista.add(new Produto("Iphone", 9000.0));
		lista.add(new Produto("Xiaomi", 200.0));
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	
	//actions
	
	public String editarProdutoForm() {
		//A lista de produtos do Datamodel é recuperada no getRowData
		//a partir daí conseguimos ter exatamente a linha clicada
		produto = (Produto) (produtos.getRowData());
		
		return "produto_edit";
	}
	
	public String salvarProduto() {
		lista.add(produto);
		
		return "home";
	}
	
	public String adicionaForm() {
		produto = new Produto();		
		return "produto_form";
	}
	
	public String excluirProduto() {
		//A lista de produtos do Datamodel é recuperada no getRowData
		//a partir daí conseguimos ter exatamente a linha clicada
		Produto p = (Produto) (produtos.getRowData());
		lista.remove(p);
		
		return "home";
	}
	
	public String listarProdutos() {
		return "home";
	}

	
	//gets e sets
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DataModel<Produto> getProdutos() {
		produtos = new ListDataModel<Produto>(lista);
		return produtos;
	}

	public void setProdutos(DataModel<Produto> produtos) {
		this.produtos = produtos;
	}

	
	
}
