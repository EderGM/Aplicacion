pipeline {
    agent {
        label 'nodo'
    }
    stages {
        stage('SCM') {
            steps {
                checkout scm
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'chmod +x gradlew'
                    sh "./gradlew sonar"
                }
            }
        }
        stage('Compilado de Aplicacion') {
            steps {
                sh 'chmod +x build.sh'
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                }
                sh './build.sh'
            }
        }
        stage('Despliegue de Aplicacion en Kubernetes') {
            steps {
                sh 'chmod +x kubernetes_deployment.sh'
                sh './kubernetes_deployment.sh'
            }
        }
    }
}
