@echo off

REM .env 파일에서 GITHUB_TOKEN 로드
for /F "tokens=* delims=" %%x in (.env) do (
    set "%%x"
)

set GITHUB_USERNAME=youjin92
set IMAGE_NAME=ghcr.io/%GITHUB_USERNAME%/apitest:v1.0.6

echo Logging in to GitHub Container Registry...
echo %GITHUB_TOKEN% | docker login ghcr.io -u %GITHUB_USERNAME% --password-stdin

echo Setting up buildx for multi-architecture build...
docker buildx create --use

echo Building multi-architecture Docker image...
docker buildx build --platform linux/amd64,linux/arm64 -t %IMAGE_NAME% --push .

echo Process completed.
pause
