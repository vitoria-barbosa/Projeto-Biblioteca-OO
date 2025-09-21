import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private Utils utils = new Utils();

    private List<Livro> livros = utils.listaInicialDeLivros();
    private List<Usuario> usuarios = utils.listaInicialDeUsuarios();;


    public void listarTodosOsLivros(){
        for(Livro livro : livros){
            livro.toData();
        }
    }

    public void listarLivroPorGenero(){
      try{
          System.out.println("ESCOLHA UM GÊNERO PARA LISTAR OS LIVROS:");

          for(Genero genero: Genero.values()){
              System.out.printf(
                      """
                      | %s   :  %s
                      """,genero.ordinal() + 1, genero.getNome());
          }

          int escolha = utils.entradaInt("ESCOLHA UM NÚMERO: ");

          Genero genero = Genero.values()[escolha - 1];

          for(Livro livro : livros){
              if(livro.getGenero() == genero){
                  livro.toData();
              }
          }
      } catch (Exception e){
          System.out.println("Entrada inválida!! Informe corretamente o número!");
          utils.limparBuffer();
      }
    }


    public void listarTodosOsLivrosDisponiveis(){
        for(Livro livro : livros){
            if(livro.isDisponivel()){
                livro.toData();
            }
        }
    }

    public void listarTodosOsUsuarios(){
        for(Usuario usuario : usuarios){
            usuario.toData();
        }
    }


    public void listarTodosOsProfessores(){
        for(Usuario usuario : usuarios){
            if(usuario instanceof Professor){
                usuario.toData();
            }
        }
    }


    public void listarTodosOsAlunos(){
        for(Usuario usuario : usuarios){
            if(usuario instanceof Aluno){
                usuario.toData();
            }
        }
    }

    public void buscarLivroPorTitulo(){
        String nome = utils.entrada("INFORME O NOME DO LIVRO: ").toUpperCase().trim();


        for(Livro livro : livros){
            if(livro.getTitulo().equals(nome)){
                livro.toData();
                return;
            }
        }

        System.out.println("LIVRO NÃ0 ENCONTRADO");
    }

    public void buscarLivroPorParteNome(){
        String nome = utils.entrada("INFORME O NOME DO LIVRO: ").toUpperCase().trim();
        boolean livroEncontrado = false;

        for(Livro livro : livros){
            if(livro.getTitulo().contains(nome)){
                livro.toData();
                livroEncontrado = true;
            }
        }

        if(!livroEncontrado){
            System.out.println("LIVRO NÃ0 ENCONTRADO");
        }

    }

    public void buscarLivroPorParteNomeAutor(){
        String nome = utils.entrada("INFORME O NOME DO AUTOR: ").toUpperCase().trim();
        boolean livroEncontrado = false;


        for(Livro livro : livros){
            if(livro.getAutor().contains(nome)){
                livro.toData();
                livroEncontrado = true;
            }
        }

        if(!livroEncontrado){
            System.out.println("LIVRO NÃ0 ENCONTRADO");
        }
    }


    public void buscarUsuarioPorMatricula(){
        String matricula = utils.entrada("INFORME A MATRICULA: ").toUpperCase().trim();

        for(Usuario usuario : usuarios){
            if(usuario.getMatricula().equals(matricula)){
                usuario.toData();
                return;
            }
        }

        System.out.println("USUARIO NÃO ENCONTRADO");
    }


    public void buscarUsuarioPorParteNome(){
        String nome = utils.entrada("INFORME O NOME DO USUARIO: ").toUpperCase().trim();
        boolean usuarioEncontrado = false;

        for(Usuario usuario : usuarios){
            if(usuario.getNome().contains(nome)){
                usuario.toData();
                usuarioEncontrado = true;
            }
        }

        if(!usuarioEncontrado){
            System.out.println("USUARIO NÃO ENCONTRADO");
        }
    }


}
