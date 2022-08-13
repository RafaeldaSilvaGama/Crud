package br.com.fiap;
import java.util.*;
import java.sql.*;

public class ProdutosDAO {
	
	private Connection con;
	
	public ProdutosDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Produtos produto) {
		String sql = "insert into equipamentos(produto,marca,preco) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, produto.getProduto());
			ps.setString(2, produto.getMarca());
			ps.setDouble(3, produto.getPreco());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	} 
	
	public String alterar(Produtos produto) {
		String sql = "update equipamentos set marca = ?, preco = ?, where produto = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, produto.getMarca());
			ps.setDouble(2, produto.getPreco());
			ps.setString(3, produto.getProduto());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else { 
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public String excluir(Produtos produto) {
		String sql = "delete from equipamentos where produto = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1 ,produto.getProduto());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	public ArrayList<Produtos> listarProdutos() {
		ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();
		String sql = "select * from equipamentos";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Produtos pr = new Produtos();
					pr.setProduto(rs.getString(1));
					pr.setMarca(rs.getString(2));
					pr.setPreco(rs.getDouble(3));
					listaProdutos.add(pr);
				}
				return listaProdutos;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			return null;
		}
	}
	
}
