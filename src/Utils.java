import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    Scanner sc = new Scanner(System.in);

    public int menu(){
        System.out.println(
                """
                -------------- MENU --------------------
                |01 - VISUALIZAR TODOS OS LIVROS
                |02 - VISUALIZAR LIVROS POR GÊNERO
                |03 - VISUALIZAR LIVROS DISPONIVEIS
                |04 - VISUALIZAR TODOS OS USUARIOS
                |05 - VISUALIZAR TODOS OS ALUNOS
                |06 - VISUALIZAR TODOS OS PROFESSORES
                |07 - BUSCAR LIVRO POR NOME
                |08 - BUSCAR LIVRO POR PARTE DO NOME
                |09 - BUSCAR LIVRO POR PARTE DO NOME DO AUTOR
                |10 - BUSCAR USUARIO POR MATRICULA
                |11 - BUSCAR USUARIO POR PARTE DO NOME
                |12 - EMPRESTAR LIVRO
                |13 - DEVOLVER LIVRO
                |14 - USUARIO COM MAIS EMPRESTIMOS
                |15 - LIVRO MAIS EMPRESTADO
                |00 - SAIR
                | ESCOLHA: """);

        return sc.nextInt();
    }

    public List<Livro> listaInicialDeLivros(){
        List<Livro> livros = new ArrayList<>();

        livros.add(new Livro("BELAS ADORMECIDAS", "STEPHEN KING", "2020",Genero.TERROR));
        livros.add(new Livro("OUTSIDER", "STEPHEN KING", "2022",Genero.ROMANCE));
        livros.add(new Livro("CARRIE", "STEPHEN KING", "2023",Genero.TERROR));
        livros.add(new Livro("IT A COISA", "STEPHEN KING", "2019",Genero.FICCAO));
        livros.add(new Livro("FORTALEZA DIGITAL", "DAN BROWN", "2015",Genero.FANTASIA));
        livros.add(new Livro("O SIMBOLO PERDIDO", "DAN BROWN", "2020",Genero.POESIA));
        livros.add(new Livro("O OUTRO LADO DA MEIA NOITE", "SIDNEY SHELDON", "2017",Genero.AVENTURA));
        livros.add(new Livro("ANJO DA ESCURIDÃO", "SIDNEY SHELDON", "2030",Genero.MISTERIO));

        return livros;
    }

    public List<Usuario> listaInicialDeUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Aluno("THALISSON","0001"));
        usuarios.add(new Aluno("JOÃO","0002"));
        usuarios.add(new Aluno("JUNIOR","0003"));
        usuarios.add(new Aluno("RICARDO","0004"));
        usuarios.add(new Professor("LINCOLN","0005"));
        usuarios.add(new Professor("LUCAS","0006"));
        usuarios.add(new Professor("JARDEL","0007"));
        usuarios.add(new Professor("VIVI","0008"));

        return usuarios;
    }

    public String entrada(String t){
        System.out.println(t);
        return sc.nextLine();
    }

    public int entradaInt(String t){
        System.out.println(t);
        return sc.nextInt();
    }

    public Double entradaDouble(String t){
        System.out.println(t);
        return sc.nextDouble();
    }

    public void limparBuffer(){
        sc.nextLine();
    }

}
