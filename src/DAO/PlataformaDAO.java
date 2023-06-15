package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexao.ConexaoBD;
import Entity.Plataforma;

public class PlataformaDAO {

	
	public List<Plataforma> getPlataformas() {
		
		String sql = "SELECT * FROM plataforma";
		
		List<Plataforma> plataformas = new ArrayList<Plataforma>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. SELECT
		ResultSet rst = null;
		
		try {
			conn = ConexaoBD.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
	
			rst = pstm.executeQuery();
			
			while (rst.next()) {

				Plataforma plataforma = new Plataforma();
		
				plataforma.setId_plataforma(rst.getLong("id_plataforma"));
				plataforma.setNome_plataforma(rst.getString("nome_plataforma"));
				
				
				plataformas.add(plataforma);
			
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
		return plataformas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
