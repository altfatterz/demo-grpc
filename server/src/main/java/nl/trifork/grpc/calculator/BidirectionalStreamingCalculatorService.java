package nl.trifork.grpc.calculator;

import io.grpc.stub.StreamObserver;

import static nl.trifork.grpc.calculator.BidirectionalStreamingCalculatorGrpc.*;

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
