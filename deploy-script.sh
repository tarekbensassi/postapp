#!/bin/bash

#Deploy PostgreSQL
kubectl apply -f postappdb-deployment.yaml

# Déploiement avec Docker Compose  Spring App
kubectl apply -f postapp-deployment.yaml


# Déploiement Grafana'
kubectl apply -f grafana-deployment.yaml

# Déploiement PostgreSQL PV and PVC
kubectl apply -f postgres-pv-pvc.yaml