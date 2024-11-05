@echo off

REM 정확한 Java 17 경로로 설정
set JAVA_HOME=C:\Program Files\Java\jdk-17
set PATH=%JAVA_HOME%\bin;%PATH%

REM .env 파일에서 GITHUB_TOKEN 로드
for /F "tokens=* delims=" %%x in (.env) do (
    set "%%x"
)

set GITHUB_USERNAME=youjin92
set IMAGE_NAME=ghcr.io/%GITHUB_USERNAME%/apitest:v1.0.8

echo Running Gradle clean and bootJar tasks...
call gradlew clean bootJar
if %errorlevel% neq 0 (
    echo Gradle build failed.
    exit /b %errorlevel%
)

echo Logging in to GitHub Container Registry...
echo %GITHUB_TOKEN% | docker login ghcr.io -u %GITHUB_USERNAME% --password-stdin

echo Setting up buildx for multi-architecture build...
docker buildx create --use

echo Building multi-architecture Docker image...
docker buildx build --platform linux/amd64,linux/arm64 -t %IMAGE_NAME% --push .

echo Process completed.
pause
