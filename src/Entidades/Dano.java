package Entidades;

import java.util.ArrayList;
import java.util.Random;

public class Dano {
    private ArrayList<Dado> dados;
    private ArrayList<Modificador> fixos;
	private Critico critico;
	private ArrayList<RolagemDano> rolagemDano;
    
    public Dano() {
	}
    
    public Dano(ArrayList<Dado> dados, ArrayList<Modificador> fixos, Critico critico) {
		this.dados = dados;
		this.fixos = fixos;
		this.critico = critico;
	}

	public ArrayList<Dado> getDados() {
		return dados;
	}

	public void setDados(ArrayList<Dado> dados) {
		this.dados = dados;
	}

	public ArrayList<Modificador> getFixos() {
		return fixos;
	}

	public void setFixos(ArrayList<Modificador> fixos) {
		this.fixos = fixos;
	}
		
	public Critico getCritico() {
		return critico;
	}

	public void setCritico(Critico critico) {
		this.critico = critico;
	}
	
	public ArrayList<RolagemDano> getRolagemDano() {
		return rolagemDano;
	}

	public void setRolagemDano(ArrayList<RolagemDano> rolagemDano) {
		this.rolagemDano = rolagemDano;
	}

	public ArrayList<RolagemDano> rolarDano(){
		rolagemDano = new ArrayList<RolagemDano>();
		ArrayList<Integer> danoCausado = new ArrayList<Integer>();
        Random random = new Random();

        for(int i = 0; i < this.getDados().size(); i++) {
        	for(int j = 0; j < this.getDados().get(i).getQuantidade(); j++){
                int valor = random.nextInt(this.getDados().get(i).getFaces()) + 1;
                danoCausado.add(valor);
            }
        	String nome = this.getDados().get(i).getClass().getSimpleName();
        	RolagemDano dice = new RolagemDano(nome, danoCausado);
        	rolagemDano.add(dice);
        }
        return rolagemDano;
	}
    
	public ArrayList<RolagemDano> rolarDanoCritico(){
		rolagemDano = new ArrayList<RolagemDano>();
		ArrayList<Integer> danoCausado = new ArrayList<Integer>();
        Random random = new Random();

        for(int i = 0; i < this.getDados().size(); i++) {
        	for(int j = 0; j < (this.getDados().get(i).getQuantidade() * this.critico.getMultiplicador()); j++){
                int valor = random.nextInt(this.getDados().get(i).getFaces()) + 1;
                danoCausado.add(valor);
            }
        	String nome = this.getDados().get(i).getClass().getSimpleName();
        	RolagemDano dice = new RolagemDano(nome, danoCausado);
        	rolagemDano.add(dice);
        }
        return rolagemDano;	
	}
}
