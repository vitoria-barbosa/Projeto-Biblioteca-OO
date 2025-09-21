import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private String anoPublicacao;
    private Genero genero;
    private boolean disponivel = true;

    public Livro(String nomeLivro,String autor, String anoPublicacao,Genero genero){
        this.titulo = nomeLivro;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    public void toData(){
        System.out.printf(
                """
                ------------------------
                | TITULO         :  %s
                | AUTOR          :  %s
                | ANO PUBLICAÇÃO :  %s
                | DISPONIVEL     :  %s
                | GENERO         :  %s
                ------------------------
                
               """,this.titulo,this.autor,this.anoPublicacao, this.disponivel ? "SIM" : "NÃO", this.genero.getNome());
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
