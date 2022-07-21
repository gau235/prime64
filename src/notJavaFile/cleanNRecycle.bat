rem chcp 65001
rd /s /q C:\tmp
md C:\tmp

rd /s /q %systemdrive%\$Recycle.bin
rd /s /q D:\$Recycle.bin
rd /s /q O:\$Recycle.bin
set path=C:/jdk/bin;%path%;
java -version
java -Dfile.encoding=UTF-8 -cp .;*;C:/*;C:/tmp/*;D:/*; lgpl3.other.sample.Ex132_ShowFreeSpaceOfDisk
pause

================================================================
rem chcp 65001
rd /s /q C:\tmp
rd /s /q C:\Users\gau\AppData\Local\SecondLife
rd /s /q C:\Users\gau\AppData\Local\Firestorm_x64
md C:\tmp

rd /s /q %systemdrive%\$Recycle.bin
rd /s /q D:\$Recycle.bin
rd /s /q O:\$Recycle.bin
rd /s /q Z:\$Recycle.bin

set path=C:/jdk7/bin;
java -version
java -cp *; lgpl3.other.sample.Ex132_ShowFreeSpaceOfDisk
echo off
C:\nircmd-x64\nircmd.exe mutesysvolume 0
pause
