echo off
set /p input=��������Ŀ����:
D:
mkdir D:\������\����\��Ŀ\��ʾ��Ŀ\����\%input%
cd D:\������\����\��Ŀ\��ʾ��Ŀ\����\%input%
mkdir bin doc src
cd doc
mkdir ���� ��Ƹ�Ҫ ��ϸ��� ˵���� �ӿ�˵�� ���Ա���
D:
cd D:\������\��ĿĿ¼_��ʾ
mklink /j %input% D:\������\����\��Ŀ\��ʾ��Ŀ\����\%input%
pause