set classpath=%~dp0%
java -Xmx1000M -jar rightfield-bin.jar "%classpath%"
@echo off
if errorlevel = 1 goto Error
goto End
:Error
pause
:End
