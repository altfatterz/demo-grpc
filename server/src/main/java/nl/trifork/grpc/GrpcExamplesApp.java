package nl.trifork.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import nl.trifork.grpc.calculator.CalculatorService;
import nl.trifork.grpc.metric.MetricsServiceImpl;

import java.io.IOException;

/**
 * @author Zoltan Altfatter
 */
public class GrpcExamplesApp {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(8080)
                .addService(new CalculatorService()).addService(new MetricsServiceImpl()).build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();

    }
}
