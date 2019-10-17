package modelo;

public class Arvore {
    
    private No raiz;
    private Arvore arvoreEsquerda;
    private Arvore arvoreDireita;
    
    public Arvore() {
        // construtor vazio
    }
    
    public Arvore getArvoreDireita() {
        return arvoreDireita;
    }
    
    public void setArvoreDireita(Arvore arvoreDireita) {
        this.arvoreDireita = arvoreDireita;
    }
    
    public Arvore getArvoreEsquerda() {
        return arvoreEsquerda;
    }
    
    public void setArvoreEsquerda(Arvore arvoreEsquerda) {
        this.arvoreEsquerda = arvoreEsquerda;
    }
    
    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
    
    public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }

    private void inserir(No no) {
        if (this.raiz == null){
           this.raiz = no;
        } else {
            if (no.getAluno().getMatricula() > this.raiz.getAluno().getMatricula()) {
                if (this.arvoreDireita == null) {
                    this.arvoreDireita = new Arvore();
                }
                this.arvoreDireita.inserir(no);
            } else if (no.getAluno().getMatricula() < this.raiz.getAluno().getMatricula()) {
                if (this.arvoreEsquerda == null) {
                    this.arvoreEsquerda = new Arvore();
                }
                this.arvoreEsquerda.inserir(no);
            }
        }
        
    }
    
    public String busca (int matriculaABuscar) {
        Arvore arvore = new Arvore();
        arvore.setRaiz(raiz);
        arvore.setArvoreEsquerda(arvoreEsquerda);
        arvore.setArvoreDireita(arvoreDireita);
        
        while (arvore != null) {
            if (arvore.getRaiz().getAluno().getMatricula() == matriculaABuscar) {
                return arvore.getRaiz().getAluno().getNome();
            } else if (arvore.getRaiz().getAluno().getMatricula() > matriculaABuscar) {
                arvore = arvore.getArvoreEsquerda();
            } else {
                arvore = arvore.getArvoreDireita();
            }
        }
        
        return "Não existe aluno com essa matricula.";
    }
    
    public void percorrerPreOrdem() {
        System.out.print(this.raiz.getAluno().getMatricula() + " ");
        if (this.arvoreEsquerda != null) {
            arvoreEsquerda.percorrerInOrdem();
        }
        if (this.arvoreDireita != null) {
            arvoreDireita.percorrerInOrdem();
        }
    }

    public void percorrerInOrdem() {
        if (this.arvoreEsquerda != null) {
            arvoreEsquerda.percorrerInOrdem();
        }
        System.out.print(this.raiz.getAluno().getMatricula() + " ");
        if (this.arvoreDireita != null) {
            arvoreDireita.percorrerInOrdem();
        }
    }

    public void percorrerPosOrdem() {
        if (this.arvoreEsquerda != null) {
            arvoreEsquerda.percorrerInOrdem();
        }
        if (this.arvoreDireita != null) {
            arvoreDireita.percorrerInOrdem();
        }
        System.out.print(this.raiz.getAluno().getMatricula() + " ");
    }
}
