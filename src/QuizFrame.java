import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.List;

public class QuizFrame extends javax.swing.JFrame {
    private List<Pergunta> perguntas;
    private int perguntaAtual = 0;
    private int pontuacao = 0;

    private javax.swing.JLabel palavra;
    private javax.swing.JButton resposta1;
    private javax.swing.JButton resposta2;
    private javax.swing.JButton resposta3;
    private javax.swing.JButton resposta4;
    private javax.swing.JLabel resultAsnw;
    private javax.swing.JButton nextQuestion;

    public QuizFrame() {
        initComponents();
        inicializarPerguntas();
        carregarPergunta();
    }

    private void inicializarPerguntas() {
        perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("agua", new String[]{ "àgua", "agúa", "água","ãgua"}, "água"));
        perguntas.add(new Pergunta("maquinario", new String[]{"máquinario", "maquinário", "maquìnario", "maquinarío"}, "maquinário"));
        perguntas.add(new Pergunta("oxigenio", new String[]{"oxigênio", "oxigenio", "oxigénio", "oxígeneo"}, "oxigênio"));
        perguntas.add(new Pergunta("substantivo", new String[]{"substantivo", "substantìvo", "substântivo", "substantívo"}, "substantivo"));
        perguntas.add(new Pergunta("circunferencia", new String[]{"circumferência", "circunferência", "circunferencia",  "circunferençia"}, "circunferência"));
        perguntas.add(new Pergunta("inconstitucionalissimamente", new String[]{"inconstitucionalissimamente", "inconstitucionalíssimamente", "inconstitucionalissimaménte", "inconstitucionalisimamente"}, "inconstitucionalissimamente"));
        perguntas.add(new Pergunta("otorrinolaringologista", new String[]{ "otorrinolaringólogista", "otorrinolaringologista", "otorrinólaringologista", "otorrinolaringologísta"}, "otorrinolaringologista"));
        perguntas.add(new Pergunta("tranquilo", new String[]{"tranquilo", "tranquílo", "trânquilo", "tranquïlo"}, "tranquilo"));
        perguntas.add(new Pergunta("sofa", new String[]{"sofa", "sófa", "sofá", "sôfa"}, "sofá"));
        perguntas.add(new Pergunta("impar", new String[]{"impár","ìmpar","ímpar","impar"}, "ímpar"));
}

    private void initComponents() {
        palavra = new javax.swing.JLabel();
        resposta1 = new javax.swing.JButton();
        resposta2 = new javax.swing.JButton();
        resposta3 = new javax.swing.JButton();
        resposta4 = new javax.swing.JButton();
        resultAsnw = new javax.swing.JLabel();
        nextQuestion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        palavra.setFont(new java.awt.Font("Liberation Sans", 0, 24));
        palavra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        resposta1.setFont(new java.awt.Font("Liberation Sans", 0, 14));
        resposta1.addActionListener(evt -> respostaActionPerformed(resposta1.getText()));

        resposta2.setFont(new java.awt.Font("Liberation Sans", 0, 14));
        resposta2.addActionListener(evt -> respostaActionPerformed(resposta2.getText()));

        resposta3.setFont(new java.awt.Font("Liberation Sans", 0, 14));
        resposta3.addActionListener(evt -> respostaActionPerformed(resposta3.getText()));

        resposta4.setFont(new java.awt.Font("Liberation Sans", 0, 14));
        resposta4.addActionListener(evt -> respostaActionPerformed(resposta4.getText()));

        resultAsnw.setFont(new java.awt.Font("Liberation Sans", 1, 18));

        nextQuestion.setFont(new java.awt.Font("Liberation Sans", 0, 15));
        nextQuestion.addActionListener(evt -> nextQuestionActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resposta1)
                    .addComponent(resposta4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resposta2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resposta3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(resultAsnw))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(nextQuestion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(palavra, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(palavra, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(resultAsnw)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta2)
                    .addComponent(resposta1))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta3)
                    .addComponent(resposta4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextQuestion)
                .addGap(20, 20, 20))
        );

        pack();
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
            javax.swing.JOptionPane.showMessageDialog(this, "Fim do quiz! Você acertou " + pontuacao + " perguntas.");
            System.exit(0);
        }
    }

    private void respostaActionPerformed(String respostaSelecionada) {
        Pergunta pergunta = perguntas.get(perguntaAtual);
        if (respostaSelecionada.equals(pergunta.getRespostaCorreta())) {
            resultAsnw.setText("Resposta Correta");
            resultAsnw.setForeground(Color.green);
            pontuacao++;  
        } else {
            resultAsnw.setText("Resposta Errada");
            resultAsnw.setForeground(Color.red);
        }
        nextQuestion.setText("Próximo");
        nextQuestion.setBackground(Color.white);
        SoftBevelBorder bevelBorder = new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.white);
        EmptyBorder padding = new EmptyBorder(4, 8, 4, 8);
        CompoundBorder compoundBorder = new CompoundBorder(bevelBorder, padding);
        nextQuestion.setBorder(compoundBorder);
        nextQuestion.setVisible(true);  
        desabilitarRespostas();  
    }

    private void nextQuestionActionPerformed(java.awt.event.ActionEvent evt) {
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
        java.awt.EventQueue.invokeLater(() -> {
            new QuizFrame().setVisible(true);
        });
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