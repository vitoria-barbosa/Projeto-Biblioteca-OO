import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String matricula;
    private List<Livro> livrosEmprestados = new ArrayList<>();

    public Usuario (String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public void toData(){
        System.out.printf(
                """
                | NOME                          :  %s
                | MATRICULA                     :  %s
                | QUANTIDADE LIVROS EMPRESTADOS :  %s
                
               """,this.nome,this.matricula,this.livrosEmprestados.size());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }
}
