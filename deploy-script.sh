#!/bin/bash

#Deploy PostgreSQL
kubectl apply -f postgres-deployment.yaml
kubectl apply -f postgres-service.yaml

# Déploiement avec Docker Compose  Spring App
kubectl apply -f spring-app-deployment.yaml
kubectl apply -f spring-app-service.yaml

# Déploiement Grafana'
kubectl apply -f grafana-deployment.yaml
kubectl apply -f grafana-service.yaml

# Déploiement PostgreSQL PV and PVC
kubectl apply -f postgres-pv-pvc.yaml