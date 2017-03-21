package nl.trifork.grpc.metric;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import nl.trifork.grpc.metric.MetricOuterClass.Metric;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author Zoltan Altfatter
 */
public class MetricsClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext(true).build();
        MetricsServiceGrpc.MetricsServiceStub stub = MetricsServiceGrpc.newStub(channel);

        StreamObserver<Metric> collect = stub.collect(new StreamObserver<MetricOuterClass.Average>() {
            @Override
            public void onNext(MetricOuterClass.Average value) {
                System.out.println("Average: " + value.getVal());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("error:" + t);
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });

        Stream.of(1L, 2L, 3L, 4L, 5L).map(l -> Metric.newBuilder().setMetric(l).build()).forEach(collect::onNext);
        collect.onCompleted();

        channel.awaitTermination(5, TimeUnit.SECONDS);
        channel.shutdown();
    }
}
