import java.util.List;

public class Main {
    static Utils utils = new Utils();

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int escolha = 1;

        while(escolha != 0){
            escolha = utils.menu();

            switch (escolha){
                case 1:
                    System.out.println("----------- TODOS OS LIVROS ---------------");
                    biblioteca.listarTodosOsLivros();
                    break;
                case 2:
                    System.out.println("----------- LIVROS POR GÊNERO ---------------");
                    biblioteca.listarLivroPorGenero();
                    break;
                case 3:
                    System.out.println("----------- LIVROS DISPONIVEIS ---------------");
                    biblioteca.listarTodosOsLivrosDisponiveis();
                    break;
                case 4:
                    System.out.println("----------- TODOS OS USUARIOS ---------------");
                    biblioteca.listarTodosOsUsuarios();
                    break;
                case 5:
                    System.out.println("----------- TODOS OS ALUNOS ---------------");
                    biblioteca.listarTodosOsAlunos();
                    break;
                case 6:
                    System.out.println("----------- TODOS OS PROFESSORES ---------------");
                    biblioteca.listarTodosOsProfessores();
                    break;
                case 7:
                    biblioteca.buscarLivroPorTitulo();
                    break;
                case 8:
                    biblioteca.buscarLivroPorParteNome();
                    break;
                case 9:
                    biblioteca.buscarLivroPorParteNomeAutor();
                    break;
                case 10:
                    biblioteca.buscarUsuarioPorMatricula();
                    break;
                case 11:
                    biblioteca.buscarUsuarioPorParteNome();
                    break;
                case 12:
                    biblioteca.emprestarLivro();
                    break;
                case 13:
                    biblioteca.devolverLivro();
                    break;
                case 14:
                    biblioteca.mostrarUsuarioComMaisEmprestimos();
                    break;
                case 15:
                    biblioteca.mostrarLivroMaisEmprestado();
                    break;
                case 0:
                    System.out.println("PROGRAMA FINALIZADO!!!");
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA!!!");
            }
        }
    }
}