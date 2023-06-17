import java.util.Scanner;

import DAO.JogoDAO;
import Entity.Jogo;
import DAO.PlataformaDAO;
import Entity.Empresa;
import DAO.EmpresaDAO;
import Entity.Plataforma;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Jogo j = new Jogo();
		Empresa ep = new Empresa();
		JogoDAO jogoDao = new JogoDAO();
		EmpresaDAO empresaDAO = new EmpresaDAO();
	//	Plataforma plataforma = new Plataforma();
		PlataformaDAO plataformaDAO = new PlataformaDAO();

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
			System.out.println("Digite 8 para listar as plataformas cadastradas: ");
			System.out.println("Digite 0 para finalizar o programa: ");
			System.out.println("===========================================================");
			n = sc.nextInt();

			switch (n) {
			case 1:

				// Cadastrar uma nova empresa
				System.out.println("===========================================================");
				System.out.println("Cadastro de empresa: ");
				System.out.println("===========================================================");
				Scanner sc0001 = new Scanner(System.in);
				System.out.print("Insira o nome da empresa: ");
				ep.setNomeempresa(sc0001.nextLine());

			//	Scanner sc000 = new Scanner(System.in);
			//	System.out.println("Insira o CNPJ da empresa: ");
			//	ep.setNomeempresa(sc000.nextLine());
				
				
				empresaDAO.salvar(ep);

				break;

			case 2:

				// Cadastrar jogo
				System.out.println("===========================================================");
				System.out.println("Cadastro de um novo jogo: ");
				System.out.println("===========================================================");
				Scanner sc001 = new Scanner(System.in);
				System.out.print("Insira o nome do jogo: ");
				j.setNomejogo(sc001.nextLine());

				Scanner sc02 = new Scanner(System.in);
				System.out.print("Insira o ano de lançamento: ");
				j.setAnolancamento(sc02.nextLine());

				Scanner sc03 = new Scanner(System.in);
				System.out.print("Qual o desenvolvedor? ");
				j.setIdempresa(sc03.nextLong());

				Scanner sc09 = new Scanner(System.in);
				System.out.print("Qual a plataforma? ");
				j.setIdlataforma(sc09.nextLong());

				jogoDao.salvar(j);

				break;

			case 3:

				// visualização dos registros de jogos no banco de dados.
				for (Jogo jogo : jogoDao.getJogos()) {

					System.out.println(" - Id: " + jogo.getIdjogo() + " Nome: " + jogo.getNomejogo() + "| Data de lançamento: "
							+ jogo.getAnolancamento() + "| Desenvolvedor: " + jogo.getIdempresa() + "| Plataforma: " + jogo.getIdlataforma());

				}
				break;

			case 4:

				// visualização dos registros de empresas no banco de dados.
				for (Empresa empresa : empresaDAO.getEmpresas()) {

					System.out.println(" - Id: " + empresa.getIdempresa() + "| Nome: " + empresa.getNomeempresa() );

				}

				break;

			case 5:

				// Atualizar informações de jogo
				Jogo j2 = new Jogo();

				Scanner sc0 = new Scanner(System.in);
				System.out.print("Quual o ID do resgistro que deseja alterar? ");
				j.setIdjogo(sc0.nextLong());

				Scanner sc1 = new Scanner(System.in);
				System.out.print("Para qual nome deseja mudar? ");
				j.setNomejogo(sc1.nextLine());

				Scanner sc3 = new Scanner(System.in);
				System.out.print("Qual a nova data de lançamento? ");
				j.setAnolancamento(sc3.nextLine());

				jogoDao.atualizar(j2);

				break;

			case 6:

				// Atualizar informações das empresas

				Empresa ep2 = new Empresa();

				Scanner sc00 = new Scanner(System.in);
				System.out.print("Qual o ID do resgistro que deseja alterar? ");
				j.setIdjogo(sc00.nextLong());

				Scanner sc11 = new Scanner(System.in);
				System.out.print("Para qual nome deseja mudar? ");
				j.setNomejogo(sc11.nextLine());
				
				empresaDAO.atualizar(ep2);

				break;

			case 7:

				// Deletar o jogo pelo número de ID
				System.out.println("Insira o ID do jogo que você deseja excluir: ");
				jogoDao.apagarByID(sc.nextInt());
				
				break;
			case 8: 
				
				// visualização dos registros de plataformas no banco de dados.
				for (Plataforma pla : plataformaDAO.getPlataformas()) {

					System.out.println(" - Id: " + pla.getIdplataforma() + " Nome: " + pla.getNomeplataforma() );

				}

				break;
				
				
				
			default:

			}

		} while (n != 0);

		System.out.println("Programa finalizado!");

		sc.close();

	}

}
