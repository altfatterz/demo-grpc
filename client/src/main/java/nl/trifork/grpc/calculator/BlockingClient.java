package nl.trifork.grpc.calculator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Zoltan Altfatter
 */
public class BlockingClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext(true)
                .build();

        CalculatorGrpc.CalculatorBlockingStub calculatorBlockingStub = CalculatorGrpc.newBlockingStub(channel);
        CalculatorResponse response = calculatorBlockingStub.calculate(CalculatorRequest.newBuilder()
                .setNumber1(10.5)
                .setNumber2(5.5)
                .setOperation(CalculatorRequest.OperationType.ADD)
                .build());

        System.out.println(response);

        channel.shutdown();


    }
}
