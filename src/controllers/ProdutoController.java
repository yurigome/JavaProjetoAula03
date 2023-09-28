package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Fornecedor;
import entities.Produto;
import enums.TipoProduto;
import interfaces.ProdutoRepository;
import repositories.ProdutoRepositoryTxt;
import repositories.ProdutoRepositoryXml;

public class ProdutoController {

	public void cadastrarProduto() {

		Scanner scanner = new Scanner(System.in);

		try {
			Produto produto = new Produto();

			produto.setId(UUID.randomUUID());
			produto.setFornecedor(new Fornecedor());

			System.out.println("\nCADASTRO DE PRODUTO\n");

			System.out.print("Nome do produto: ");
			produto.setNome(scanner.nextLine());

			System.out.print("Preço: ");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));

			System.out.print("Quantidade: ");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

			System.out.print("Informe (1) perecível ou (2) Nao perecível: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			switch (opcao) {
			case 1:
				produto.setTipo(TipoProduto.PERECIVEL);
				break;
			case 2:
				produto.setTipo(TipoProduto.NAO_PERECIVEL);
				break;
			default:
				throw new Exception("Opção inválida");
			}

			System.out.print("Nome do fornecedor: ");
			produto.getFornecedor().setNome(scanner.nextLine());

			System.out.print("Cnpj: ");
			produto.getFornecedor().setCnpj(scanner.nextLine());

			System.out.print("Escolha (1)TXT ou (2)XTML");
			Integer tipo = Integer.parseInt(scanner.nextLine());

			ProdutoRepository produtoRepository = null;

			switch (tipo) {

			case 1:
				produtoRepository = new ProdutoRepositoryTxt();
				break;

			case 2:
				produtoRepository = new ProdutoRepositoryXml();

				break;
				
				default:
					throw new Exception("Tipo de arquivo invalido");
					
			}

			
			
			produtoRepository.exportarDados(produto);
			
		}

		catch (Exception e) {

			System.out.print("\nFalha ao cadastrar protudo");
			System.out.print(e.getMessage());

		}

		finally {
			scanner.close();
		}

	}

}