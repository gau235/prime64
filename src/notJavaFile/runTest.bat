set path=C:/jdk/bin;%path%;
del Test.class
java -version
javac -encoding UTF-8 -cp .;*;C:/* Test.java
java -cp .;*;C:/* Test
pause