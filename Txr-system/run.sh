
java -Xms256m -Xmx256m -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=heap/txr-system.hprof -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:txr-system.gc -jar txr-system-0.0.1-SNAPSHOT.jar
