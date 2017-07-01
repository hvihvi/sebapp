package sebapp.server;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.*;

import spark.*;

public class HttpServer {
    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {
        start(1337);
    }

    public static void start(int port) {
        port(port);
        configureRoutes();
    }

    public static void stop() {
        Spark.stop();
    }

    private static void configureRoutes() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ResponseTransformer asJson = new JsonResponseTransformer(gson);

        get("/ping", (req, res) -> getArticles(req, res));
        post("/feedback", (req, res) -> {
            JsonObject body = gson.fromJson(req.body(), JsonObject.class);
            String feedbackType = body.get("type").getAsString();
            String feedbackContent = body.get("content").getAsString();

            if ("ERROR".equals(feedbackType)) {
                logger.error(feedbackContent);
            } else {
                logger.info(feedbackContent);
            }

            return "";
        }, asJson);
        post("/order", (req, res) -> {
            JsonObject body = gson.fromJson(req.body(), JsonObject.class);
            logger.info("Incoming request on '/order': {}", body.entrySet());
            return "";
        }, asJson);
        post("/", (req, res) -> {
            JsonObject body = gson.fromJson(req.body(), JsonObject.class);
            logger.info("Incoming request on '/': {}", body.entrySet());
            return "";
        }, asJson);
    }

    private static String getArticles(Request req, Response res) {
        return "pong";
    }

}
