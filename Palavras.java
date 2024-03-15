package pacote_novo;

public class Palavras {

    private String nome;

    private String curso;

    private String idade;

    private String matricular;

    private String nomedelete;




    Palavras(String nome, String idade, String curso, String matricular) {

        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.matricular = matricular;
        this.nomedelete = nomedelete;
    }





    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setCurso(String novoCurso) {
        this.curso = novoCurso;
    }

    public void setMatricular(String novoMatricular) {this.matricular = novoMatricular;}

    public void setIdade(String novaIdade) {
        this.idade = novaIdade;
    }





    public String getNomedelete(){return nomedelete;}
    public String getCurso() {return curso;}
    public String getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }
    public String getMatricular() {return matricular;}


}
