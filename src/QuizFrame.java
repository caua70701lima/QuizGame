import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class QuizFrame extends JFrame {
    private java.util.List<Pergunta> perguntas;
    private int perguntaAtual = 0;
    private int pontuacao = 0;

    private JLabel palavra;
    private JButton resposta1;
    private JButton resposta2;
    private JButton resposta3;
    private JButton resposta4;
    private JLabel resultAsnw;
    private JButton nextQuestion;

    public QuizFrame() {
        setTitle("Quiz de Acentuação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JOptionPane.showMessageDialog(this, "Seja bem vindo ao quiz de acentuação!");
        JOptionPane.showMessageDialog(this, "São 10 perguntas no total, questões de multipla escolha!"
                + " Você deve escolher a alternativa correta, mas lembre-se nem todas têm acento. Boa Sorte!!");

        // Definir fonte
        Font fontLabel = new Font("Liberation Sans", Font.PLAIN, 24);
        Font fontButton = new Font("Liberation Sans", Font.PLAIN, 24);
        Font fontResult = new Font("Liberation Sans", Font.BOLD, 18);

        // Inicializar componentes
        palavra = new JLabel();
        palavra.setFont(fontLabel);
        palavra.setHorizontalAlignment(SwingConstants.CENTER);

        resposta1 = new JButton();
        resposta1.setFont(fontButton);
        resposta1.addActionListener(evt -> respostaActionPerformed(resposta1.getText()));

        resposta2 = new JButton();
        resposta2.setFont(fontButton);
        resposta2.addActionListener(evt -> respostaActionPerformed(resposta2.getText()));

        resposta3 = new JButton();
        resposta3.setFont(fontButton);
        resposta3.addActionListener(evt -> respostaActionPerformed(resposta3.getText()));

        resposta4 = new JButton();
        resposta4.setFont(fontButton);
        resposta4.addActionListener(evt -> respostaActionPerformed(resposta4.getText()));

        resultAsnw = new JLabel();
        resultAsnw.setFont(fontResult);
        resultAsnw.setHorizontalAlignment(SwingConstants.CENTER);

        nextQuestion = new JButton();
        nextQuestion.setFont(fontButton);
        nextQuestion.addActionListener(evt -> nextQuestionActionPerformed(evt));

        // Adicionar componentes ao layout
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 3.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(palavra, gbc);

        gbc.gridy = 1;
        add(resultAsnw, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        add(resposta1, gbc);

        gbc.gridx = 1;
        add(resposta2, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(resposta3, gbc);

        gbc.gridx = 1;
        add(resposta4, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(nextQuestion, gbc);

        pack();
        setMinimumSize(new Dimension(400, 300));

        inicializarPerguntas();
        carregarPergunta();
    }

    private void inicializarPerguntas() {
        perguntas = new java.util.ArrayList<>();
        perguntas.add(new Pergunta("agua", new String[]{ "àgua", "agúa", "água","ãgua"}, "água"));
        perguntas.add(new Pergunta("maquinario", new String[]{"máquinario", "maquinário", "maquìnario", "maquinarío"}, "maquinário"));
        perguntas.add(new Pergunta("oxigenio", new String[]{"oxigênio", "oxigenio", "oxigénio", "oxígeneo"}, "oxigênio"));
        perguntas.add(new Pergunta("substantivo", new String[]{"substantivo", "substantìvo", "substântivo", "substantívo"}, "substantivo"));
        perguntas.add(new Pergunta("circunferencia", new String[]{"circunferencía", "circunferência", "circunferencia",  "circunferenciâ"}, "circunferência"));
        perguntas.add(new Pergunta("inconstitucionalissimamente", new String[]{"inconstitucionalissimamente", "inconstitucionalíssimamente", "inconstitucionalissimaménte", "inconstitucionalissimamenté"}, "inconstitucionalissimamente"));
        perguntas.add(new Pergunta("otorrinolaringologista", new String[]{ "otorrinolaringologistá", "otorrinolaringologista", "otorrinolaringológista", "otorrinolaringologísta"}, "otorrinolaringologista"));
        perguntas.add(new Pergunta("tranquilo", new String[]{"tranquilo", "tranquílo", "trânquilo", "tranquïlo"}, "tranquilo"));
        perguntas.add(new Pergunta("sofa", new String[]{"sofa", "sófa", "sofá", "sôfa"}, "sofá"));
        perguntas.add(new Pergunta("impar", new String[]{"impár","ìmpar","ímpar","impar"}, "ímpar"));
    }

    private void carregarPergunta() {
        if (perguntaAtual < perguntas.size()) {
            Pergunta pergunta = perguntas.get(perguntaAtual);
            palavra.setText(pergunta.getPalavra());
            resposta1.setText(pergunta.getOpcoes()[0]);
            resposta2.setText(pergunta.getOpcoes()[1]);
            resposta3.setText(pergunta.getOpcoes()[2]);
            resposta4.setText(pergunta.getOpcoes()[3]);
            resultAsnw.setText("");
            nextQuestion.setVisible(false);
            resposta1.setEnabled(true);
            resposta2.setEnabled(true);
            resposta3.setEnabled(true);
            resposta4.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Fim do quiz! Você acertou " + pontuacao + " perguntas.");
            JOptionPane.showMessageDialog(this, "Projeto desenvolvido por: Cauã Lima, Nário César, Daniel Henrique, Thomé da Silva, Rykelme Andu e Matheus Gabriel");
            System.exit(0);
        }
    }

    private void respostaActionPerformed(String respostaSelecionada) {
        Pergunta pergunta = perguntas.get(perguntaAtual);
        if (respostaSelecionada.equals(pergunta.getRespostaCorreta())) {
            resultAsnw.setText("Resposta Correta");
            resultAsnw.setForeground(Color.GREEN);
            pontuacao++;  
        } else {
            resultAsnw.setText("Resposta Errada");
            resultAsnw.setForeground(Color.RED);
        }
        nextQuestion.setText("Próximo");
        nextQuestion.setBackground(Color.WHITE);
        SoftBevelBorder bevelBorder = new SoftBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE);
        EmptyBorder padding = new EmptyBorder(4, 8, 4, 8);
        CompoundBorder compoundBorder = new CompoundBorder(bevelBorder, padding);
        nextQuestion.setBorder(compoundBorder);
        nextQuestion.setVisible(true);  
        desabilitarRespostas();  
    }

    private void nextQuestionActionPerformed(ActionEvent evt) {
        perguntaAtual++;
        carregarPergunta();
    }

    private void desabilitarRespostas() {
        resposta1.setEnabled(false);
        resposta2.setEnabled(false);
        resposta3.setEnabled(false);
        resposta4.setEnabled(false);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new QuizFrame().setVisible(true));
    }
}

class Pergunta {
    private String palavra;
    private String[] opcoes;
    private String respostaCorreta;

    public Pergunta(String palavra, String[] opcoes, String respostaCorreta) {
        this.palavra = palavra;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    public String getPalavra() { return palavra; }
    public String[] getOpcoes() { return opcoes; }
    public String getRespostaCorreta() { return respostaCorreta; }
}