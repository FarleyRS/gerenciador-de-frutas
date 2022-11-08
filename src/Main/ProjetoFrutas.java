package Main;
/*
 * @By: Farley Ramos de Sena
 * Instituto Federal Goiano - Campus Urutaí
 * 2° periodo 
 * Linguagem de Programação II
 * Prof: Monica Sakuray
 *
 */
import javax.swing.JOptionPane;

public class ProjetoFrutas {
	//Variaveis globais
	static Fruta[] vet = new Fruta[10];
	public static int cont = 0;
	
	
	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao = 1;
		while (opcao != 0) {
			opcao = menu();
			switch (opcao) {
			case 1:
				adicionarFruta();
				break;
			case 2:
				excluirFruta();
				break;
			case 3:
				listarFrutas();
				break;
			case 4:
				pesoFrutas();
				break;
			case 5:
				caloriaMedia();
				break;
			case 6:
				dadosFruta();
				break;
			case 7:
				frutaMenorCaloria();
				break;
			case 8:
				frutaMaior();
				break;
			case 0:
				return;
				
			}
		}

	}
	
	//Menu
	static int menu() {
		String resp = JOptionPane.showInputDialog(
				"Menu:\n" + "1: Inserir fruta\n" 
						  + "2: Excluir fruta\n" 
						  + "3: Listar frutas\n" 
						  + "4: Calcular pesos das frutas\n"
						  + "5: Calcular média de calorias das frutas\n"
						  + "6: Mostrar os dados de uma fruta\n"
						  + "7: Mostrar a fruta com menor calorias\n"
						  + "8: Mostrar a fruta com maior peso médio\n"
						  + "0: Encerrar\n");
		return Integer.parseInt(resp);
	}
	
	//Adicionar frutas no vetor
	static void adicionarFruta() {
		String nome,resp;
		double pesoMedio, calorias;
		nome = JOptionPane.showInputDialog("Insira o nome da frura: ");
		resp = JOptionPane.showInputDialog("Insira o peso medio da fruta: ");
		pesoMedio = Double.parseDouble(resp);
		resp = JOptionPane.showInputDialog("Insira a coloria da fruta: ");
		calorias = Double.parseDouble(resp);
		
		vet[cont] = new Fruta(nome,pesoMedio,calorias);
		cont++;
		
	}
	
	//Excluir frutas do vetor
	static void excluirFruta() {
		String resp;
		resp = JOptionPane.showInputDialog("Insira o nome da fruta a ser excluida: ");
		for(int i=0;i<cont;i++) {
			if((vet[i]!=null) && (resp.equals( vet[i].nome))) {
				vet[i]=null;
				JOptionPane.showMessageDialog(null,"Excluido");	
				break;
			}
		}
	}
	
	//Listar frutas do vetor
	static void listarFrutas() {
		
		for (int i = 0; i < cont; i++) {
			if(vet[i]!=null) {
				System.out.println(vet[i].nome);
			}
		}	
		
	}
	
	//Calcular a soma dos pesos das frutas cadastradas
	static void pesoFrutas() {
		Double resp = 0.0;
		for(int i=0;i<cont;i++) {
			resp += vet[i].pesoMedio;
		}
		System.out.println("Soma dos pesos das frutas cadastradas: "+resp);
	}
	
	//Calcular o número médio de calorias das frutas cadastradas
	static void caloriaMedia() {
		Double resp = 0.0;
		for(int i=0;i<cont;i++) {
			resp += vet[i].calorias;
		}
		//Dividir pela quantidade de frutas cadastradas
		double res = resp/vet.length;
		JOptionPane.showMessageDialog(null,"Número médio de calorias das frutas cadastradas: "+(res));
	}
	
	//Mostrar os dados de uma fruta escolhida pelo usuário
	static void dadosFruta() {
		String resp;
		resp = JOptionPane.showInputDialog("Insira o nome da fruta: ");
		for(int i=0;i<cont;i++) {
			if((vet[i]!=null) && (resp.equals( vet[i].nome))) {
				JOptionPane.showMessageDialog(null,vet[i].nome+" ,"+vet[i].pesoMedio+", "+vet[i].calorias);	
				break;
			}
		}
		
	}
	
	//Mostrar a fruta com menor número de calorias
	static void frutaMenorCaloria() {
		String resp = " ";
		double val =0;
		for(int i=0;i<cont;i++) {
			if(vet[i]!=null && vet[i].calorias<val) {
				val=vet[i].calorias;
				resp = vet[i].nome;
			}
			else {
				val=vet[i].calorias;
				
			}	
		}
		JOptionPane.showMessageDialog(null, "A frura com menor caloria: "+resp);
	}
	
	//Mostrar a fruta com maior peso médio
	static void frutaMaior() {
		String resp = " ";
		double val =0;
		for(int i=0;i<cont;i++) {
			if(vet[i]!=null && val<vet[i].pesoMedio) {
				val=vet[i].pesoMedio;
				resp = vet[i].nome;
			}
		}
		JOptionPane.showMessageDialog(null, "A frura com maior peso: "+resp);
	}

}
