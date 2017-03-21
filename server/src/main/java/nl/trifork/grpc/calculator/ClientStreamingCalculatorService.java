package nl.trifork.grpc.calculator;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.calculator.ClientStreamingCalculatorGrpc.ClientStreamingCalculatorImplBase;

/**
 * @author Zoltan Altfatter
 */
public class ClientStreamingCalculatorService extends ClientStreamingCalculatorImplBase {

    @Override
    public StreamObserver<CalculatorRequest> calculator(StreamObserver<CalculatorResponse> responseObserver) {

        // TODO

        return null;
    }
}
