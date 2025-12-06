public class Aluno extends Pessoa {
    private String plano;
    private boolean pagamentoEmDia;

    public Aluno(String nome, String cpf, int idade, String plano) {
        super(nome, cpf, idade);
        this.plano = plano;
        this.pagamentoEmDia = false;
    }

    public Aluno(String nome, String cpf, String plano) {
        super(nome, cpf);
        this.plano = plano;
        this.pagamentoEmDia = false;
    }

    public void pagarMensalidade() {
        this.pagamentoEmDia = true;
        System.out.println(nome + " efetuou pagamento padrao do plano " + plano + ".");
    }

    public void pagarMensalidade(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de pagamento invalido.");
        this.pagamentoEmDia = true;
        System.out.println(nome + " pagou R$ " + valor + " referente ao plano " + plano + ".");
    }

    public boolean isPagamentoEmDia() {
        return pagamentoEmDia;
    }

    public String getPlano() {
        return plano;
    }

    @Override
    public void exibirDados() {
        System.out.println("---- Aluno ----");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Plano: " + plano);
        System.out.println("Pagamento em dia: " + pagamentoEmDia);
    }
}