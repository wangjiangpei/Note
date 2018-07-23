echo off
set /p input=请输入项目名称:
certutil -hashfile %input% MD5 > d:\1.txt
type D:1.txt
pause