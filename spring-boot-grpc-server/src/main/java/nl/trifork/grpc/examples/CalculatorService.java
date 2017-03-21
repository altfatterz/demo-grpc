package nl.trifork.grpc.examples;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.calculator.CalculatorGrpc;
import nl.trifork.grpc.calculator.CalculatorRequest;
import nl.trifork.grpc.calculator.CalculatorResponse;
import org.lognet.springboot.grpc.GRpcService;

/**
 * @author Zoltan Altfatter
 */
@GRpcService(interceptors = { LogInterceptor.class })
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
