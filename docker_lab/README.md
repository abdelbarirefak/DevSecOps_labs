# Docker Lab: From First Container to Secure Image

Hands-on Docker and DevSecOps lab completed for the **DevSecOps (S5)** module. This project follows a small Python web service through the container lifecycle: running and inspecting containers, building an image, improving build efficiency, hardening the image, scanning it, and publishing a versioned image to GitLab Container Registry.

## What I did

- Verified Docker with the `hello-world` image.
- Started an Nginx container, inspected its logs and filesystem, then stopped and removed it. Confirmed that removing a container does not remove its image.
- Built and tested a small Python HTTP greeting service, first locally and then as a Docker image.
- Inspected image layers and demonstrated how Docker's build cache reuses unchanged steps.
- Added a `.dockerignore` to keep local-only files such as `.env`, `.venv`, and `__pycache__` out of the build context.
- Found that the initial image ran as `root`, then created and switched to the unprivileged `appuser` account.
- Used Trivy to check the Dockerfile and verified that the non-root `USER` finding (DS-0002) was cleared after the change.
- Tagged the image with the explicit version `1.1` and pushed it to GitLab Container Registry.
- Cleaned up local Docker resources after publishing.

## Technologies and tools

- Docker and Docker Desktop with WSL2
- Python 3.12
- Trivy
- Git and GitLab Container Registry

## Run the greeting service

### Run locally with Python

From the project directory:

```powershell
cd code
python server.py
```

In another terminal, try the default greeting and a custom name:

```powershell
curl.exe http://localhost:8000/
curl.exe "http://localhost:8000/?name=Ana"
```

The service responds with plain text, for example `Welcome, Ana!`.

### Build and run with Docker

Build from the `code` directory, which contains the Dockerfile and application files:

```powershell
cd code
docker build -t greet:1.1 .
docker run -d --name greet -p 8000:8000 greet:1.1
```

Test the container and verify its runtime user:

```powershell
curl.exe "http://localhost:8000/?name=Ana"
docker exec greet whoami
```

The expected user is `appuser`, not `root`. Stop and remove the container when finished:

```powershell
docker stop greet
docker rm greet
```

## Dockerfile highlights

The final Dockerfile is in [`code/Dockerfile`](code/Dockerfile). It uses the `python:3.12-slim` base image, creates a dedicated `appuser`, switches to that user, and starts the server on port 8000. The `.dockerignore` is in [`code/.dockerignore`](code/.dockerignore).

## Publish to GitLab Container Registry

Publishing requires access to the lab's GitLab registry. Authenticate interactively so the token is not written into a command or this repository, then tag and push the image:

```powershell
docker login registry.gitlab.com
docker tag greet:1.1 registry.gitlab.com/abdelbari-group/devsecops-lab/greet:1.1
docker push registry.gitlab.com/abdelbari-group/devsecops-lab/greet:1.1
```

The explicit `1.1` tag makes the published version identifiable; unlike a floating `latest` tag, it communicates which lab image is being used.

The detailed lab report contains the exercise screenshots and supporting evidence.

## Repository contents

```text
code/                  Python greeting service, Dockerfile, and .dockerignore
Docker_Lab_Report.pdf  Detailed lab report
Docker_Lab_Report.tex  LaTeX source for the report
docker-lab (1).pdf     Original Docker lab handout
README.md              Project overview and run instructions
```

## Further reading

See the [detailed lab report](Docker_Lab_Report.pdf) for the exercise-by-exercise write-up and supporting evidence.
