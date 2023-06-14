import java.util.Scanner;

import DAO.JogoDAO;
import Entity.Jogo;
import Entity.PlataformaJogo;
import Entity.Empresa;
import DAO.EmpresaDAO;

public class Principal {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Jogo j = new Jogo();
		Empresa ep = new Empresa();
		JogoDAO jogoDao = new JogoDAO();
		EmpresaDAO empresaDAO = new EmpresaDAO();
	//	PlataformaJogo pj = new PlataformaJogo();
		
		int n;
		
		
		
		do {
		
		System.out.println("===========================================================");
		
		System.out.println("Digite 1 para cadastrar uma nova empresa: ");
		System.out.println("Digite 2 para cadastrar um novo jogo: ");
		System.out.println("Digite 3 para listar os jogos: ");
		System.out.println("Digite 4 para listar as empresas cadastradas: ");
		System.out.println("Digite 5 para atualizar informações de algum jogo: ");
		System.out.println("Digite 6 para atualizar informações de alguma empresa: ");
		System.out.println("Digite 7 para deletar o registro de algum jogo: ");
		System.out.println("Digite 8 para deletar o registro de alguma empresa: ");
		System.out.println("Digite 0 para finalizar o programa: ");
		System.out.println("===========================================================");
		n = sc.nextInt();
	
		
		
		switch (n) {
		case 1:
			
			//Cadastrar uma nova empresa
			
			System.out.println("Cadastro de empresa: ");
			Scanner sc0001 = new Scanner(System.in);
			System.out.println("Insira o nome da empresa: ");
			ep.setNome_empresa(sc0001.nextLine());
			
			empresaDAO.salvar(ep);
			
			break;
			
		case 2: 	
		
			//Cadastrar jogo 
			System.out.println("Cadastro de um novo jogo: ");
			Scanner sc001 = new Scanner(System.in);
			System.out.println("Insira o nome do jogo: ");
     		j.setNome_jogo(sc001.nextLine());
     		
     		Scanner sc02 = new Scanner(System.in);
     		System.out.println("Insira o ano de lançamento: ");
			j.setAno_lancamento(sc02.nextLine());		
			
			Scanner sc03 = new Scanner(System.in);
     		System.out.println("Qual o desenvolvedor? ");
			j.setId_empresa(sc03.nextLong());
			
			
			
			
			
			
			//Scanner sc09 = new Scanner(System.in);
			//System.out.println("Qual a plataforma? ");
			//pj.setId_plataforna(sc09.nextLong());
			
			jogoDao.salvar(j);
			
			break;
			
		case 3:
			
			//visualização dos registros de jogos no banco de dados.
			for(Jogo user : jogoDao.getJogos()) {
				
				System.out.println("Nome: " + user.getNome_jogo() + "| Data de lançamento: " + user.getAno_lancamento() + "| Desenvolvedor: " + user.getId_empresa());
				
			}
			break;
			
		case 4: 
			
			//visualização dos registros de empresas no banco de dados.
			for(Empresa user : empresaDAO.getEmpresas()) {
				
				System.out.println("Nome: " + user.getNome_empresa() + " - Id: " + user.getId_empresa());
			}
			
			break;
			
		case 5: 	
			
			//Atualizar informações de jogo
			Jogo j2 = new Jogo();
			
			Scanner sc0 = new Scanner(System.in);
			System.out.println("Quual o ID do resgistro que deseja alterar? ");
			j.setId_jogo(sc0.nextLong());
			
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Para qual nome deseja mudar? ");
			j.setNome_jogo(sc1.nextLine());
			
			Scanner sc3 = new Scanner(System.in);
			System.out.println("Qual a nova data de lançamento? ");
			j.setAno_lancamento(sc3.nextLine());
			
			
			jogoDao.atualizar(j2); 
			
			break;
			
		case 6:
			
			//Atualizar informações das empresas
			
			Empresa ep2 = new Empresa();
			
			Scanner sc00 = new Scanner(System.in);
			System.out.println("Quual o ID do resgistro que deseja alterar? ");
			j.setId_jogo(sc00.nextLong());
			
			Scanner sc11 = new Scanner(System.in);
			System.out.println("Para qual nome deseja mudar? ");
			j.setNome_jogo(sc11.nextLine());
			
			Scanner sc33 = new Scanner(System.in);
			System.out.println("Qual a nova data de lançamento? ");
			j.setAno_lancamento(sc33.nextLine());
		
			empresaDAO.atualizar(ep2); 
			
			break;
			
		case 7: 	
			
			//Deletar o jogo pelo número de ID
			System.out.println("Insira o ID do jogo que você deseja excluir: ");
			jogoDao.apagarByID(sc.nextInt());
			
		case 8: 
			
			//Deletar alguma empresa
			
			System.out.println("Insira o ID da empresa que você deseja excluir: ");
			empresaDAO.apagarByID(sc.nextInt());
		
		default:
	
		}
		
		} while (n != 0);
		
		System.out.println("Programa finalizado!");
		
	
		sc.close();
		
	}

}
