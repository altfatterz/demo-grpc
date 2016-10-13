package nl.trifork.grpc;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.examples.CalculatorRequest;
import nl.trifork.grpc.examples.CalculatorResponse;
import nl.trifork.grpc.examples.ClientStreamingCalculatorGrpc.ClientStreamingCalculatorImplBase;

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
