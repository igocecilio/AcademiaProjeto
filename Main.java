public class Main {
    public static void main(String[] args) {
        try {
            Academia gym = new Academia("Fit & Code");

            Instrutor instr1 = new Instrutor("Carlos Silva", "11122233344", 35, "Musculacao", 3500.0);
            Instrutor instr2 = new Instrutor("Mariana Lima", "22233344455", 29, "Pilates", 3000.0);

            Aluno aluno1 = new Aluno("Mario Souza", "33344455566", 30, "Anual");
            Aluno aluno2 = new Aluno("Ana Paula", "44455566677", 25, "Mensal");

            gym.cadastrarInstrutor(instr1);
            gym.cadastrarInstrutor(instr2);
            gym.cadastrarAluno(aluno1);
            gym.cadastrarAluno(aluno2);

            gym.listarTodasPessoas();

            aluno1.pagarMensalidade();
            aluno2.pagarMensalidade(120.00);

            try {
                Aluno encontrado = gym.buscarAluno("33344455566");
                System.out.println("Aluno encontrado:");
                encontrado.exibirDados();
            } catch (AlunoNaoEncontradoException ex) {
                System.err.println("Erro: " + ex.getMessage());
            }

            try {
                Aluno achado = gym.buscarAlunoPorNome("Ana Paula");
                System.out.println("Busca por nome bem sucedida:");
                achado.exibirDados();
            } catch (AlunoNaoEncontradoException ex) {
                System.err.println("Erro: " + ex.getMessage());
            }

            try {
                gym.buscarAluno("00000000000");
            } catch (AlunoNaoEncontradoException ex) {
                System.err.println("Tratamento: " + ex.getMessage());
            }

            boolean removido = gym.removerAluno("44455566677");
            System.out.println("Aluno removido? " + removido);

            gym.listarTodasPessoas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}