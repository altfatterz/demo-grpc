package nl.trifork.grpc;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.examples.CalculatorRequest;
import nl.trifork.grpc.examples.CalculatorResponse;
import nl.trifork.grpc.examples.ServerStreamingCalculatorGrpc.ServerStreamingCalculatorImplBase;

/**
 * @author Zoltan Altfatter
 */
public class ServerStreamingCalculatorService extends ServerStreamingCalculatorImplBase {

    @Override
    public void calculator(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {

    }

}
