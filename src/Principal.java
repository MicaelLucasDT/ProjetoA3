import java.util.Scanner;

import DAO.JogoDAO;
import Entity.Jogo;
import Entity.Empresa;
import DAO.EmpresaDAO;
import DAO.PlataformaDAO;
import Entity.Plataforma;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Jogo j = new Jogo();
		Empresa ep = new Empresa();
		JogoDAO jogoDao = new JogoDAO();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		// Plataforma pl = new Plataforma();
		PlataformaDAO plataformaDAO = new PlataformaDAO();

		int n;

		do {

			System.out.println("===========================================================");

			System.out.println("Digite 1 para cadastrar uma nova empresa: ");
			System.out.println("Digite 2 para cadastrar um novo jogo: ");
			System.out.println("Digite 3 para listar os jogos: ");
			System.out.println("Digite 4 para listar as empresas cadastradas: ");
			System.out.println("Digite 5 para listar as plataformas disponíveis: ");
			System.out.println("Digite 6 para atualizar informações de algum jogo: ");
			System.out.println("Digite 7 para atualizar informações de alguma empresa: ");
			System.out.println("Digite 8 para deletar o registro de algum jogo: ");
			System.out.println("Digite 9 para deletar o registro de alguma empresa: ");
			System.out.println("Digite 0 para finalizar o programa: ");
			System.out.println("===========================================================");
			n = sc.nextInt();

			switch (n) {
			case 1: 
				// Cadastrar uma nova empresa
				System.out.print("Cadastro de empresa: ");
				
				Scanner sc0002 = new Scanner(System.in);
				System.out.print("Insira o nome da empresa: ");
				ep.setNome(sc0002.nextLine());
				
				Scanner sc0003 = new Scanner(System.in);
				System.out.print("Insira o CNPJ da empresa: ");
				ep.setCnpj(sc0003.nextLine());

				empresaDAO.salvar(ep);

				break;
			
			case 2: 
				// Cadastrar jogo
				System.out.print("===========================================================");
				System.out.print("Cadastro de um novo jogo: ");
				System.out.print("===========================================================");
				
				Scanner nome = new Scanner(System.in);
				System.out.print("Insira o nome do jogo: ");
				j.setNome(nome.nextLine());
				
				Scanner ano = new Scanner(System.in);
				System.out.print("Insira o ano de lançamento: ");
				j.setAnoLancamento(ano.nextInt());

				Scanner presa = new Scanner(System.in);
				System.out.print("Qual a empresa? ");
				j.setIdEmpresa(presa.nextLong());

				Scanner plat = new Scanner(System.in);
				System.out.print("Qual a plataforma? ");
				j.setIdPlataforma(plat.nextLong());

				jogoDao.salvar(j);

				break;
			
			case 3:

				// visualização dos registros de jogos no banco de dados.
				for (Jogo jogo : jogoDao.getJogos()) {

					System.out.println("Nome: " + jogo.getNome() + "| Data de lançamento: " + jogo.getAnoLancamento()
							+ "| Desenvolvedor: " + jogo.getIdEmpresa() + "| Plataforma: " + jogo.getIdPlataforma());

				}
				break;

			case 4:

				// visualização dos registros de empresas no banco de dados.
				for (Empresa empresa : empresaDAO.getEmpresas()) {

					System.out.println(" - Id: " + empresa.getIdEmpresa() + "| Nome: " + empresa.getNome() + "| CNPJ: "
							+ empresa.getCnpj());
				
				}
				break;

			case 5:

				// visualização dos registros de plataformas.
				for (Plataforma plataforma : plataformaDAO.getPlataformas()) {

					System.out.println("Nome: " + plataforma.getNome() + " - Id: " + plataforma.getIdPlataforma());
				
				}
				break;
			case 6:
			
				// Atualizar informações de jogo
				Jogo j2 = new Jogo();

				Scanner sc0 = new Scanner(System.in);
				System.out.print("Qual o ID do resgistro que deseja alterar? ");
				j2.setIdJogo(Long.parseLong(sc0.nextLine()));

				Scanner sc1 = new Scanner(System.in);
				System.out.print("Para qual nome deseja mudar? ");
				j2.setNome(sc1.nextLine());
				
				Scanner sc3 = new Scanner(System.in);
				System.out.print("Qual a nova data de lançamento? ");
				j2.setAnoLancamento(Integer.parseInt(sc3.nextLine()));

				jogoDao.atualizar(j2);

				break;
			
			case 7:
			
				// Atualizar informações das empresas

				Empresa ep2 = new Empresa();

				Scanner sc00 = new Scanner(System.in);
				System.out.print("Quual o ID do resgistro que deseja alterar? ");
				j.setIdJogo(sc00.nextLong());

				Scanner sc11 = new Scanner(System.in);
				System.out.print("Para qual nome deseja mudar? ");
				j.setNome(sc11.nextLine());
				
				Scanner sc33 = new Scanner(System.in);
				System.out.print("Qual a nova data de lançamento? ");
				j.setAnoLancamento(sc33.nextInt());

				empresaDAO.atualizar(ep2);
				break;
			
			case 8:

				// Deletar o jogo pelo número de ID
				System.out.print("Insira o ID do jogo que você deseja excluir: ");
				jogoDao.apagarByID(sc.nextInt());

			case 9:

				// Deletar alguma empresa

				System.out.print("Insira o ID da empresa que você deseja excluir: ");
				empresaDAO.apagarByID(sc.nextInt());

			default:

				}

		} while (n != 0);

		System.out.println("Programa finalizado!");

		sc.close();

	}
				
			
}