package ssl.JVM;

public class JVMArgs {

    public static void main(String[] args) {
        String JAVA_OPTS =
                "-Xms4096m –Xmx4096m " +
                "-XX:NewRatio=2 -XX:SurvivorRatio=8 -Xloggc:/home/work/log/serviceName/gc.log -XX:+PrintGCDetails " +
                "-XX:+PrintGCTimeStamps -XX:+PrintGCApplicationStoppedTime -XX:+UseConcMarkSweepGC -XX:+UseParNewGC" +
                "-XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=10 ";
    }
}
