package nl.trifork.grpc.calculator;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;

import java.util.concurrent.TimeUnit;

/**
 * @author Zoltan Altfatter
 */
public class AsyncClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext(true)
                .build();

        CalculatorGrpc.CalculatorFutureStub stub = CalculatorGrpc.newFutureStub(channel);
        ListenableFuture<CalculatorResponse> response = stub.calculate(CalculatorRequest.newBuilder()
                .setNumber1(10.5)
                .setNumber2(5.5)
                .setOperation(CalculatorRequest.OperationType.ADD)
                .build());

        Futures.addCallback(response, new FutureCallback<CalculatorResponse>() {

            @Override
            public void onSuccess(CalculatorResponse calculatorResponse) {
                System.out.println(calculatorResponse);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);
                System.out.println(status);
            }

        });

        channel.awaitTermination(2, TimeUnit.SECONDS);
        channel.shutdown();
    }
}
