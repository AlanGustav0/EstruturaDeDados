package Ex03_Atividade_EstruturaDeDados;

import javax.swing.JOptionPane;

public class ListaAlunos {

	private Aluno inicio;

	public ListaAlunos() {
		this.inicio = null;
	}

	public void adicionaInicio(int ra, String nome, String turma, String semestre) {
		/*
		 * Para podermos inserir um novo aluno, � necess�rio criar um novo elemento com
		 * as caracter�sticas do aluno, tendo em vista que a lista n�o possui tamanho
		 * pr�-definido, por se tratar de uma aloca��o din�mica de mem�ria. Este novo
		 * elemento ir� alocar os dados do aluno.
		 * 
		 */
		Aluno novo = new Aluno(ra, nome, turma, semestre);

		// Caso o inicio (primeiro elemento esteja vazio, o novo elemento ser� o
		// primeiro da lista.
		if (inicio == null) {
			inicio = novo;
			JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi adicionado no in�cio da lista");

		} else {

			/*
			 * Caso contr�rio, criamos um elemento auxiliar para quardar o valor do in�cio
			 * (com isso n�o perdemos refer�ncia) e ent�o percorremos a lista, enquanto o
			 * valor da vari�vel auxiliar seja diferente de nulo. Ao encontrar um elemento
			 * nulo, terminarmos o la�o e ent�o inserimos o novo aluno no elemento
			 * encotrado. O elemento nulo ap�s o �ltimo valor da lista.
			 */
			Aluno auxiliar;
			auxiliar = inicio;

			novo.setProximo(inicio);
			inicio = novo;
			JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi adicionada no in�cio da lista");

		}
	}

	public void adicionaFinal(int ra, String nome, String turma, String semestre) {

		// Caso a lista esteja vazia, adicionamos o valor no incio, que ser� tamb�m o
		// final
		if (inicio == null) {
			Aluno novo = new Aluno(ra, nome, turma, semestre);
			inicio = novo;
		} else {

			// Caso contr�rio, criamos um elemento auxiliar para guardar a referencia
			Aluno auxiliar = inicio;

			// Percorremos a lista at� chegar ao final dela, onde o pr�ximo elemento ap�s o
			// �ltimo ser� nulo
			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}

			// Ent�o criamos um "novo aluno" para armazenar as informa��es passadas por
			// par�metro.
			Aluno novo = new Aluno(ra, nome, turma, semestre);

			// E inserimos este novo valor ao elemento ap�s o �ltimo valor da vari�vel
			// auxiliar (que estava nulo).
			auxiliar.setProximo(novo);
		}

	}

	public String removeInicio() {

		String aluno = null;

		// Verificamos se a lista est� vazia, caso esteja retornamos um valor nulo.
		if (inicio == null) {
			return aluno;
		} else {

			// Caso contr�rio, o in�cio recebe o pr�ximo valor ap�s ele, e retornamos o
			// valor que estava no inicio.
			Aluno auxiliar = inicio;
			aluno = auxiliar.getNome();
			inicio = inicio.getProximo();
		}

		return aluno;
	}

	public String removeFinal() {

		String aluno = null;

		// Verificando se o inicio � ou n�o nulo
		if (inicio == null) {
			return aluno;
		} else {

			// Verificando se o valor ap�s ao inicio � nulo, caso seja, a lista possui
			// apenas 1 elemento
			if (inicio.getProximo() == null) {
				aluno = inicio.getNome();
				inicio = null;
			} else {

				/*
				 * Caso contr�rio, criamos 2 vari�veis auxiliares para percorre a lista at� o
				 * final dela, auxiliarBackup armazena o valor antes do final e a auxiliar
				 * receber� os dados do final. Quando terminamos de percorrer a lista a vari�vel
				 * aluno receber� o nome do �ltimo aluno e a auxiliarBackup receber� o seu
				 * pr�ximo valor nulo.
				 */
				Aluno auxiliar = inicio;
				Aluno auxiliarBackup = inicio;

				while (auxiliar.getProximo() != null) {
					auxiliarBackup = auxiliar;
					auxiliar = auxiliar.getProximo();
				}

				aluno = auxiliar.getNome();
				auxiliarBackup.setProximo(null);
			}

		}

		return aluno;
	}

	public String removeMeio() {

		//Aqui declaramos as vari�veis que iremos utilizar
		Aluno auxiliar = inicio;
		String aluno = null;
		int tamanho = 1;
		int inicia = 0;
		int meio = 0;

		//Verificamos se a lista est� vazia
		if (inicio == null) {
			return aluno;
		} else {

			//Verificamos se o pr�ximo elemento ap�s o in�cio est� vazio
			if (inicio.getProximo() == null) {
				aluno = inicio.getNome();
				inicio = null;

			} else {

				/*Caso contr�rio, criamos 2 vari�veis auziliares
				 * 
				 * auxiliarBackup - usamos para percorrer a lista e fazer o incremento da vari�vel contador, com isso temos o tamanho da lista
				 * 
				 * auxiliarAluno - usaremos para percorre a lista desde o in�cio at� a metade
				 */
				Aluno auxiliarBackup = inicio;
				Aluno auxiliarAluno = inicio;

				//Percorrendo a lista inteira
				while (auxiliarBackup != null) {
					auxiliarBackup = auxiliarBackup.getProximo();
					tamanho++;
				}

				//Para encontrar o meio da lista, recebemos na vari�vel meio o valor do tamanho da lista divido por 2
				meio = tamanho / 2;

				/*A veri�vel "inicia" foi criada para marcar o incio da lista, iremos percorrer a lista at� chegar no valor do meio - 1
				 * Afinal, quando chegarmos neste valor, iremos remover o valor ap�s ele, ou seja, o valor do meio.
				 * 
				 * A vari�vel auciliarAluno est� sendo utilizada para guardar um valor do meio.
				 */
				while (inicia < meio - 1) {
					auxiliarAluno = auxiliar;
					auxiliar = auxiliar.getProximo();
					inicia++;
				}

				/*Caso ambos valores sejam iguais, aluno receber� o nome do pr�ximo aluno (aluno do meio) e a vari�vel auxiliarAluno receber�
				 * o valor ap�s ela, excluindo assim o valor do meio que anteriormente havia sido armazenado nela.
				 */
				
				if (inicia == meio - 1) {
					aluno = auxiliar.getNome();
					auxiliarAluno.setProximo(auxiliar.getProximo());
				} else {
					aluno = " ";
				}

			}

		}

		return aluno;
	}

	//M�todo que verifica se a lista est� vazia
	public boolean listaVazia() {
		return (inicio == null);
	}

	public String toString() {

		/*
		 * Aqui criamos uma vari�vel para armazanar a refer�ncia de inc�o e uma vari�vel
		 * do tipo String para armazanar as informa��es da lista.
		 */

		String mostraLista = "";
		Aluno auxiliar = inicio;

		// Percorremos a lista e vamos concatenando os valores enquanto ela n�o encontra
		// um valor nulo.

		if (inicio == null) {
			mostraLista = "A lista ainda n�o possui nenhum aluno.";
		} else {

			while (auxiliar != null) {

				mostraLista += "RA: " + auxiliar.getRa() + "\n";
				mostraLista += "Nome: " + auxiliar.getNome() + "\n";
				mostraLista += "Turma: " + auxiliar.getTurma() + "\n";
				mostraLista += "Semestre: " + auxiliar.getSemestre() + "\n";
				mostraLista += "---------------------" + "\n";
				auxiliar = auxiliar.getProximo();

			}

		}

		// retornamos a vari�vel com os valores concatenados
		return mostraLista;

	}

}
