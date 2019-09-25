




java -Xmx100m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=txr-system.hprof -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:txr-system.gc -jar target/txr-system-0.0.1-SNAPSHOT.jar
