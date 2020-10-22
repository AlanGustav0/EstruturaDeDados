package controller;


import javax.swing.JOptionPane;

public class ListaTemperatura {

	// Declara��o de objetos da lista, neste caso criamos um objeto do tipo classe
	private NO inicio;

	// M�todo construtor da Lista Din�mica
	public ListaTemperatura() {
		this.inicio = null;

	}

	public void adicionarInicio(double temperatura) {

		/*
		 * Para podermos inserir um novo elemento, � necess�rio criar um novo N�, tendo
		 * em vista que a lista n�o possui tamanho pr�-definido, por se tratar de uma
		 * aloca��o din�mica de mem�ria. Este novo N� ir� alocar e valor do elemento
		 * atual e "setar o valor do pr�ximo elemento.
		 */
		NO novo = new NO();
		novo.setElemento(temperatura);
		novo.setProximo(inicio);

		// Caso o inicio (primeiro elemento esteja vazio, o novo elemento ser� o
		// primeiro da lista.
		if (inicio == null) {
			inicio = novo;
			JOptionPane.showMessageDialog(null, "A temperatura " + temperatura + "� foi adicionada no in�cio da lista");

		} else {

			/*
			 * Caso contr�rio, criamos um elemento auxiliar para quardar o valor do in�cio
			 * (com isso n�o perdemos refer�ncia) e ent�o percorremos a lista, enquanto o
			 * valor da vari�vel auxiliar seja diferente de nulo. Ao encontrar um elemento
			 * nulo, terminarmos o la�o e ent�o inserimos o novo valor no elemento
			 * encotrado. O elemento nulo ap�s o �ltimo valor da lista.
			 */
			NO auxiliar;
			auxiliar = inicio;

			novo.setElemento(temperatura);
			novo.setProximo(inicio);
			inicio = novo;
			JOptionPane.showMessageDialog(null, "A temperatura " + temperatura + "� foi adicionada no in�cio da lista");

		}

	}

