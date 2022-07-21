:: chcp 65001
md allClass

cd src

set path=../../jdk/bin;%path%;
java -version

javac -encoding UTF-8 -d ../allClass ./lgpl3/other/uI/Main.java
java -cp ../allClass lgpl3/other/uI/Main zoom=1.2

::java -Xmx19g -XX:CompileThreshold=20 -cp .;* -jar prime64Lgpl3.jar
::start javaw -Xbootclasspath/a:./extLib/javax.mail.jar; -Dfile.encoding=UTF-8 -cp ./*; -jar prime64Lgpl3.jar

pause