echo off
set /p input=��������Ŀ����:
D:
mkdir D:\������\����\��Ŀ\������Ŀ\����\%input%
cd D:\������\����\��Ŀ\������Ŀ\����\%input%
mkdir bin doc src
cd doc
mkdir ���� ��Ƹ�Ҫ ��ϸ��� ˵���� �ӿ�˵�� ���Ա���
c:
cd C:\Users\Administrator\Desktop/
mklink /j %input% D:\������\����\��Ŀ\������Ŀ\����\%input%
pause