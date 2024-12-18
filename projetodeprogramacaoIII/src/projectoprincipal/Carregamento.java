
package projectoprincipal;


//Class Carreamento extendendo de uma Thread
public class Carregamento extends Thread {
    
    //Declaração dos atributos**********
    String carrega;
    long tempo;
    String valorAtual;
    Integer contador;
    //Construtor vazio***********************************
     public Carregamento(){
        
     }
    //***************************************************
    //Construtor não vazio
    public Carregamento(String carrega,long tempo){
        //para o objecto em questão no atribuo 'carrega' recebe o valor que vem da inicialização
        this.carrega=carrega;
        //Idem para este caso
        this.tempo=tempo;
        
    }
    
    //implentação do metodo run(){} da classe Thread
    public void run(){
        //Tratamento da exceção**************************
        //Será executado o que esta dentro do try{}, caso esteja tudo bem.
        //Caso contrário, será executado o que está em catch(){}
        try{
            
            for(contador=0;contador<=100;contador+=2){
                
                valorAtual=Integer.toString(contador)+carrega;
                //Atualização da label de forma indireta.
                Home.lblCarrega.setText(valorAtual);
                //Efectuar ação de tempo em tempo (tempo=50 milisegundos)
                Thread.sleep(tempo);
            }
            //Depois que chegar em 100%, irá ocultr o painel splach.
            Home.painelSplach.setVisible(false);
        }catch(InterruptedException e){
            //sai do metodo run(){} caso ocorra uma exceção.
            return;
        }
        
    }
    
}