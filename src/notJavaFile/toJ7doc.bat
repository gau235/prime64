rem chcp 65001
set path=C:/jdk7/bin;%path%;
javadoc -d C:/tmp/srcTxtNDoc/doc -sourcepath C:/e412/w/w20/src -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 -subpackages . -link https://docs.oracle.com/javase/7/docs/api/ -version
pause