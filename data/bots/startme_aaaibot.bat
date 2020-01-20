IF "%2"=="" GOTO ERROR

java -cp activation.jar;mailapi.jar;meerkat-api.jar;pokerserver.jar TCPPlugin %1 %2

GOTO END

:ERROR
@ECHO Usage: startme.bat <ipaddress> <portnumber>

:END
