package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexao.ConexaoTeste;
import Entity.Endereco;

public class enderecoDAO {

	public void salvar(Endereco endereco) {

		String sql = "INSERT INTO endereco (rua, cep, bairro, cidade, estado, numero, complemento ) VALUES (?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria uma conexão com o banco.
			conn = ConexaoTeste.createConnectionToMySQL();

			// Cria uma PreparedStatement para executar uma query.
			pstm = conn.prepareStatement(sql);
			// Adicionar os valores esperados pela query.
			pstm.setString(1, endereco.getBairro());
			pstm.setString(2, endereco.getCidade());
			pstm.setString(3, endereco.getComplemento());
			pstm.setString(4, endereco.getEstado());
			pstm.setString(5, endereco.getRua());
			pstm.setInt(6, endereco.getCep());
			pstm.setInt(7, endereco.getNumero());
			
			
			
			// Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
