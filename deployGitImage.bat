@echo off

REM .env 파일에서 GITHUB_TOKEN 로드
for /F "tokens=* delims=" %%x in (.env) do (
    set "%%x"
)

set GITHUB_USERNAME=youjin92
set IMAGE_NAME=ghcr.io/%GITHUB_USERNAME%/apitest:v1.0.3

echo Logging in to GitHub Container Registry...
echo %GITHUB_TOKEN% | docker login ghcr.io -u %GITHUB_USERNAME% --password-stdin

echo Building Docker image...
docker build -t %IMAGE_NAME% .

echo Pushing Docker image to GitHub Container Registry...
docker push %IMAGE_NAME%

echo Process completed.
pause
