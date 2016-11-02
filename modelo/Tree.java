package modelo;

public class Tree {
	
	private No root;
	private Tree leftTree;
	private Tree rightTree;
	
	public Tree(){
		// construtor vazio
	}
	
	public Tree getRightTree(){
		return rightTree;
	}
	
	public void setRightTree(Tree rightTree){
		this.rightTree = rightTree;
	}
	
	public Tree getLeftTree(){
		return leftTree;
	}
	
	public void setLeftTree(Tree leftTree){
		this.leftTree = leftTree;
	}
	
	 public No getRoot() {
	        return root;
	 }

	public void setRoot(No root) {
	        this.root = root;
	}
	
	public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }

	private void inserir(No no) {
		if(this.root == null){
		   this.root = no;
		}
		else {
			if (no.getAluno().getMatricula() > this.root.getAluno().getMatricula()){
				if (this.rightTree == null){
					this.rightTree = new Tree();
				}
				this.rightTree.inserir(no);
			}
			else if (no.getAluno().getMatricula() < this.root.getAluno().getMatricula()){
				if (this.leftTree == null){
					this.leftTree = new Tree();
				}
				this.leftTree.inserir(no);
			}
		}
		
	}
	
	public String busca (int matriculaABuscar) {
		Tree arvore = new Tree();
		arvore.setRoot(root);
		arvore.setLeftTree(leftTree);
		arvore.setRightTree(rightTree);
		while (arvore != null) {
			if (arvore.getRoot().getAluno().getMatricula() == matriculaABuscar) {
				return arvore.getRoot().getAluno().getNome();
			} else if (arvore.getRoot().getAluno().getMatricula() > matriculaABuscar) {
				arvore = arvore.getLeftTree();
			} else {
				arvore = arvore.getRightTree();
			}
		}
			return "Não existe aluno com essa matricula";
	}
	
	public void percorrerPreOrdem() {
		System.out.print(this.root.getAluno().getMatricula() + " ");
		if (this.leftTree != null) {
			leftTree.percorrerInOrdem();
		}
		if (this.rightTree != null) {
			rightTree.percorrerInOrdem();
		}
	}

	public void percorrerInOrdem() {
		if (this.leftTree != null) {
			leftTree.percorrerInOrdem();
		}
		System.out.print(this.root.getAluno().getMatricula() + " ");
		if (this.rightTree != null) {
			rightTree.percorrerInOrdem();
		}
	}

	public void percorrerPosOrdem() {
		if (this.leftTree != null) {
			leftTree.percorrerInOrdem();
		}
		if (this.rightTree != null) {
			rightTree.percorrerInOrdem();
		}
		System.out.print(this.root.getAluno().getMatricula() + " ");
	}
}
