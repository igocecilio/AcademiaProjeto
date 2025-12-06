import java.util.ArrayList;
import java.util.List;

public class Academia {
    private String nome;
    private List<Aluno> alunos;
    private List<Instrutor> instrutores;

    public Academia(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.instrutores = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno a) {
        alunos.add(a);
        System.out.println("Aluno cadastrado: " + a.getNome());
    }

    public void cadastrarInstrutor(Instrutor i) {
        instrutores.add(i);
        System.out.println("Instrutor cadastrado: " + i.getNome());
    }

    public Aluno buscarAluno(String cpf) throws AlunoNaoEncontradoException {
        for (Aluno a : alunos) {
            if (a.getCpf().equals(cpf)) return a;
        }
        throw new AlunoNaoEncontradoException("Aluno com CPF " + cpf + " nao encontrado.");
    }

    public Aluno buscarAlunoPorNome(String nome) throws AlunoNaoEncontradoException {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) return a;
        }
        throw new AlunoNaoEncontradoException("Aluno com nome " + nome + " nao encontrado.");
    }

    public void listarTodasPessoas() {
        System.out.println("=== Pessoas na Academia " + nome + " ===");
        for (Aluno a : alunos) a.exibirDados();
        for (Instrutor i : instrutores) i.exibirDados();
    }

    public boolean removerAluno(String cpf) {
        return alunos.removeIf(a -> a.getCpf().equals(cpf));
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public List<Instrutor> getInstrutores() {
        return new ArrayList<>(instrutores);
    }
}