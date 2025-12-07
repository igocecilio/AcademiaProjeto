# AcademiaProjeto
Projeto de exemplo para gerenciamento de uma academia (alunos, instrutores, planos).

## Descrição
Aplicação simples em Java que demonstra cadastro de `Aluno` e `Instrutor`, gerenciamento de planos e pagamentos, busca e remoção de alunos.

## Planos disponíveis (no código)
- `Anual`
- `Mensal`

> Observação: atualmente os planos são strings no campo `plano` da classe `Aluno`. Se desejar, posso alterar para um `enum` para validação mais rígida.

## Requisitos
- JDK 17+ (o repositório foi testado com OpenJDK 25)
- Git
- (Opcional) GitHub CLI `gh` para criar releases

## Como compilar (PowerShell)
Abra o PowerShell na pasta do projeto e execute:

```powershell
Set-Location -Path 'C:\Users\igoce\Documents\AcademiaProjeto'
javac -d bin *.java
```

Isso vai criar o diretório `bin/` com os arquivos compilados (`.class`).

> Nota: o repositório contém um `.gitignore` que já ignora `*.class` e `bin/` para evitar commitar arquivos gerados.

## Como executar (PowerShell)
Após compilar, execute:

```powershell
Set-Location -Path 'C:\Users\igoce\Documents\AcademiaProjeto'
java -cp bin Main
```

## Script rápido (opcional)
Você pode criar um script `run.ps1` para compilar e executar em um só comando. Exemplo de conteúdo para `run.ps1`:

```powershell
# Compila e executa o projeto
javac -d bin *.java
java -cp bin Main
```

Salve o arquivo e rode:

```powershell
.\run.ps1
```

## Git — adicionar README e enviar ao GitHub
Se quiser, rode estes comandos para commitar e enviar o `README.md` ao remoto:

```powershell
Set-Location -Path 'C:\Users\igoce\Documents\AcademiaProjeto'
git add README.md
git commit -m "Adiciona README com instrucoes de compilacao e execucao"
git push origin main
```

## Possíveis melhorias
- Tornar `plano` um `enum` para evitar strings livres.
- Adicionar testes unitários.
- Adicionar um `build.gradle`/`pom.xml` para build automatizado.
- Criar GitHub Actions para CI (compilar e rodar testes automaticamente).

Se quiser que eu:
- comite e faça push do `README.md` agora;
- gere o `run.ps1` automaticamente;
- converta `plano` para um `enum` e atualize o código,
diga qual opção prefere.
