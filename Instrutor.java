public class Instrutor extends Pessoa {
    private String especialidade;
    private double salario;

    public Instrutor(String nome, String cpf, int idade, String especialidade, double salario) {
        super(nome, cpf, idade);
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public void ministrarAula() {
        System.out.println("Instrutor " + nome + " esta ministrando aula de " + especialidade + ".");
    }

    @Override
    public void exibirDados() {
        System.out.println("---- Instrutor ----");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Salario: R$ " + salario);
    }
}