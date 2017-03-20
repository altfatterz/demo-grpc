package nl.trifork.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.examples.CalculatorGrpc;
import nl.trifork.grpc.examples.CalculatorRequest;
import nl.trifork.grpc.examples.CalculatorResponse;

import java.util.concurrent.TimeUnit;

/**
 * @author Zoltan Altfatter
 */
public class AsyncClient2 {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext(true)
                .build();

        CalculatorGrpc.CalculatorStub stub = CalculatorGrpc.newStub(channel);

        stub.calculate(CalculatorRequest.newBuilder()
                .setNumber1(10.5)
                .setNumber2(5.5)
                .setOperation(CalculatorRequest.OperationType.ADD)
                .build(), new StreamObserver<CalculatorResponse>() {

            @Override
            public void onNext(CalculatorResponse calculatorResponse) {
                System.out.println(calculatorResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);
                System.out.println(status);
            }

            @Override
            public void onCompleted() {

            }
        });

        channel.awaitTermination(2, TimeUnit.SECONDS);
        channel.shutdown();
    }
}
