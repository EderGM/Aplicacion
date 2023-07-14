pipeline {
  environment {
    dockerimagename = "aplicacion"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Checkout Source') {
      steps {
        git 'https://github.com/EderGM/aplicacion.git'
      }
    }
    stage('Build image') {
      steps{
          sh 'chmod +x build.sh'
          sh './build.sh'
      }
    }
    stage('Pushing Image') {
      environment {
               registryCredential = 'dockerhub'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }
    stage('Deploying React.js container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "deployment.yaml", "service.yaml")
        }
      }
    }
  }
}
