import java.util.List;

public class VisualizadorDeMedia implements Observador {
    private FonteDeDados fonte;
    private boolean ligado;

    public VisualizadorDeMedia(FonteDeDados fonte) {
        this.fonte = fonte;
        this.ligado = false; 
    }

    public void ligar() {
        if (!ligado) {
            this.fonte.adicionarObservador(this);
            ligado = true;
            System.out.println("Visualizador de Média ligado.");
        }
    }

    public void desligar() {
        if (ligado) {
            this.fonte.removerObservador(this);
            ligado = false;
            System.out.println("Visualizador de Média desligado.");
        }
    }

    @Override
    public void atualizar() {
        exibeMedia();
    }

    public void exibeMedia() {
        List<Integer> valores = fonte.getValores();
        double media = valores.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
        System.out.println("Média: " + media + ", quantidade de elementos analisados: " + valores.size());
    }
}
