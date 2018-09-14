
public class Negocio extends Propriedade {

    private int pontosMultiplicar;
    
    public Negocio(String Nome, int preco, int hipoteca, int pontosMultiplicar, int proprietario) {
        super(Nome, preco, hipoteca, proprietario);
        this.pontosMultiplicar = pontosMultiplicar;
    }

    public int custoTotal() {
        return pontosMultiplicar;
    }

}