	public void adicionarFinal(double temperatura) {

		// Caso o inicio esteja vazio, inserimos o elemento no incio da lista, que
		// consequentemente � o final.
		if (inicio == null) {
			NO novo = new NO();
			novo.setElemento(temperatura);
			inicio = novo;

		} else {

			// Caso contr�rio, percorremos a lista at� encontrar um valor nulo, para
			// podermos adicionar no final.
			NO auxiliar = inicio;
			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}

			// Criamos um novo espa�o de mem�ria (novo do tipo classe) que ir� aloxar a
			// temperatura.
			NO novo = new NO();
			novo.setElemento(temperatura);
			auxiliar.setProximo(novo);

		}

	}

	public double removeInicio() {

		/*
		 * Aqui criamos uma vari�vel que recebe o inc�cio e outra com um valor de
		 * temperatura inv�lido. Dizemos que � um valor inv�lido pois est� acima do zero
		 * absoluto. Atrav�s deste valor verificamos se a lista est� vazia ou n�o.
		 */
		NO auxiliar = inicio;
		double elemento = -1000;

		// Caso esteja vazia, retornamos o valor de temperatura inv�lido
		if (inicio == null) {
			return elemento;

			// Caso contr�rio, a vari�vel temperatura recebe o valor do elemento a ser
			// removido e o in�cio recebe o pr�ximo valor.
		} else {
			elemento = inicio.getElemento();
			inicio = inicio.getProximo();

		}

		return elemento;
	}

	public double removeFinal() {

		// Aqui criamos uma vari�vel que servir� para verificar se a lisra est� ou n�o
		// vazia
		double elemento = -1000;
		if (inicio == null) {
			return elemento;
		} else {

			/*
			 * Caso contr�rio, verificamos se a lista possui apenas 1 elemento, caso
			 * positivo, este elemento ser� removido, pois trata-se do final da lista.
			 */
			if (inicio.getProximo() == null) {
				elemento = inicio.getElemento();
				inicio = null;
				return elemento;

			} else {

				/*
				 * N�o sendo o primeiro elemento, ent�o criamos 2 vari�veis auxiliares, ambas
				 * recebendo in�cio. A primeira guarda o valor de in�cio e a outra recebe o
				 * valor do proximo valor.
				 */
				NO auxiliar = inicio;
				NO auxiliar2 = inicio;

				while (auxiliar.getProximo() != null) {
					auxiliar2 = auxiliar;
					auxiliar = auxiliar.getProximo();
				}

				// quando chegamos no final da lista, a vari�vel elemento recebe o �ltimo valor
				// encontrado e este espa�o de mem�ria passa a ser nulo.
				elemento = auxiliar.getElemento();
				auxiliar2.setProximo(null);
			}

		}

		return elemento;

	}

	public void escolhePosicao(double temperatura, int posicao) {

		// Primeiro criamos nosso N� para inserir a temperatura recebido por par�metro
		NO novo = new NO();
		novo.setElemento(temperatura);

		// Caso a lista esteja vazia
		if (inicio == null) {
			JOptionPane.showMessageDialog(null,
					"A opera��o n�o pode ser realizada, verifique a op��o 7 do menu de op��es.");
		} else {

			// caso contr�rio verificamos a primeira posi��o, ent�o fazemos a chamada do
			// m�todo de retirar no inicio
			if (posicao == 1) {
				adicionarInicio(temperatura);
			} else {

				// Caso contr�rio, crismo um contador para podermos mensurar o "tamanho" dessa
				// lista.
				NO auxiliar = inicio;
				int contador = 1;

				// ent�o percorremos ela e incrementamos nosso contador
				while (auxiliar != null && contador < posicao - 1) {
					auxiliar = auxiliar.getProximo();
					contador++;
				}

				/*
				 * Se o contador for igual ao valor da posi��o - 1, quer dizer que chegamos at�
				 * um n�mero antes da posi��o escolhida Ent�o o pr�ximo n�mero ser� o nosso novo
				 * valor. E o pr�ximo valor ap�s a posi��o que escolhemos, ser� a antiga posi��o
				 * onde agora est� o valor novo.
				 */

				if (contador == posicao - 1) {
					novo.setProximo(auxiliar.getProximo());
					auxiliar.setProximo(novo);
					JOptionPane.showMessageDialog(null,
							"A temperatura " + temperatura + "� foi adicionada na posi��o " + posicao + " da lista");
				} else {

					/*
					 * Caso a posi��o n�o seja encontrada, imprimimos a mensagem de posi��o
					 * inv�lida. Esta posi��o ser� considerada inv�lida quando ela for maior que o
					 * tamanho da posi��o ou n�o estiver dentro do intervalo (tamanho) que a lista
					 * possui.
					 * 
					 */
					JOptionPane.showMessageDialog(null, "Posi��o inv�lida!");
				}
			}
		}
	}

	public double removePosicao(int posicao) {

		// criamos o espa�o de mem�ria auxiliar para guardar a refer�ncia de inicio
		NO auxiliar = inicio;
		// Vari�vel maior que zero absoluto para retornar um valor "nulo" ou inv�lido.
		double elemento = -1000;
		// Contador para mensurar o tamanho da lista
		int contador = 1;

		// Se o in�cio for nulo, a vari�vel nula � retornada
		if (inicio == null) {

			return elemento;
		} else {
			// Se a posi��o escolhida for igual a 1, fazemos a chamada do m�todo de retirar
			// no inicio.
			if (posicao == 1) {
				elemento = removeInicio();
			} else {

				// Caso contr�rio, percorremos a lista e incrementamos o contador
				while (auxiliar.getProximo() != null) {
					auxiliar = auxiliar.getProximo();
					contador++;
				}

				// Validamos este contador, se a posi��o for maior que o contador, ou a posi��o
				// for menor ou igual a 0 retornamos o elemento "nulo". (-2000)
				if (posicao > contador || posicao < 0 || posicao == 0) {
					elemento = -2000;
					return elemento;

					// Caso a posi��o for igual ao contador, estamos no final da lista, ent�o
					// fazemos a chamada do m�todo de retirar no final.
				} else if (posicao == contador) {
					return removeFinal();

				} else {

					/*
					 * Caso contr�rio, Criamos outro espa�o de memoria para auxiliar na verifica��o
					 * da lista enquanto nosso contador dor menor que a posi��o, puxamos os valores
					 * at� chegar a uma posi��o antes da posi��o escolhida
					 */
					NO auxiliarInicio = auxiliar;

					while (contador < posicao) {
						auxiliarInicio = auxiliar;
						auxiliar = auxiliar.getProximo();
						contador++;
					}

					/*
					 * Quando finalizamos o la�o, nosso elemento recebe o valor da posi��o atual,
					 * que ser� a posi��o que foi escolhida para ser retirada E nossa vari�vel
					 * auxiliarInicio recebe o pr�ximo valor da vari�vel auxiliar, ou seja, um valor
					 * nulo, assim n�s anularmos a posi��o escolhida.
					 */
					elemento = auxiliar.getElemento();
					auxiliarInicio.setProximo(auxiliar.getProximo());

				}
			}
		}

		return elemento;

	}

	// M�todo para verificar se a lista est� vazia
	public boolean listaVazia() {
		return (this.inicio == null);
	}

	public String toString() {

		/*
		 * Aqui criamos uma vari�vel para armazanar a refer�ncia de inc�o e uma vari�vel
		 * do tipo String para armazanar as informa��es da lista.
		 */

		String mostraLista = "";
		NO auxiliar = inicio;

		// Percorremos a lista e vamos concatenando os valores enquanto ela n�o encontra
		// um valor nulo.

		if (inicio == null) {
			mostraLista = "A lista ainda n�o possui nenhum elemento.";
		} else {

			while (auxiliar != null) {

				mostraLista += auxiliar.getElemento() + "\n";
				auxiliar = auxiliar.getProximo();

			}

		}

		// retornamos a vari�vel com os valores concatenados
		return mostraLista;

	}

}
