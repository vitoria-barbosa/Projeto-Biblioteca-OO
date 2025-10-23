package Entidades;

import Entidades.Enum.Genero;

import java.util.List;

import static Utilitarios.Utils.*;

public class Biblioteca {

    private List<Livro> livros = listaInicialDeLivros();
    private List<Usuario> usuarios = listaInicialDeUsuarios();;

    public void emprestarLivro(){
        listarTodosOsUsuarios();
        Usuario usuario = validarUsuarioPorMatricula();

        listarTodosOsLivros();
        Livro livro = validarLivroPorNome();

        usuario.adicionarLivro(livro);
        livro.mudarStatusDisponibilidade();
        livro.setQtdVezesFoiEmprestado(livro.getQtdVezesFoiEmprestado() + 1);
    }

    public void devolverLivro(){
        listarTodosOsUsuarios();
        Usuario usuario = validarUsuarioPorMatricula();

        if(usuario.getLivrosEmprestados().size() > 0){
            for(Livro livro : usuario.getLivrosEmprestados()){
                livro.toData();
            }

            String nome = entrada("LIVRO: ").toUpperCase().trim();


            for(Livro livro : livros){
                if(livro.getTitulo().equals(nome)){
                    List<Livro> livroList = usuario.getLivrosEmprestados();
                    livroList.remove(livro);
                    livro.mudarStatusDisponibilidade();
                    System.out.println("LIVRO DEVOLVIDO COM SUCESSO!!");
                    return;
                }
            }
            System.out.println("LIVRO NÃO ENCONTRADO!!");
            devolverLivro();
        }else{
            System.out.println("ESSE USUARIO NÃO TEM LIVRO EMPRESTADO");
        }
    }

    public Livro validarLivroPorNome(){
        String nome = entrada("LIVRO: ").toUpperCase().trim();

        for(Livro livro : livros){
            if(livro.getTitulo().equals(nome)){
                if(livro.isDisponivel()){
                    return livro;
                }else{
                    System.out.println("LIVRO NÃO ESTÁ DISPONIVEL");
                    return validarLivroPorNome();
                }
            }
        }

        System.out.println("LIVRO NÃO ENCONTRADO!!!");

        return validarLivroPorNome();
    }

    public Usuario validarUsuarioPorMatricula(){
        String matricula = entrada("MATRICULA: ").toUpperCase().trim();

        for(Usuario usuario : usuarios){
            if(usuario.getMatricula().equals(matricula)){
                return usuario;
            }
        }

        System.out.println("USUARIO NÃO ENCONTRADO!!");

        return validarUsuarioPorMatricula();
    }

    public void mostrarUsuarioComMaisEmprestimos() {
        if (usuarios.isEmpty()) {
            System.out.println("NENHUM USUARIO CADASTRADO.");
            return;
        }

        Usuario usuarioComMaisEmprestimos = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getLivrosEmprestados().size() > 0) {
                if (usuarioComMaisEmprestimos == null ||
                        usuario.getLivrosEmprestados().size() > usuarioComMaisEmprestimos.getLivrosEmprestados().size()) {
                    usuarioComMaisEmprestimos = usuario;
                }
            }
        }

        if (usuarioComMaisEmprestimos != null) {
            System.out.println("\nUSUÁRIO COM MAIS LIVROS EMPRESTADOS:");
            usuarioComMaisEmprestimos.toData();
        } else {
            System.out.println("NENHUM USUARIO REALIZOU EMPRÉSTIMOS AINDA.");
        }
    }


    public void mostrarLivroMaisEmprestado() {
        if (livros.isEmpty()) {
            System.out.println("NENHUM LIVRO CADASTRADO.");
            return;
        }

        Livro livroMaisEmprestado = null;

        for (Livro livro : livros) {
            if (livro.getQtdVezesFoiEmprestado() > 0) {
                if (livroMaisEmprestado == null ||
                        livro.getQtdVezesFoiEmprestado() > livroMaisEmprestado.getQtdVezesFoiEmprestado()) {
                    livroMaisEmprestado = livro;
                }
            }
        }

        if (livroMaisEmprestado != null) {
            System.out.println("\nLIVRO MAIS EMPRESTADO:");
            livroMaisEmprestado.toData();
            System.out.printf("QUANTIDADE DE EMPRÉSTIMOS: %d\n", livroMaisEmprestado.getQtdVezesFoiEmprestado());
        } else {
            System.out.println("NENHUM LIVRO FOI EMPRESTADO AINDA.");
        }
    }



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

          int escolha = entradaInt("ESCOLHA UM NÚMERO: ");

          Genero genero = Genero.values()[escolha - 1];

          for(Livro livro : livros){
              if(livro.getGenero() == genero){
                  livro.toData();
              }
          }
      } catch (Exception e){
          System.out.println("Entrada inválida!! Informe corretamente o número!");
          limparBuffer();
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
        String nome = entrada("INFORME O NOME DO LIVRO: ").toUpperCase().trim();


        for(Livro livro : livros){
            if(livro.getTitulo().equals(nome)){
                livro.toData();
                return;
            }
        }

        System.out.println("LIVRO NÃ0 ENCONTRADO");
    }

    public void buscarLivroPorParteNome(){
        String nome = entrada("INFORME O NOME DO LIVRO: ").toUpperCase().trim();
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
        String nome = entrada("INFORME O NOME DO AUTOR: ").toUpperCase().trim();
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
        String matricula = entrada("INFORME A MATRICULA: ").toUpperCase().trim();

        for(Usuario usuario : usuarios){
            if(usuario.getMatricula().equals(matricula)){
                usuario.toData();
                return;
            }
        }

        System.out.println("USUARIO NÃO ENCONTRADO");
    }


    public void buscarUsuarioPorParteNome(){
        String nome = entrada("INFORME O NOME DO USUARIO: ").toUpperCase().trim();
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
