package nl.trifork.grpc;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.examples.BidirectionalStreamingCalculatorGrpc.BidirectionalStreamingCalculatorImplBase;
import nl.trifork.grpc.examples.CalculatorRequest;
import nl.trifork.grpc.examples.CalculatorResponse;

/**
 * @author Zoltan Altfatter
 */
public class BidirectionalStreamingCalculatorService extends BidirectionalStreamingCalculatorImplBase {

    @Override
    public StreamObserver<CalculatorRequest> calculator(StreamObserver<CalculatorResponse> responseObserver) {
        // TODO

        return null;
    }
}
