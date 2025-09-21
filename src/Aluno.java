import java.util.List;

public class Aluno extends Usuario{
    public Aluno(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public void adicionarLivro(Livro livro){

        if(getLivrosEmprestados().size() < 3){
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
