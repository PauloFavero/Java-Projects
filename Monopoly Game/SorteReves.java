
import java.util.ArrayList;

public class SorteReves extends Local {

    private ArrayList<Carta> cartas;

    public SorteReves() {
        super("Sorte ou Reves");
        cartas = new ArrayList<Carta>();

        cartas.add(new Carta("Reves", "De quem foi a incrivel ideia de uniformizar a rapaziada com bone de grife?", -25, false));
        cartas.add(new Carta("Reves", "Voce aproveitou o feriado pra visitar um amigo.", -45, false));
        cartas.add(new Carta("Reves", "Chegou o verao e o bar esta precisando de um ar condicionado novo", -45, false));
        cartas.add(new Carta("Reves", "Os advogados estao lapidando seu patrimonio. Era melhor ter andado na linha a se meter com essa gente!", -30, false));
        cartas.add(new Carta("Reves", "O portao novo da comunidade ficou uma beleza, mas vai custar aquele cascalho", -40, false));
        cartas.add(new Carta("Reves", "A central de TV esta precisando de reparos e a Anatel nao vai ajudar", -30, false));
        cartas.add(new Carta("Reves", "O micreiro que fez os banners da campanha caprichou no degrade e no orcamento", -30, false));
        cartas.add(new Carta("Reves", "Sua Toyota Hilux esta pedindo tapetes novos", -25, false));
        cartas.add(new Carta("Reves", "A casa caiu: voce foi acusado na CPI das milicias e vai tirar ferias em Bangu. Va para a prisao sem receber nada. (talvez eu faca uma visita...)", 0, true));
        cartas.add(new Carta("Reves", "A fiscalizacao apertou e esse mes nao foi possivel batizar a gasolina do posto.", -100, false));
        cartas.add(new Carta("Reves", "A feijoada de lan�amento do grupo ficou uma delicia. Ja a conta... Acabou bem salgada", -50, false));
        cartas.add(new Carta("Reves", "Nao entendeu ainda? Pra tirar cartinha tambem vai ter que pagar!", -15, false));
        cartas.add(new Carta("Reves", "A comunidade deu aquela forca pro candidato, mas ele nao se elegeu e acabou de mandar a conta da campanha", -50, false));
        cartas.add(new Carta("Reves", "A patroa podia pegar mais leve na decoracao do apartamento do Golden Green", -100, false));
        cartas.add(new Carta("Reves", "As maquinas de caca-niquel estavam desreguladas e deram um baita prejuizo", -50, false));
        cartas.add(new Carta("Sorte", "As eleicoes vem ai, mas esse papo de propagande eleitoral gratuita eh so na televisao. Pra fazer campanha vai ter que pagar!", 150, false));
        cartas.add(new Carta("Sorte", "O servico de internet de banda larga esta bombando a Lan House da firma. E a grana nao eh virtual!", 100, false));
        cartas.add(new Carta("Sorte", "Saida livre da prisao com o auxilio de falsos agentes penitenciarios. (Guarde esse cartao para quando for preciso ou negocie-o em qualquer ocasiao por preco a combinar).", 0, false));
        cartas.add(new Carta("Sorte", "O seguro de incendio do transporte alternativo aumentou, mas quem recolhe ele eh voce", 80, false));
        cartas.add(new Carta("Sorte", "Dia de Sao Jorge em Quintinho e as barracas estao vendendo ate promessa de politico.", 100, false));
        cartas.add(new Carta("Sorte", "Nao faca perguntas: avance ate o ponto de partida e... ", 200, false));
        cartas.add(new Carta("Sorte", "Voce jura que nao teve nada a ver com o sumico do delegado, mas... ", 100, false));
        cartas.add(new Carta("Sorte", "O sistema de encanamento da comunidade funciona que eh uma maravilha.", 50, false));
        cartas.add(new Carta("Sorte", "Voce fez uma pontinha num seriado da TV. Parabens!", 50, false));
        cartas.add(new Carta("Sorte", "A bandidagem esta se matando e aliviando o trabalho da turma. Alugue mais vezes seu revolver.", 20, false));
        cartas.add(new Carta("Sorte", "Todos ficamos muito comovidos com o falecimento do seu Dimas, mas nao tem jeito: pra enterrar vai ter que pagar.", 25, false));
        cartas.add(new Carta("Sorte", "O seu mandato no legislativo foi cassado, mas esqueceram de cortar a verba de gabinete", 100, false));
        cartas.add(new Carta("Sorte", "Quinta-feira: dia de cobrar o imposto pessoal da lotacao", 45, false));
        cartas.add(new Carta("Sorte", "Outro terreninho foi vendido na comunidade e 20% eh seu, claro.", 50, false));
        cartas.add(new Carta("Sorte", "Voce deu durro essa semana e hoje eh dia de rateio.", 200, false));
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}
