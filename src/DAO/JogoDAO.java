package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexao.ConexaoTeste;
import Entity.Jogo;


public class JogoDAO {

	
	public void salvar (Jogo jogo) {
		
		String sql = "INSERT INTO jogo_digital (nome_jogo, ano_lancamento, id_empresa) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		 
		try {
			//cria uma conexão com o banco.		
			conn = ConexaoTeste.createConnectionToMySQL();
			
			//Cria uma PreparedStatement para executar uma query. 
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query.
			pstm.setString(1, jogo.getNome_jogo());
			pstm.setString(2, jogo.getAno_lancamento());
			pstm.setLong(3, jogo.getId_empresa());
			

			//Executar a query
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//fechar as conexões
			try {
				if(pstm != null) {
					pstm.close();
				}if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}

	
	public void atualizar(Jogo jogo) {
		
		String sql = "UPDATE jogo_digital SET nome_jogo = ?, ano_lancamento = ?, id_empresa = ?" + 
				"WHERE id_funcionario = ?";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConexaoTeste.createConnectionToMySQL();
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores para atualizar.
			pstm.setString(1, jogo.getNome_jogo());
			pstm.setString(2, jogo.getAno_lancamento());
			pstm.setLong(3, jogo.getId_empresa());

			//Qual o ID do registo que deseja atualizar.
			pstm.setLong(4, jogo.getId_jogo());
			
			//Executar a query
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void apagarByID (int cod_cliente) {
		
		String sql = "DELETE FROM jogo_digital WHERE id_jogo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexaoTeste.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cod_cliente);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public List<Jogo> getJogos() {
		
		String sql = "SELECT * FROM jogo_digital";
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. SELECT
		ResultSet rst = null;
		
		try {
			conn = ConexaoTeste.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
	
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				Jogo jogo = new Jogo();
				
				
				
				jogo.setId_jogo(rst.getLong("id_jogo"));
				
				jogo.setNome_jogo(rst.getString("nome_jogo"));
				
				jogo.setAno_lancamento(rst.getString("ano_lancamento"));
				
				jogo.setId_empresa(rst.getLong("id_empresa"));
				
				jogos.add(jogo);
			
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(rst != null) {
						rst.close();
					}if(pstm != null) {
						pstm.close();
					}if(conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}	
		return jogos;
	}

	

}	

