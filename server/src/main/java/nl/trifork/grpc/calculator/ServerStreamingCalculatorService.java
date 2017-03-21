package nl.trifork.grpc.calculator;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.calculator.ServerStreamingCalculatorGrpc.ServerStreamingCalculatorImplBase;

/**
 * @author Zoltan Altfatter
 */
public class ServerStreamingCalculatorService extends ServerStreamingCalculatorImplBase {

    @Override
    public void calculator(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {

    }

}
