echo off
set /p input=��������Ŀ����:
certutil -hashfile %input% MD5 > d:\1.txt
type D:1.txt
pause