package edu.escuelaing.arep;
import edu.escuelaing.arep.recursos.*;
import edu.escuelaing.arep.recursos.Calculator;
import edu.escuelaing.arep.recursos.LinkedList;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;


public class SparkWebApp {
    public static void main(String[] args) {
        port(getPort());
        get("/calculator",(req,res)-> inputDataPage(req,res));
        get("/results",(req,res)->{
            String values = req.queryParams("numbers");
            String[] valuesInStringArray = values.split(",");
            LinkedList linkedList = new LinkedList();
            for(String v:valuesInStringArray){
                linkedList.addNode(Float.parseFloat(v));
            }
            double mean = Calculator.mean(linkedList);
            double deviation = Calculator.deviation(linkedList,mean);
            JSONObject jsonValue = new JSONObject();
            jsonValue.put("numbers",String.join(" ",valuesInStringArray));
            jsonValue.put("mean",mean);
            jsonValue.put("deviation",deviation);
            return outputDataPage(jsonValue);
        });
    }

    /**
     * This function returns the HTML structure to present the output data
     * @param json A JSON with the structure numbers, mean and deviation
     * @return A String that have a template of a HTML
     */
    private static String outputDataPage(JSONObject json){
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculadora de media y Desviación Estándar</h2>"
                + "<h4>Valores</h4>"
                + json.get("numbers")
                + "<h4>Media</h4>"
                + json.get("mean")
                + "<h4>Desviación Estándar</h4>"
                + json.get("deviation")
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * This function returns the HTML structure to present the input data
     * @param req The Spark HTTP Request
     * @param res The Spark HTTP Response
     * @return A String that have a template of a HTML
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculadora de media y Desviación Estándar</h2>"
                + "<form action=\"/results\">"
                + "  Números:<br>"
                + "  <input type=\"text\" name=\"números\" value=\"\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Enviar\">"
                + "</form>"
                + "<b>Debes poner los valores separados por comas \",\" en el espacio de números.</b>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * This function see the enviorment variable PORT if this exist that is returned if not the function return 4567
     * @return int that is the port that use Spark
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
