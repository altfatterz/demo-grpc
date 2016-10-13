package nl.trifork.grpc.examples;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author Zoltan Altfatter
 */
@Component
public class LogInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        System.out.println(call.getMethodDescriptor().getFullMethodName());
        System.out.println(headers);
        return next.startCall(call, headers);
    }
}