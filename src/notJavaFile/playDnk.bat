set JAVA_BIN=./jre/bin
set Path=%JAVA_BIN%;%Path%
Path
java -version
java -cp ./prime64Lgpl/prime64Lgpl3.jar; -Xms2g -Xmx11g -XX:CompileThreshold=99 -Dfile.encoding=UTF-8 lgpl3.other.uI.MainToDnk
::pause