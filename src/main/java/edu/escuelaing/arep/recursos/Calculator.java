package edu.escuelaing.arep.recursos;

public class Calculator {
    /**
     * Calculate the mean value of a set of numbers
     * @param lista Is a linkedlist that is implement by me in this project
     * @return Return a double value that is the mean of the linkedlist
     * @throws Exception
     */
    public static double mean(LinkedList lista) throws Exception {
        double sumaDeValores = 0;
        lista.restartView();
        sumaDeValores+=lista.nowNode.value;
        for(int i = 0; i< lista.size-1;i++){
            sumaDeValores+=lista.nextNode().value;
        }

        return Math.round(sumaDeValores/lista.size*100.0)/100.0;
    }

    /**
     * Calculate the standar deviation value of a set of numbers
     * @param lista Is a linkedlist that is implement by me in this project
     * @param avg Is the average value of the same linkedlist
     * @return Return a double value that is the standar deviation of the linkedlist
     * @throws Exception
     */
    public static double deviation(LinkedList lista,double avg) throws Exception {
        double sumaDeValores = 0.0;
        lista.restartView();

        sumaDeValores+=(Math.pow((lista.nowNode.value - avg),2));
        double valorIteracion = 0.0;
        for(int i = 0; i< lista.size-1;i++){
            valorIteracion = Math.pow((lista.nextNode().value - avg),2);
            sumaDeValores+=valorIteracion;
        }

        double valorDentroRaiz = sumaDeValores/(lista.size-1);
        return Math.round(Math.sqrt(valorDentroRaiz)*100.0)/100.0;
    }
}
