@echo off
cls
color 0A
Echo *******************************************************************************
Echo           正在修改IP地址和DNS服务器地址,请耐心等待…………
Echo *******************************************************************************
cmd /c netsh interface ip set address name="本地连接" source=static addr=192.168.1.100 mask=255.255.255.0 gateway=192.168.1.1 gwmetric=1
cmd /c netsh interface ip set dns name="本地连接" source=static addr=202.99.224.68
cmd /c netsh interface ip add dns name="本地连接" addr=114.114.114.114 index=2
ipconfig /all
Echo *******************************************************************************
Echo          OK！！已修改成功！请按任意键继续…………
Echo          谢谢您的使用！云小飞制作
Echo *******************************************************************************
Pause