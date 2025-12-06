import javax.swing.*;
import java.awt.*;

public class InterfaceAcademia extends JFrame {
    private Academia academia;

    // Aluno fields
    private JTextField alunoNome = new JTextField(20);
    private JTextField alunoCpf = new JTextField(14);
    private JTextField alunoIdade = new JTextField(4);
    private JTextField alunoPlano = new JTextField(10);

    // Instrutor fields
    private JTextField instrNome = new JTextField(20);
    private JTextField instrCpf = new JTextField(14);
    private JTextField instrIdade = new JTextField(4);
    private JTextField instrEsp = new JTextField(12);
    private JTextField instrSalario = new JTextField(8);

    // Buscar / remover
    private JTextField buscarCpf = new JTextField(14);
    private JTextField buscarNome = new JTextField(20);

    // Listagem
    private JTextArea listArea = new JTextArea(20, 60);

    public InterfaceAcademia(Academia academia) {
        super("Academia - Interface");
        this.academia = academia;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void initUI() {
        JTabbedPane tabs = new JTabbedPane();

        // Aluno panel
        JPanel pAluno = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4,4,4,4);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0; c.gridy = 0; pAluno.add(new JLabel("Nome:"), c);
        c.gridx = 1; pAluno.add(alunoNome, c);
        c.gridx = 0; c.gridy = 1; pAluno.add(new JLabel("CPF:"), c);
        c.gridx = 1; pAluno.add(alunoCpf, c);
        c.gridx = 0; c.gridy = 2; pAluno.add(new JLabel("Idade:"), c);
        c.gridx = 1; pAluno.add(alunoIdade, c);
        c.gridx = 0; c.gridy = 3; pAluno.add(new JLabel("Plano:"), c);
        c.gridx = 1; pAluno.add(alunoPlano, c);
        JButton btnCadAluno = new JButton("Cadastrar Aluno");
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2; pAluno.add(btnCadAluno, c);
        btnCadAluno.addActionListener(e -> cadastrarAluno());

        // Instrutor panel
        JPanel pInstr = new JPanel(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();
        d.insets = new Insets(4,4,4,4);
        d.anchor = GridBagConstraints.WEST;
        d.gridx = 0; d.gridy = 0; pInstr.add(new JLabel("Nome:"), d);
        d.gridx = 1; pInstr.add(instrNome, d);
        d.gridx = 0; d.gridy = 1; pInstr.add(new JLabel("CPF:"), d);
        d.gridx = 1; pInstr.add(instrCpf, d);
        d.gridx = 0; d.gridy = 2; pInstr.add(new JLabel("Idade:"), d);
        d.gridx = 1; pInstr.add(instrIdade, d);
        d.gridx = 0; d.gridy = 3; pInstr.add(new JLabel("Especialidade:"), d);
        d.gridx = 1; pInstr.add(instrEsp, d);
        d.gridx = 0; d.gridy = 4; pInstr.add(new JLabel("Salario:"), d);
        d.gridx = 1; pInstr.add(instrSalario, d);
        JButton btnCadInstr = new JButton("Cadastrar Instrutor");
        d.gridx = 0; d.gridy = 5; d.gridwidth = 2; pInstr.add(btnCadInstr, d);
        btnCadInstr.addActionListener(e -> cadastrarInstrutor());

        // Buscar/Remover panel
        JPanel pBusca = new JPanel(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(4,4,4,4);
        b.anchor = GridBagConstraints.WEST;
        b.gridx = 0; b.gridy = 0; pBusca.add(new JLabel("Buscar CPF:"), b);
        b.gridx = 1; pBusca.add(buscarCpf, b);
        JButton btnBuscarCpf = new JButton("Buscar Aluno (CPF)");
        b.gridx = 2; pBusca.add(btnBuscarCpf, b);
        btnBuscarCpf.addActionListener(e -> buscarPorCpf());

        b.gridx = 0; b.gridy = 1; pBusca.add(new JLabel("Buscar Nome:"), b);
        b.gridx = 1; pBusca.add(buscarNome, b);
        JButton btnBuscarNome = new JButton("Buscar Aluno (Nome)");
        b.gridx = 2; pBusca.add(btnBuscarNome, b);
        btnBuscarNome.addActionListener(e -> buscarPorNome());

        JButton btnRemover = new JButton("Remover Aluno (CPF)");
        b.gridx = 1; b.gridy = 2; pBusca.add(btnRemover, b);
        btnRemover.addActionListener(e -> removerPorCpf());

        // Listar panel
        JPanel pListar = new JPanel(new BorderLayout());
        listArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(listArea);
        pListar.add(scroll, BorderLayout.CENTER);
        JButton btnAtualizar = new JButton("Atualizar Lista");
        pListar.add(btnAtualizar, BorderLayout.SOUTH);
        btnAtualizar.addActionListener(e -> atualizarLista());

        tabs.addTab("Aluno", pAluno);
        tabs.addTab("Instrutor", pInstr);
        tabs.addTab("Buscar/Remover", pBusca);
        tabs.addTab("Listar", pListar);

        getContentPane().add(tabs, BorderLayout.CENTER);
    }

    private void cadastrarAluno() {
        String nome = alunoNome.getText().trim();
        String cpf = alunoCpf.getText().trim();
        String idadeS = alunoIdade.getText().trim();
        String plano = alunoPlano.getText().trim();
        if (nome.isEmpty() || cpf.isEmpty() || plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha nome, CPF e plano.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idade = 0;
        try { if (!idadeS.isEmpty()) idade = Integer.parseInt(idadeS); } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Idade invalida.", "Erro", JOptionPane.ERROR_MESSAGE); return; }
        Aluno a = new Aluno(nome, cpf, idade, plano);
        academia.cadastrarAluno(a);
        JOptionPane.showMessageDialog(this, "Aluno cadastrado: " + nome);
        limparCamposAluno();
        atualizarLista();
    }

    private void cadastrarInstrutor() {
        String nome = instrNome.getText().trim();
        String cpf = instrCpf.getText().trim();
        String idadeS = instrIdade.getText().trim();
        String esp = instrEsp.getText().trim();
        String salS = instrSalario.getText().trim();
        if (nome.isEmpty() || cpf.isEmpty() || esp.isEmpty() || salS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos do instrutor.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idade = 0; double salario = 0.0;
        try { if (!idadeS.isEmpty()) idade = Integer.parseInt(idadeS); salario = Double.parseDouble(salS); } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Idade ou salario invalido.", "Erro", JOptionPane.ERROR_MESSAGE); return; }
        Instrutor i = new Instrutor(nome, cpf, idade, esp, salario);
        academia.cadastrarInstrutor(i);
        JOptionPane.showMessageDialog(this, "Instrutor cadastrado: " + nome);
        limparCamposInstrutor();
        atualizarLista();
    }

    private void buscarPorCpf() {
        String cpf = buscarCpf.getText().trim();
        if (cpf.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe um CPF.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
        try {
            Aluno a = academia.buscarAluno(cpf);
            mostrarTextoDialog("Aluno encontrado", montarTextoAluno(a));
        } catch (AlunoNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Nao encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void buscarPorNome() {
        String nome = buscarNome.getText().trim();
        if (nome.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe um nome.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
        try {
            Aluno a = academia.buscarAlunoPorNome(nome);
            mostrarTextoDialog("Aluno encontrado", montarTextoAluno(a));
        } catch (AlunoNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Nao encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void removerPorCpf() {
        String cpf = buscarCpf.getText().trim();
        if (cpf.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe um CPF.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
        boolean ok = academia.removerAluno(cpf);
        JOptionPane.showMessageDialog(this, "Aluno removido? " + ok);
        atualizarLista();
    }

    private void atualizarLista() {
        // Captura a saída do método listarTodasPessoas() para exibir na área de texto
        java.io.PrintStream originalOut = System.out;
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        try {
            System.setOut(ps);
            academia.listarTodasPessoas();
            ps.flush();
        } finally {
            System.setOut(originalOut);
        }
        listArea.setText(baos.toString());
    }

    private String montarTextoAluno(Aluno a) {
        return String.format("Nome: %s | CPF: %s | Idade: %d | Plano: %s | Pagamento: %s",
                a.getNome(), a.getCpf(), a.getIdade(), a.getPlano(), a.isPagamentoEmDia());
    }

    // montagem de texto para instrutor não é necessária: usamos listarTodasPessoas() capturada

    private void mostrarTextoDialog(String titulo, String texto) {
        JTextArea t = new JTextArea(texto);
        t.setEditable(false);
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        JOptionPane.showMessageDialog(this, new JScrollPane(t), titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void limparCamposAluno() {
        alunoNome.setText(""); alunoCpf.setText(""); alunoIdade.setText(""); alunoPlano.setText("");
    }

    private void limparCamposInstrutor() {
        instrNome.setText(""); instrCpf.setText(""); instrIdade.setText(""); instrEsp.setText(""); instrSalario.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Academia gym = new Academia("Fit & Code");
            InterfaceAcademia ui = new InterfaceAcademia(gym);
            ui.setVisible(true);
        });
    }
}
