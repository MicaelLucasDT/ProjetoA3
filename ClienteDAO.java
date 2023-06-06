package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoTeste;
import Entity.Cliente;

public class ClienteDAO {

	
	public void salvar (Cliente cliente) {
		
		String sql = "INSERT INTO cliente (cpf_cliente, telefone_cli, data_aniversario, cod_empresa, cod_endereco ) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		 
		try {
			//cria uma conexão com o banco.		
			conn = ConexaoTeste.createConnectionToMySQL();
			
			//Cria uma PreparedStatement para executar uma query. 
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query.
			pstm.setString(1, cliente.getCpf_cliente());
			pstm.setString(2, cliente.getData_aniversario());
			pstm.setString(3, cliente.getEmpresa());
			pstm.setString(4, cliente.getTelefone_cliente());
			pstm.setString(5, cliente.getEndereco());

			

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

	
	public void atualizar(Cliente cliente) {
		
		String sql = "UPDATE cliente SET cpf_cliente = ?, telefone_cli = ?" + 
				"WHERE id_funcionario = ?";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConexaoTeste.createConnectionToMySQL();
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			//Adicionar os valores para atualizar.
			pstm.setString(1, cliente.getCpf_cliente());
			pstm.setString(2, cliente.getData_aniversario());
			pstm.setString(3, cliente.getEmpresa());
			pstm.setString(4, cliente.getTelefone_cliente());
			pstm.setString(5, cliente.getEndereco());

			//Qual o ID do registo que deseja atualizar.
			pstm.setInt(6, cliente.getCod_cliente());
			
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
		
		String sql = "DELETE FROM cliente WHERE cod_cliente = ?";
		
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
	

	
	public List<Cliente> getUsuarios() {
		
		String sql = "SELECT * FROM cliente";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. SELECT
		ResultSet rst = null;
		
		try {
			conn = ConexaoTeste.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
	
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				Cliente cliente = new Cliente();
				
				//Recuperar ID
				cliente.setCod_cliente(rst.getInt("cod_cliente"));
				//Recuperar nome
				cliente.setCpf_cliente(rst.getString("cpf_cliente"));
				
				
				clientes.add(cliente);
			
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
		return clientes;
	}

	
	
	
	
	
	
}	

