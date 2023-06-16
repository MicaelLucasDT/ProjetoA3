package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexao.ConexaoBD;
import Entity.Jogo;


public class JogoDAO {

	
	public void salvar (Jogo jogo) {
		
		String sql = "INSERT INTO jogo_digital (nome, ano_lancamento, id_empresa, id_plataforma) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		 
		try {
			//cria uma conexão com o banco.		
			conn = ConexaoBD.createConnectionToMySQL();
			
			//Cria uma PreparedStatement para executar uma query. 
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query.
			pstm.setString(1, jogo.getNome());
			pstm.setInt(2, jogo.getAnoLancamento());
			pstm.setLong(3, jogo.getIdEmpresa());
			pstm.setLong(4, jogo.getIdPlataforma());

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
		
		String sql = "UPDATE jogo_digital SET nome = ?, ano_lancamento = ?, id_empresa = ?, id_plataforma = ? WHERE id_jogo = ?";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConexaoBD.createConnectionToMySQL();
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores para atualizar.
			pstm.setString(1, jogo.getNome());
			pstm.setInt(2, jogo.getAnoLancamento());
			pstm.setLong(3, jogo.getIdEmpresa());
			pstm.setLong(4, jogo.getIdPlataforma());
			
			//Qual o ID do registo que deseja atualizar.
			pstm.setLong(5, jogo.getIdJogo());
			
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
			conn = ConexaoBD.createConnectionToMySQL();
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
			conn = ConexaoBD.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
	
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				Jogo jogo = new Jogo();
				
				
				
				jogo.setIdJogo(rst.getLong("id_jogo"));
				jogo.setNome(rst.getString("nome"));
				jogo.setAnoLancamento(rst.getInt("ano_lancamento"));
				jogo.setIdEmpresa(rst.getLong("id_empresa"));
				jogo.setIdPlataforma(rst.getLong("id_plataforma"));
				
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

