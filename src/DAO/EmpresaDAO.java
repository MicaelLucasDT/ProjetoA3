package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexao.ConexaoBD;
import Entity.Empresa;


public class EmpresaDAO {

	
	public void salvar (Empresa empresa) {
		
		String sql = "INSERT INTO empresa (nome, cnpj) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		 
		try {
			//cria uma conexão com o banco.		
			conn = ConexaoBD.createConnectionToMySQL();
			
			//Cria uma PreparedStatement para executar uma query. 
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query.
			pstm.setString(1, empresa.getNome());
			pstm.setString(2, empresa.getCnpj());
			

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

	public List<Empresa> getEmpresas() {
		
		String sql = "SELECT * FROM empresa";
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. SELECT
		ResultSet rst = null;
		
		try {
			conn = ConexaoBD.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
	
			rst = pstm.executeQuery();
			
			while (rst.next()) {

				Empresa empresa = new Empresa();
		
				empresa.setIdEmpresa(rst.getLong("id_empresa"));
				empresa.setNome(rst.getString("nome"));
				empresa.setCnpj(rst.getString("cnpj"));
				
				empresas.add(empresa);
			
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
		return empresas;
	}

	public void atualizar(Empresa empresa) {
		
		String sql = "UPDATE empresa SET nome = ?, cnpj = ?" + 
				"WHERE id_empresa = ?";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConexaoBD.createConnectionToMySQL();
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores para atualizar.
			pstm.setString(1, empresa.getNome());
			pstm.setString(2, empresa.getCnpj());

			//Qual o ID do registo que deseja atualizar.
			pstm.setLong(3, empresa.getIdEmpresa());
			
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
	
	public void apagarByID (int id_empresa) {
		
		String sql = "DELETE FROM empresa WHERE id_empresa = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexaoBD.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_empresa);
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
	
}	

