@ECHO off
TITLE Aion ChannelChattingServer(Technical Preview) Present By Soulxj(xjplay@yahoo.com)
:START
CLS
IF "%MODE%" == "" (
CALL PanelCS.bat
)
ECHO Starting Aion Lightning Chat Server in %MODE% mode.
D:\AIONSVR\AuthServer\java-1.8.0-openjdk-1.8.0.392-1.b08.redhat.windows.x86_64\bin\JAVA %JAVA_OPTS% -cp ./libs/*;AL-Chat.jar com.aionemu.chatserver.ChatServer
SET CLASSPATH=%OLDCLASSPATH%
IF ERRORLEVEL 2 GOTO START
IF ERRORLEVEL 1 GOTO ERROR
IF ERRORLEVEL 0 GOTO END
:ERROR
ECHO.
ECHO Chat Server has terminated abnormaly!
ECHO.
PAUSE
EXIT
:END
ECHO.
ECHO Chat Server is terminated!
ECHO.
PAUSE
EXIT