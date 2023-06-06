import java.util.Scanner;

import DAO.ClienteDAO;
import Entity.Cliente;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Cliente u = new Cliente();
		ClienteDAO usuarioDao = new ClienteDAO();
		
		int n;
		
		do {
		
		System.out.println("===========================================================");
		
		System.out.println("Digite 1 para atualizar informação: ");
		System.out.println("Digite 2 para apagar algum registro: ");
		System.out.println("Digite 3 para listar registros: ");
		System.out.println("Digite 4 para cadastrar um usuário: ");
		System.out.println("Digite 0 para finalizar o programa: ");
		System.out.println("===========================================================");
		n = sc.nextInt();
	
		
		
	
		switch (n) {
		case 1:
			
			//Atualizar o usuário
			Cliente u2 = new Cliente();
			
			Scanner sc0 = new Scanner(System.in);
			System.out.println("Quual o ID do resgistro que deseja alterar? ");
			u2.setCod_cliente(sc0.nextInt());
			
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Para qual CPF deseja mudar? ");
			u2.setCpf_cliente(sc1.next());
			
			Scanner sc3 = new Scanner(System.in);
			System.out.println("Qual o novo telefone? ");
			u2.setTelefone_cliente(sc3.next());
			
			
			usuarioDao.atualizar(u2); 
			
			break;
			
		case 2: 	
			
			//Deletar o usuário pelo número de ID
			System.out.println("Insira o ID do registro que você deseja excluir: ");
			usuarioDao.apagarByID(sc.nextInt());
			
			break;
			
		case 3:
			
			//visualização dos registros do banco de todos dados.
			for(Cliente user : usuarioDao.getUsuarios()) {
				
				System.out.println("CPF: " + user.getCpf_cliente() + "| Telefone: " + user.getTelefone_cliente());
				
			}
			break;
			
		case 4: 	
			
			//Cadastrar usuário
			System.out.println("Cadastro: ");
			Scanner sc001 = new Scanner(System.in);
			System.out.println("Insira seu CPF: ");
     		u.setCpf_cliente(sc001.next());
     		
     		Scanner sc02 = new Scanner(System.in);
     		System.out.println("Insira seu número de telefone: ");
			u.setTelefone_cliente(sc02.next());		
			
			Scanner sc03 = new Scanner(System.in);
     		System.out.println("Data de aniversário: ");
			u.setData_aniversario(sc03.next());
			
			
			usuarioDao.salvar(u);
			
		case 5:
			
			//Cadastrar usuário
			System.out.println("Cadastro endereço: ");
			Scanner sc0001 = new Scanner(System.in);
			System.out.println("Insira seu CPF: ");
     		u.setCpf_cliente(sc0001.next());
			
			
			
			
			default:
				
		}
		
		} while (n != 0);
		
		System.out.println("Programa finalizado!");
		
	
		sc.close();
		
	}

}
