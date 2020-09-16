package Ex02_Atividade_EstruturaDeDados;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		ListaTemperatura lista = new ListaTemperatura();

		int opcao = 0;
		double temperatura = 0;
		int posicao = 0;
		double elemento = 0;
		
		/*
		 * ********************************************Teste de Mesa**************************************************************
		 * 1 - Op��o 1 - Adicionar no in�cio temperatura 32  : Sa�da ["A temperatura 32� foi adicionada no in�cio da lista"]
		 * 2 - Op��o 2 - Adicionar no Final temperatura -10  : Sa�da ["A temperatura -10� foi adicionada no final da lista"]
		 * 3 - Op��o 5 - Adicionar em posi��o espec�fica temperatura 15 posi��o 1  : Sa�da ["A temperatura 15� foi adicionada no in�cio da lista"]
		 * 4 - Op��o 4 - Remove Final da lista : Sa�da ["A temperatura -10� foi removida do final da lista"]
		 * 5 - Op��o 7 - Verificar se lista est� vazia  : Sa�da ["A lista n�o est� vazia"]
		 */
		
		

		while (opcao != 9) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"***Lista de Temperaturas***\n Escolha a op��o desejada \n ---------------------\n "
							+ "1-Adicionar no in�cio\n 2-Adicionar no Final\n 3-Remover no in�cio\n 4-Remover no Final\n "
							+ "5-Adiciona posi��o espec�fica\n 6-Remover posi��o espec�fica\n 7-Verificar se lista est� vazia\n 8-Mostrar lista atual\n 9-Finalizar"));
			switch (opcao) {
			case 1:
				temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira a temperatura desejada:"));
				lista.adicionarInicio(temperatura);
				break;

			case 2:
				temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira a temperatura desejada:"));
				lista.adicionarFinal(temperatura);
				JOptionPane.showMessageDialog(null,
						"A temperatura " + temperatura + "� foi adicionada no final da lista");
				break;
			case 3:
				elemento = lista.removeInicio();

				if (elemento < -283) {
					JOptionPane.showMessageDialog(null,
							"Nenhum valor foi removido, verifique a op��o 7 do menu de op��es.");
				} else {
					JOptionPane.showMessageDialog(null,
							"A temperatura " + elemento + "� foi removida do inicio da lista");
				}

				break;

			case 4:
				elemento = lista.removeFinal();
				if (elemento < -283) {
					JOptionPane.showMessageDialog(null,
							"Nenhum valor foi removido, verifique a op��o 7 do menu de op��es.");
				} else {
					JOptionPane.showMessageDialog(null,
							"A temperatura " + elemento + "� foi removida do final da lista");
				}

				break;

			case 5:
				temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira a temperatura desejada:"));
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posi��o desejada:"));
				lista.escolhePosicao(temperatura, posicao);
				break;

			case 6:
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posi��o desejada:"));
				elemento = lista.removePosicao(posicao);

				if (elemento == -1000) {
					JOptionPane.showMessageDialog(null,
							"A opera��o n�o pode ser realizada, verifique a op��o 7 do menu de op��es.");
				} else if (elemento == -2000)
					JOptionPane.showMessageDialog(null, "Posi��o inv�lida!");
				else {
					JOptionPane.showMessageDialog(null,
							"A temperatura " + elemento + "� foi removida do final da lista");
				}
				break;

			case 7:
				if (lista.listaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista est� vazia.");

				} else {
					JOptionPane.showMessageDialog(null, "A lista n�o est� vazia.");
				}
				break;

			case 8:
				JOptionPane.showMessageDialog(null, "Rela��o de temperaturas da lista \n" + lista);
				break;

			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado, At� logo!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
				break;
			}
		}

	}

}
