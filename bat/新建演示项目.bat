echo off
set /p input=请输入项目名称:
D:
mkdir D:\王江沛\开发\项目\演示项目\特行\%input%
cd D:\王江沛\开发\项目\演示项目\特行\%input%
mkdir bin doc src
cd doc
mkdir 需求 设计概要 详细设计 说明书 接口说明 测试报告
D:
cd D:\王江沛\项目目录_演示
mklink /j %input% D:\王江沛\开发\项目\演示项目\特行\%input%
pause