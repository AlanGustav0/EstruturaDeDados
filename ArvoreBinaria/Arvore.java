package ArvoreBinaria;

public class Arvore {

	private Elemento elemento;
	private Arvore direita;
	private Arvore esquerda;

	// Aqui n�o precisariamos declarar null, uma vez que o construtor padr�o j�
	// realiza esta fun��o
	// � apenas para ficar mais did�tico
	public Arvore() {
		this.elemento = null;
		this.direita = null;
		this.esquerda = null;
	}

	// Sobrecarga criando outro construtor
	public Arvore(Elemento elemento) {
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		System.out.println("Criei uma �rvore com elemento " + this.elemento.getValor());
	}

	// M�todos de controle
	public boolean isEmpty() {
		return this.elemento == null;
	}

	public void inserir(Elemento novo) {

		if (isEmpty()) {
			this.elemento = novo;
		} else {
			Arvore novaArvore = new Arvore(novo);
			if (novo.getValor() < this.elemento.getValor()) {// vou inserir na descendencia esquerda
				if (this.esquerda == null) {// sou um n� folha?
					this.esquerda = novaArvore;
					System.out.println(
							"Inseri o elemento " + novo.getValor() + " � esquerda de " + this.elemento.getValor());
				} else {
					this.esquerda.inserir(novo); // repassei a responsabilidade para a sub-�rvore esquerda

				}
			} else if (novo.getValor() > this.elemento.getValor()) {// Na descendencia direita
				if (this.direita == null) {// sou um n� folha?
					this.direita = novaArvore;
					System.out.println(
							"Inseri o elemento " + novo.getValor() + " � direita de " + this.elemento.getValor());
				} else {
					this.direita.inserir(novo);

				}

			}
		}
	}

	public boolean busca(int valor) {
		if (isEmpty()) {
			return false;
		}

		if (this.elemento.getValor() == valor) {
			return true;
		} else {
			if (valor < this.elemento.getValor()) {
				if (this.esquerda == null) {
					return false;
				} else {
					return this.esquerda.busca(valor);// repassei a responsabilidade para a subarvore esquerda
				}
			} else if (valor > this.elemento.getValor()) {
				if (this.direita == null) {
					return false;
				} else {
					return this.direita.busca(valor);
				}
			}
			return false;
		}
	}

	public void imprimePreOrdem() {

		if (!isEmpty()) {
			System.out.print(this.elemento.getValor() + " ");

			if (this.esquerda != null) {
				this.esquerda.imprimePreOrdem();
			}
			if (this.direita != null) {
				this.direita.imprimePreOrdem();
			}
		}
	}

	public void imprimeInOrdem() {
		if (!isEmpty()) {
			if (this.esquerda != null) {
				this.esquerda.imprimeInOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");

			if (this.direita != null) {
				this.direita.imprimeInOrdem();
			}

		}
	}

	public void imprimePosOrdem() {
		if (!isEmpty()) {
			if (this.direita != null) {
				this.direita.imprimePosOrdem();
			}
			if (this.esquerda != null) {
				this.esquerda.imprimePosOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");
		}
	}

	public void ImprimeInOdermInvertida() {
		if (!isEmpty()) {
			if (this.direita != null) {
				this.direita.ImprimeInOdermInvertida();
			}
			System.out.print(this.elemento.getValor() + " ");
			if (this.esquerda != null) {
				this.esquerda.ImprimeInOdermInvertida();
			}
		}
	}

	// removendo n�s da arvore
	public Arvore remover(Elemento elemento) {
		// primeiro caso - elemento encontrado
		if (this.elemento.getValor() == elemento.getValor()) {
			// caso mais simples - o elemento est� em um n� folha
			if (this.direita == null && this.esquerda == null) {
				return null;
			} else {
				// caso 2 - eu tenho filhos a esquerda e n�o tenho filhos a direita
				if (this.esquerda != null && this.direita == null) {
					return this.esquerda;
					// caso 3 - tenho filho a direita e n�o tenho a esquerda
				} else if (this.direita != null && this.esquerda == null) {
					return this.direita;
					//caso 4 - tenho filhos dos dois lados
				}else {
					//adotando a estrat�gia do maior dentre os menores
					Arvore auxiliar = this.esquerda;
					while(auxiliar.direita != null) {
						auxiliar = auxiliar.direita;
					}
					//troco os elemento da �rvore
					//n� atual recebe elemento da auxiliar, maior dentre os menores
					//insiro l� embaixo no n� folha o elemento que ser� eliminado
					this.elemento = auxiliar.getElemento(); 
					auxiliar.setElemento(elemento);
					
					this.esquerda = esquerda.remover(elemento);
				}

			}

		} else if (elemento.getValor() < this.elemento.getValor()) {
			// delegar a responsabilidade para a sub-�rvore da esquerda
			this.esquerda = this.esquerda.remover(elemento);
		} else if (elemento.getValor() > this.elemento.getValor()) {
			// delegar a responsabilidade para a sub-�rvore da direita
			this.direita = this.direita.remover(elemento);
		}

		return this;

	}

	// gets e sets
	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Arvore getDireita() {
		return direita;
	}

	public void setDireita(Arvore direita) {
		this.direita = direita;
	}

	public Arvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Arvore esquerda) {
		this.esquerda = esquerda;
	}

}
