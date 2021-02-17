package edu.escuelaing.arep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static spark.Spark.*;

/*
*
* @author Daniel Varón
 */

public class SparkWebApp {
    private final static Logger logger = LoggerFactory.getLogger(SparkWebApp.class);
    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");

        notFound((req,res)-> "<html><body><h1>Error 404</h1><p>La página " + req.url()
                + " solicitada no existe</p></body></html>");


        get("/hola", (req, res) -> {
            String respuesta = "¡Hola Mundo!";

            String nombre = req.queryParams("nombre");
            String redirect = req.queryParams("redirect");

            if (nombre != null ) {
                respuesta = "¡Hola " + nombre + "!";
                if ("Y".equals(redirect)) {
                    res.redirect("/hola/" + nombre);
                }
            }

            return respuesta;
        });

        get("/hola/:nombre", (req, res) -> {
            String hola = "¡Hola " + req.params(":nombre") + "!";
            logger.info("hola: " + hola);
            return hola;
        });
    }



    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}