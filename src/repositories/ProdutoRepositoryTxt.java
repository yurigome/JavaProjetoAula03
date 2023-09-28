package repositories;

import java.io.PrintWriter;

import entities.Produto;
import interfaces.ProdutoRepository;

public class ProdutoRepositoryTxt implements ProdutoRepository {

	
	public void exportarDados(Produto produto) {
		
		try {
			
			PrintWriter printWriter= new PrintWriter("c:\\temp\\produto.txt");
			
			printWriter.write("\n Id do produto: " + produto.getId());
			printWriter.write("\n Nome: " + produto.getNome());
			printWriter.write("\n Preço " + produto.getPreco());
			printWriter.write("\n Quantidade: " + produto.getQuantidade());
			printWriter.write("\n Tipo " + produto.getTipo());
			printWriter.write("\n Fornecedor: " + produto.getFornecedor().getNome());
			printWriter.write("\n Cnpj " + produto.getFornecedor().getCnpj());
			
			printWriter.flush();
			printWriter.close();
			
			System.out.println("Arquivo txt gravado com sucesso");
		}
		
		catch(Exception e) {
			System.out.print("Falha ao exportar para txt");
			System.out.println(e.getMessage());
		}
	}

	
		
		
	
	
	
}
