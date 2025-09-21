import java.util.List;

public class Professor extends Usuario{
    public Professor(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public void adicionarLivro(Livro livro){

        if(getLivrosEmprestados().size() < 5){
            System.out.println("LIVRO EMPRESTADO COM SUCESSO!!!");

            List<Livro> livros = getLivrosEmprestados();
            livros.add(livro);
            setLivrosEmprestados(livros);
            setQuantidadeLivroEmprestao(getQuantidadeLivroEmprestao() + 1);

            return;
        }

        System.out.println("VOCÊ NÃO PODE MAIS SOLICITAR LIVROS EMPRESTADOS");
    }
}
