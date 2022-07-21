set JAVA_HOME=./jdk
set CATALINA_HOME=./tomcat

call "tomcat/bin/startup.bat"
start "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe" http://127.0.0.1:8080/comb10/wDup/indexDupWMap.jsp
