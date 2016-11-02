package visao;

import modelo.Aluno;
import modelo.No;
import modelo.Tree;

public class Principal {
	public static void main(String[] args) {
		Tree arvore = new Tree();
		arvore.insereAluno(5, "Joao");
		arvore.insereAluno(2, "Maria");
		arvore.insereAluno(7, "Paula");
		arvore.insereAluno(23, "Carlos");
		arvore.insereAluno(1, "Pedro");
		String nome = arvore.busca(2);
		System.out.println(nome);
		arvore.percorrerPreOrdem();
		System.out.println();
		arvore.percorrerInOrdem();
		System.out.println();
		arvore.percorrerPosOrdem();
		System.out.println();
	}
}
