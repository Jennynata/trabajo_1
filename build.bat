@echo off
REM Build and run the Java editor project.
REM Usage: build.bat

setlocal

rem Prefer JAVA_HOME if set, otherwise rely on PATH.
if defined JAVA_HOME (
    set "JAVAC=%JAVA_HOME%\bin\javac"
    set "JAVA=%JAVA_HOME%\bin\java"
) else (
    set "JAVAC=javac"
    set "JAVA=java"
)

"%JAVAC%" -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: javac not found.
    echo.
    echo Please install a JDK and ensure javac is on your PATH, or set JAVA_HOME.
    echo For example:
    echo   setx JAVA_HOME "C:\Program Files\Java\jdk-17"
    echo   setx PATH "%%PATH%%;%%JAVA_HOME%%\bin"
    echo.
    echo Then reopen your terminal and run this script again.
    exit /b 1
)

"%JAVAC%" *.java
if errorlevel 1 exit /b 1

echo Compiled successfully.

"%JAVA%" Main
endlocal
