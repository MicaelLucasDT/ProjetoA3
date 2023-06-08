package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexao.ConexaoTeste;
import Entity.PlataformaJogo;


public class PlataformajogoDAO {

		
	public void salvar (PlataformaJogo plataformajogo) {
			
		String sql = "INSERT INTO plataforma_jogo (id_jogo, id_plataforma) VALUES (?, ?)";
			
		Connection conn = null;
		PreparedStatement pstm = null;
			
			 
		try {
			//cria uma conexão com o banco.		
			conn = ConexaoTeste.createConnectionToMySQL();
				
			//Cria uma PreparedStatement para executar uma query. 
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query.
			pstm.setLong(1, plataformajogo.getId_jogo());
			pstm.setLong(2, plataformajogo.getId_plataforna());
				

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

		
	public void atualizar(PlataformaJogo plataformajogo) {
			
		String sql = "UPDATE plataforma_jogo SET id_jogo = ?, id_plataforma = ?" + 
				"WHERE id_jogo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
			
		try {
			//Criar conexão com o banco
			conn = ConexaoTeste.createConnectionToMySQL();
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores para atualizar.
			pstm.setLong(1, plataformajogo.getId_jogo());
			//Qual o ID do registo que deseja atualizar.
			pstm.setLong(4, plataformajogo.getId_plataforna());
				
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
		
		
	public void apagarByID (int id_jogo) {
			
		String sql = "DELETE FROM plataforma_jogo WHERE id_jogo = ?";
			
		Connection conn = null;
		PreparedStatement pstm = null;
			
		try {
			conn = ConexaoTeste.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_jogo);
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
		

		
	public List<PlataformaJogo> getPlataformajogo() {
			
		String sql = "SELECT * FROM plataforma_jogo";
			
		List<PlataformaJogo> plataformajogos = new ArrayList<PlataformaJogo>();
			
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. SELECT
		ResultSet rst = null;
			
		try {
			conn = ConexaoTeste.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
	
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				PlataformaJogo plataformajogo = new PlataformaJogo();
					
					
				plataformajogo.setId_jogo(rst.getLong("id_jogo"));		
				plataformajogo.setId_plataforna(rst.getLong("id_plataforma"));
					
				plataformajogos.add(plataformajogo);
				
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
		return plataformajogos;
	}

	}	
	
	
	
	
	
	
	
	
	

