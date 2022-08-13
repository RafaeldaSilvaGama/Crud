package br.com.fiap;

import java.sql.*;
import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		Produtos pr = new Produtos();
		ProdutosDAO pd = new ProdutosDAO(con);

		// testando metodo inserir;
		pr.setProduto("Luva de boxe");
		pr.setMarca("Pretorian");
		pr.setPreco(150.00);
		System.out.println(pd.inserir(pr));

		// testando metodo alterar
		pr.setProduto("Luva de boxe");
		pr.setMarca("Mks");
		pr.setPreco(190.00);
		System.out.println(pd.alterar(pr));

		// testando metodo excluir
		pr.setProduto("Luva de boxe");
		System.out.println(pd.excluir(pr));

		// testando metodo listarProdutos
		ArrayList<Produtos> lista = pd.listarProdutos();
		if (lista != null) {
			for (Produtos produtos : lista) {
				System.out.println("Produto: " + produtos.getProduto());
				System.out.println("Marca: " + produtos.getMarca());
				System.out.println("Preço: " + produtos.getPreco());
			}
		}

		Conexao.fecharConexao(con);

	}

}
