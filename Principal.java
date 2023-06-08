import java.util.Scanner;

import DAO.JogoDAO;
import Entity.Jogo;
import Entity.PlataformaJogo;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Jogo j = new Jogo();
		JogoDAO jogoDao = new JogoDAO();
		PlataformaJogo pj = new PlataformaJogo();
		
		int n;
		
		do {
		
		System.out.println("===========================================================");
		
		System.out.println("Digite 1 para atualizar informação: ");
		System.out.println("Digite 2 para apagar algum jogo: ");
		System.out.println("Digite 3 para listar os jogos: ");
		System.out.println("Digite 4 para cadastrar um jogo: ");
		System.out.println("Digite 0 para finalizar o programa: ");
		System.out.println("===========================================================");
		n = sc.nextInt();
	
		
		
	
		switch (n) {
		case 1:
			
			//Atualizar o usuário
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
			
		case 2: 	
			
			//Deletar o usuário pelo número de ID
			System.out.println("Insira o ID do jogo que você deseja excluir do banco: ");
			jogoDao.apagarByID(sc.nextInt());
			
			break;
			
		case 3:
			
			//visualização dos registros do banco de todos dados.
			for(Jogo user : jogoDao.getJogos()) {
				
				System.out.println("Nome: " + user.getNome_jogo() + "| Data de lançamento: " + user.getAno_lancamento() + "| Desenvolvedor: " + user.getId_empresa());
				
			}
			break;
			
		case 4: 	
			
			//Cadastrar usuário 
			System.out.println("Cadastro: ");
			Scanner sc001 = new Scanner(System.in);
			System.out.println("Insira o nome do jogo: ");
     		j.setNome_jogo(sc001.nextLine());
     		
     		Scanner sc02 = new Scanner(System.in);
     		System.out.println("Insira o ano de lançamento: ");
			j.setAno_lancamento(sc02.nextLine());		
			
			Scanner sc03 = new Scanner(System.in);
     		System.out.println("Qual o desenvolvedor? ");
			j.setId_empresa(sc03.nextLong());
			
			Scanner sc09 = new Scanner(System.in);
			System.out.println("Qual a plataforma? ");
			pj.setId_plataforna(sc09.nextLong());
			
			
			
			jogoDao.salvar(j);
		
		
			default:
				
		}
		
		} while (n != 0);
		
		System.out.println("Programa finalizado!");
		
	
		sc.close();
		
	}

}
