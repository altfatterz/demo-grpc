package nl.trifork.grpc.metric;

import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.metric.MetricOuterClass.Average;
import nl.trifork.grpc.metric.MetricOuterClass.Metric;

/**
 * @author Zoltan Altfatter
 */
public class MetricsServiceImpl extends MetricsServiceGrpc.MetricsServiceImplBase {

    @Override
    public StreamObserver<Metric> collect(StreamObserver<Average> responseObserver) {
        return new StreamObserver<Metric>() {
            private long sum = 0;
            private long count = 0;

            @Override
            public void onNext(Metric value) {
                System.out.println("value: " + value);
                sum += value.getMetric();
                count++;
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(Average.newBuilder()
                        .setVal(sum / count)
                        .build());
            }
        };
    }
}
