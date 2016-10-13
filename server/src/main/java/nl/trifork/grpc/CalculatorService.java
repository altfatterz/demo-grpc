package nl.trifork.grpc;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.examples.CalculatorGrpc.CalculatorImplBase;
import nl.trifork.grpc.examples.CalculatorRequest;
import nl.trifork.grpc.examples.CalculatorResponse;

/**
 * @author Zoltan Altfatter
 */
public class CalculatorService extends CalculatorImplBase {

    @Override
    public void calculate(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        CalculatorResponse.Builder resultBuilder = CalculatorResponse.newBuilder();
        switch (request.getOperation()) {
            case ADD:
                resultBuilder.setResult(request.getNumber1() + request.getNumber2());
                break;
            case SUBTRACT:
                resultBuilder.setResult(request.getNumber1() - request.getNumber2());
                break;
            case MULTIPLY:
                resultBuilder.setResult(request.getNumber1() * request.getNumber2());
                break;
            case DIVIDE:
                resultBuilder.setResult(request.getNumber1() / request.getNumber2());
                break;
            case UNRECOGNIZED:
                break;
        }
        responseObserver.onNext(resultBuilder.build());
        responseObserver.onCompleted();
    }
}
