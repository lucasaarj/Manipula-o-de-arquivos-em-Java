import java.util.Scanner; //Escanear o que foi digitado no teclado.
import java. io.BufferedReader; //Lê o texto de um fluxo de simbolos e armazena em buffer para ler caracteres arrays e Strings com eficiência
import java.io.BufferedWriter; //utilizado para gravar texto em um fluxo de caracteres de saída.
import java.io.File; // Declara que será utilizado apenas a classe File.
import java.io.FileWriter; //Escreve diretamente no arquivo.
import java.io.FileReader; //Permite a leitura por meio de aplicativos web o conteúdo de todo arquivo.
import java.io.IOException; //classe base para exceções geradas ao acessar as informações usando fluxo, arquivos e diretórios.


public class Aplicacao {
	private static final String FILE_NAME = "nomes.txt";

	static void Manipulacao_arquivo_txt() {
		
		exibirMenu();
			
	}
	
	public static void exibirMenu() {
		Scanner entrada = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("\n\n=== MENU ===");
			System.out.println("");
			System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO");
			System.out.println("");
			System.out.println("1 ---> INSERIR NOME NO ARQUIVO");
			System.out.println("");
			System.out.println("2 ---> EXIBIR TODOS OS NOMES DO ARQUIVO");
			System.out.println("");
			System.out.println("3 ---> APAGAR TODO O ARQUIVO");
			System.out.println("");
			System.out.println("4 ---> SAIR\n\n");
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcao) {
			case 1:
				inserirNome();
				break;
			
			case 2:
				exibirNomes();
				break;
			
			case 3:
				apagarArquivo();
				break;
				
			case 4:
				System.out.println("ENCERRANDO A APLICAÇÃO...\n\n");
				break;
			   default:
				   System.out.println("OPÇÃO INVÁLIDA. POR FAVOR, ESCOLHA NOVAMENTE.\n\n");
				   break;
			}
		}while (opcao != 4);
	
		entrada.close();
	}
	
	private static void inserirNome() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("DIGITE PARA SER CADASTRADO: ");
			String nome = entrada.nextLine();
			
			writer.write(nome); //escreve o conteúdo na variável nome;
			writer.newLine(); //usado para inserir uma nova linha no arquivo após o conteúdo que foi escrito anteriormente.
			
			writer.close();
			System.out.println("NOME CADASTRADO COM SUCESSO!\n\n");
		} catch (IOException e) { //utilizado para lidar com exceções no método try.
			System.out.println("ERRO AO CADASTRAR NOME NO ARQUIVO " + e.getMessage() + ".");
		}
	}
	
	private static void exibirNomes() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
			String linha;
			
			System.out.println("NOMES CADASTRADOS NO ARQUIVO: ");
			
			while ((linha = reader.readLine()) != null) {
				System.out.println(linha);
			}
			
			reader.close();
		} catch (IOException e) {
			System.out.println("ERRO AO EXIBIR NOMES CADASTRADOS NO ARQUIVO: " + e.getMessage() + ".\n\n");
		}
	}
	
	private static void apagarArquivo() {
		File arquivo = new File(FILE_NAME);
		if (arquivo.exists()) {
			arquivo.delete();
			System.out.println("ARQUIVO APAGADO COM SUCESSO!\n\n");
		} else {
			System.out.println("O ARQUIVO NÃO FOI ENCONTRADO.\n\n");
		}
	}
}
