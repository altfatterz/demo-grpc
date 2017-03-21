package nl.trifork.grpc.calculator;

import io.grpc.stub.StreamObserver;

/**
 * @author Zoltan Altfatter
 */
public class CalculatorService extends CalculatorGrpc.CalculatorImplBase {

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
