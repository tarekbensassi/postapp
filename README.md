# Jenkins Pipeline for Spring Boot Application Deployment

## Overview

This repository contains a Jenkins pipeline script for automating the deployment of a Spring Boot application with a PostgreSQL database on Kubernetes. The pipeline also includes integration with SonarQube for static code analysis and deployment of monitoring tools Grafana and Prometheus.

## Pipeline Stages

### 1. Get Code
This stage retrieves the source code from the specified Git repository.

### 2. Build
This stage is currently commented out (`sh 'mvn clean package'`). Uncomment it if you need to build the Maven project.

### 3. Push Image
Builds and pushes the Docker image to the Docker registry. The image is tagged with the specified version.

### 4. SonarQube Analysis
Performs static code analysis using SonarQube. SonarQube server details are configured in the Jenkins environment. Analysis results are sent to SonarQube for inspection.

### 5. Deploy PostgreSQL
Deploys the PostgreSQL database on Kubernetes using configurations defined in `postappdb-deployment.yaml`.

### 6. Deploy Spring App
Deploys the Spring Boot application on Kubernetes using configurations defined in `postapp-deployment.yaml`.

### 7. Deploy Grafana
Deploys Grafana for monitoring and visualization using configurations defined in `grafana-deployment.yaml`.

### 8. Deploy Prometheus
Deploys Prometheus for monitoring and alerting using configurations defined in `prometheus-deployment.yaml`.

### 9. Deploy PostgreSQL PV and PVC
Deploys Persistent Volumes (PV) and Persistent Volume Claims (PVC) for PostgreSQL using configurations defined in `postgres-pv-pvc.yaml`.

## Configuration

### Environment Variables
- `PATH`: Adds Maven to the system path.
- `DOCKER_IMAGE`: Specifies the Docker image name and tag.
- `SONAR_SCANNER_HOME`: Specifies the SonarQube scanner tool version.

## Running the Pipeline

1. Ensure Jenkins has the required plugins installed for Docker, Kubernetes, and SonarQube integration.
2. Create credentials for Docker registry (`docker-cred`).
3. Configure Jenkins tools with Maven and SonarQube scanner.
4. Create a new Jenkins job and use this pipeline script.

**Note**: Customize the pipeline script based on your project structure, Kubernetes configurations, and Docker registry details.

Refer to the comments in the Jenkinsfile and the individual configuration files for Kubernetes deployments for additional details and explanations.

Feel free to adjust the pipeline according to your specific project requirements and environment.
